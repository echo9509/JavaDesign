package com.reactor.signlethread;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author sh
 */
public class ReadStringHandler implements EventHandler {

    private final String PRE = "server: ";

    @Override
    public void handlerEvent(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        int size = socketChannel.read(allocate);
        allocate.flip();
        byte[] contentBytes = new byte[size];
        allocate.get(contentBytes);
        System.out.println("server read " + size + " bytes, content:" + new String(contentBytes));
        ByteBuffer responseBuffer = ByteBuffer.allocateDirect(PRE.length() + size);
        socketChannel.write(allocate);
    }
}
