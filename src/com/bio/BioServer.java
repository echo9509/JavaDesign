package com.bio;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sh
 */
public class BioServer {

    private final ExecutorService executorService;

    private final int port;

    public BioServer(int port) {
        executorService = Executors.newFixedThreadPool(100);
        this.port = port;
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        while (!Thread.currentThread().isInterrupted()) {
            Socket socket = serverSocket.accept();
            executorService.submit(new IoHandler(socket));
        }
    }


    private static class IoHandler implements Runnable {

        private Socket socket;

        public IoHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {
                    // 读取数据
                    String data = readData(socket.getInputStream());
                    // 处理数据
                    String response = handlerData(data);
                    // 写入数据
                    writeResponse(socket.getOutputStream(), response);
                }
            } catch (Exception e) {
                System.out.println("io handler occur error. " + e.getMessage());
            }
        }

        private void writeResponse(OutputStream out, String data) throws IOException {
            out.write(data.getBytes());
        }

        private String handlerData(String data) {
            System.out.println(data);
            return data;
        }

        private String readData(InputStream input) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        }
    }
}
