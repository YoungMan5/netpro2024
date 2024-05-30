package networking.inet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressToHostName {
    public static void main(String[] args) {
        try {
            // IPアドレスからInetAddressのインスタンスを取得
            InetAddress inetAddress = InetAddress.getByName("93.184.216.34");
            // ホスト名を表示
            System.out.println("Host Name: " + inetAddress.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}