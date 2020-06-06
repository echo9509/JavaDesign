package com.reactor.multireactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author sh
 */
public class StringHandler implements EventHandler {

    private static final String PRE = "server: ";

    @Override
    public void handlerEvent(SelectionKey key)  {
        try {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            int size = socketChannel.read(allocate);
            if (size <= -1) {
                socketChannel.close();
                key.cancel();
                return;
            }
            SubReactor.POOL.submit(() -> {
                try {
                    sendData(socketChannel, process(allocate));
                } catch (Exception e) {
                    e.printStackTrace();
                    key.cancel();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            key.cancel();
        }
    }

    private String process(ByteBuffer allocate) throws InterruptedException {
        allocate.flip();
        int size = allocate.remaining();
        byte[] contentBytes = new byte[size];
        allocate.get(contentBytes);
        System.out.println("server read " + size + " bytes, content:" + new String(contentBytes));
        Thread.sleep(1000L);
        return PRE + new String(contentBytes);
    }

    private void sendData(SocketChannel channel, String response) throws IOException {
        byte[] content = response.getBytes();
        ByteBuffer responseBuffer = ByteBuffer.allocateDirect(content.length);
        responseBuffer.put(content);
        responseBuffer.flip();
        channel.write(responseBuffer);
    }
}
