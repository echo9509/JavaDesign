package com.reactor.multireactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单Reactor多线程
 *
 * @author sh
 */
public class SubReactor implements Runnable {

    private final ConcurrentLinkedQueue<SocketChannel> channels = new ConcurrentLinkedQueue<>();

    public static final ExecutorService POOL = Executors.newFixedThreadPool(100);

    private final Selector selector;

    public SubReactor() throws IOException {
        this.selector = Selector.open();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int select = selector.select(100);
                handleAcceptChannel();
                if (select <= 0) {
                    continue;
                }
                Set<SelectionKey> readyHandlers = selector.selectedKeys();
                for (SelectionKey selectionKey : readyHandlers) {
                    if (selectionKey.isReadable() || selectionKey.isWritable()) {
                        EventHandler eventHandler = (EventHandler) selectionKey.attachment();
                        eventHandler.handlerEvent(selectionKey);
                    }
                }
                readyHandlers.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addChannel(SocketChannel channel) {
        channels.add(channel);
    }

    private void handleAcceptChannel() throws IOException {
        SocketChannel channel;
        while ((channel = channels.poll()) != null) {
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ, new StringHandler());
        }
    }
}
