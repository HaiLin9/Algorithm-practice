package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NIOServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<SocketChannel> list = new ArrayList<>();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress("127.0.0.1", 9099));
        server.configureBlocking(false);
        while(true){
            SocketChannel socket = server.accept();
            if(socket!=null){
                socket.configureBlocking(false);
                list.add(socket);
            }

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            Iterator<SocketChannel> iterator = list.iterator();
            while (iterator.hasNext()){
                SocketChannel client = iterator.next();
                int count = client.read(byteBuffer);
                if (count != -1) {
                    byteBuffer.flip();
                    boolean print = false;
                    while (byteBuffer.hasRemaining()) {
                        if(!print){
                            System.out.printf("client %s send:", client.getRemoteAddress());
                            print = true;
                        }
                        System.out.print((char) byteBuffer.get());
                    }
                    byteBuffer.clear();
                } else {
                    System.out.printf("client %s removed.", client.getRemoteAddress());
                    client.close();
                    iterator.remove();
                }
            }
            Thread.sleep(400);
        }
    }
}
