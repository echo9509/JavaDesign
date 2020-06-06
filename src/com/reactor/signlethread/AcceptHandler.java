package com.reactor.signlethread;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author sh
 */
public class AcceptHandler implements EventHandler{

    private final Selector selector;

    public AcceptHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void handlerEvent(SelectionKey key) throws IOException {
        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = channel.accept();
        SelectionKey channelKey = socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        channelKey.attach(new ReadStringHandler());
    }
}
