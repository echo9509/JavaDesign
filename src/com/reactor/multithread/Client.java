package com.reactor.multithread;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sh
 */
public class Client {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                try {
                    SocketChannel socketChannel = SocketChannel.open();
                    socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
                    Random random = new Random();
                    String content = String.valueOf(random.nextInt(1000));
                    ByteBuffer buffer = ByteBuffer.wrap((content.getBytes()));
                    buffer.clear();
                    socketChannel.write(buffer);
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    socketChannel.read(allocate);
                    allocate.flip();
                    byte[] response = new byte[allocate.remaining()];
                    allocate.get(response);
                    System.out.println(new String(response));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("end");
    }
}
