package com.reactor.multireactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 单Reactor多线程
 *
 * @author sh
 */
public class MainReactorServer {

    private final SubReactor[] workerHandlers;
    private final Selector selector;
    private final AtomicInteger nextHandler = new AtomicInteger(0);

    public MainReactorServer(int port) throws IOException {
        this.selector = Selector.open();
        workerHandlers = new SubReactor[Runtime.getRuntime().availableProcessors()];
        Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];
        for (int i = 0; i < workerHandlers.length; i++) {
            workerHandlers[i] = new SubReactor();
            threads[i] = new Thread(workerHandlers[i]);
            threads[i].start();
        }
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void run() throws Exception {
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectionKeys) {
                SubReactor subReactor = workerHandlers[nextHandler.getAndAdd(1)];
                subReactor.addChannel(((ServerSocketChannel)selectionKey.channel()).accept());
                if (nextHandler.get() >= workerHandlers.length) {
                    nextHandler.set(0);
                }
            }
            selector.selectedKeys().clear();
        }
    }

    public static void main(String[] args) throws Exception {
        MainReactorServer server = new MainReactorServer(8080);
        server.run();
    }
}
