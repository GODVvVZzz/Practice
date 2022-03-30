package chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import java.net.InetSocketAddress;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author HP
 * @date 2022/3/29
 */
public class UdpSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        //准备数据：控制台读取System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost",6666));

            if (data.equals("bye")){
                break;
            }
            socket.send(packet);
        }


        socket.close();
    }
}
