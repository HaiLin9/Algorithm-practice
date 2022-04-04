package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hailin6
 * @version 2022/1/24
 */
public class SocketServer2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            // 创建服务端socket
            ServerSocket serverSocket = new ServerSocket(8088, 50, InetAddress.getByName("192.168.1.4"));

            // 创建客户端socket
            Socket socket = new Socket();

            //循环监听等待客户端的连接
            while(true){
                // 监听客户端
                socket = serverSocket.accept();

                ServerThread thread = new ServerThread(socket);
                thread.start();

                InetAddress address=socket.getInetAddress();
                System.out.println("当前客户端的IP："+address.getHostAddress());
                Thread.sleep(30);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
