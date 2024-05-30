package networking.inet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MultipleInetAddressExample {
    public static void main(String[] args) {
        try {
            // ホスト名からすべてのInetAddressインスタンスを取得
            InetAddress[] inetAddresses = InetAddress.getAllByName("www.google.com");
            // 取得したすべてのIPアドレスを表示
            for (InetAddress inetAddress : inetAddresses) {
                System.out.println("IP Address: " + inetAddress.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
