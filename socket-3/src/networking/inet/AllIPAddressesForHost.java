package networking.inet;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class AllIPAddressesForHost {
    public static void main(String[] args) {
        try {
            // ホスト名から全てのInetAddressインスタンスを取得
            InetAddress[] inetAddresses = InetAddress.getAllByName("www.dendai.ac.jp");
            // すべてのIPアドレスを表示
            for (InetAddress inetAddress : inetAddresses) {
                System.out.println("IP Address: " + inetAddress.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
