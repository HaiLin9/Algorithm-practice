package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static void main(String args[]) throws Exception {
        manyClient();
    }

    public static void manyClient() throws IOException, InterruptedException {
        String host1 = "192.168.1.4";
        int port1 = 8088;
        String host2 = "192.168.1.4";
        int port2 = 8089;
        for(int i = 40000; i<=40020; i++){
            InetAddress address = InetAddress.getByName("192.168.1.4");
            Socket socket = new Socket(host1, port1, address, i);
            socket.setKeepAlive(true);
            // 建立连接后获得输出流
            OutputStream outputStream = socket.getOutputStream();
            String message=address.getHostAddress() +":"+ i;
            outputStream.write(message.getBytes("UTF-8"));
            outputStream.flush();
//            socket.shutdownOutput();

//            Socket socket2 = new Socket(host2, port2, address, i);
//            // 建立连接后获得输出流
//            OutputStream outputStream2 = socket2.getOutputStream();
//            socket2.getOutputStream().write(message.getBytes("UTF-8"));
//            socket2.shutdownOutput();
        }
        Thread.sleep(99_999);
    }
}
