package com.reactor.signlethread;

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
        channel.bind(new InetSocketAddress(port));
        AcceptHandler acceptHandler = new AcceptHandler(selector);
        SelectionKey acceptKey = channel.register(this.selector, SelectionKey.OP_ACCEPT);
        acceptKey.attach(acceptHandler);
    }

    public void run() throws IOException {
        while (!Thread.interrupted()) {
            int select = selector.select();
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
}
