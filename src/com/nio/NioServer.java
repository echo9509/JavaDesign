package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sh
 */
public class NioServer {

    private final Selector selector;

    public NioServer(int port) throws IOException {
        this.selector = Selector.open();
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.socket().bind(new InetSocketAddress(port));
        channel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    dispatch(iterator.next());
                    iterator.remove();
                }
            } catch (IOException e) {
                System.out.println("nio server error." + e.getMessage());
            }
        }
    }

    private void dispatch(SelectionKey key) throws IOException {
        try {
            if (key.isAcceptable()) {
                // 新连接建立
                register(key);
            } else if(key.isReadable()) {
                readData(key);
            } else if (key.isWritable()) {
                writerData(key);
            }
        } catch (Exception e) {
            System.out.println("nio server dispatch task error." + e.getMessage());
            key.cancel();
        }
    }

    private void writerData(SelectionKey key) {
    }

    private void readData(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        if (buffer.hasRemaining()) {
            System.out.println(new String(buffer.array()).trim());
        }
        buffer.clear();
        //写回数据
        channel.register(selector, SelectionKey.OP_WRITE);
        channel.write(buffer);
    }

    private void register(SelectionKey key) throws IOException {
        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = channel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(this.selector, SelectionKey.OP_READ);
    }

    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer(9090);
        nioServer.run();
    }
}
