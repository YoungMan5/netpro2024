package networking.multicastudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPMulticastClient {
        public static void main(String[] argv) throws Exception {
                // データを送信するマルチキャストアドレスとポート
                InetAddress group = InetAddress.getByName("224.0.0.1");
                int port = 5100;

                String str = "HELLO";
                // UDPパケットに含めるデータ
                byte[] sendBuffer = str.getBytes();

                // 送信するUDPパケットを作成
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, group, port);

                // DatagramSocketインスタンスを生成して、UDPパケットを送信
                DatagramSocket socket = new DatagramSocket();
                socket.send(sendPacket);

                // ソケットを閉じる
                socket.close();
        }
}
