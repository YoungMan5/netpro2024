package networking.inet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostNameToIPAddress {
    public static void main(String[] args) {
        try {
            // ホスト名からInetAddressのインスタンスを取得
            InetAddress inetAddress = InetAddress.getByName("www.example.com");
            // IPアドレスを表示
            System.out.println("IP Address: " + inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
