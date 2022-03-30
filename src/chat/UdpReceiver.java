package chat;


import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * @author HP
 * @date 2022/3/29
 */
public class UdpReceiver {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);

        while (true){
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            socket.receive(packet);

            //断开连接bye
            byte[] data = packet.getData();
            String receiveData = new String(data,0,data.length).trim();

            System.out.println(receiveData);
            if(receiveData.equals("bye")){
                break;
            }
        }

        socket.close();
    }
}
