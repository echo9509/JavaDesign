package com.reactor.singlethread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sh
 */
public class RectorServer {

    private Selector selector;

    public RectorServer(int port) throws IOException {
        this.selector = Selector.open();
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.socket().bind(new InetSocketAddress(port));
        AcceptHandler acceptHandler = new AcceptHandler(this.selector);
        SelectionKey acceptKey = channel.register(this.selector, SelectionKey.OP_ACCEPT);
        acceptKey.attach(acceptHandler);
    }

    public void run() throws IOException {
        while (!Thread.interrupted()) {
            selector.select();
            Set<SelectionKey> readyHandlers = selector.selectedKeys();
            Iterator<SelectionKey> handlerIterator = readyHandlers.iterator();
            while (handlerIterator.hasNext()) {
                SelectionKey selectionKey = handlerIterator.next();
                EventHandler eventHandler = (EventHandler) selectionKey.attachment();
                eventHandler.handlerEvent(selectionKey);
            }
            readyHandlers.clear();
        }
    }

    public static void main(String[] args) throws IOException {
        RectorServer server = new RectorServer(8080);
        server.run();
    }
}
