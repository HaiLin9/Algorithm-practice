package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        System.out.println("server将一直等待连接的到来");
        Socket socket = server.accept();

        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len,"UTF-8"));
        }
        System.out.println("get message from client: " + sb);

        OutputStream outputStream = socket.getOutputStream();
        Thread.sleep(100000);
        outputStream.write("Hello Client,I get the message.".getBytes("UTF-8"));
        outputStream.close();
        inputStream.close();
        socket.close();
        server.close();
    }
}
