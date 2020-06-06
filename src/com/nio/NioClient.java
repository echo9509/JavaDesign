package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sh
 */
public class NioClient {

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(500);
        for (int i = 0; i < 500; i++) {
            executors.submit(() -> {
                try {
                    SocketChannel socketChannel = SocketChannel.open();
                    socketChannel.connect(new InetSocketAddress("127.0.0.1", 9090));
                    ByteBuffer buffer = ByteBuffer.wrap(("hhh".getBytes()));
                    buffer.clear();
                    socketChannel.write(buffer);
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    socketChannel.read(allocate);
                    System.out.println(new String(allocate.array()));
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
