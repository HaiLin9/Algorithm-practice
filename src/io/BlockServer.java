package io;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket  = new ServerSocket();
        socket.bind(new InetSocketAddress("127.0.0.1", 9099));
        while(true) {
            Socket client = socket.accept();
            System.out.println(client.getInetAddress().getHostAddress()+":" + client.getPort());
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream input = client.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println("I am server, and client message:：" + line);
                        }
                        System.out.println("I am server, and client closed. client: " + client.getInetAddress().getHostAddress()+":" + client.getPort());
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            Thread.sleep(600);
        }
    }
}
