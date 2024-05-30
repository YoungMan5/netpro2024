package networking.inet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHostIPAddress {
    public static void main(String[] args) {
        try {
            // ローカルホストのInetAddressを取得
            InetAddress inetAddress = InetAddress.getLocalHost();
            // IPアドレスを表示
            System.out.println("Local IP Address: " + inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
