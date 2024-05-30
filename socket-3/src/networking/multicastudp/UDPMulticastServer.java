package networking.multicastudp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPMulticastServer {
    public static void main(String[] argv) throws Exception {
        // ポート5100でマルチキャストソケットを作成
        MulticastSocket multicastSocket = new MulticastSocket(5100);
        
        // アドレス224.0.0.1のマルチキャストグループに参加
        InetAddress group = InetAddress.getByName("224.0.0.1");
        multicastSocket.joinGroup(group);
        
        // 受信用バッファを作成
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        
        while (true) {
            // UDPパケットを受信
            multicastSocket.receive(receivePacket);
            
            // 受信したデータを標準出力に表示
            System.out.println(new String(receivePacket.getData(), 0, receivePacket.getLength()));
        }
    }
}
