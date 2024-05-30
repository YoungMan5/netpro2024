package networking.inet;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ReachabilityCheck {
    public static void main(String[] args) {
        try {
            // ホスト名からInetAddressのインスタンスを取得
            InetAddress inetAddress = InetAddress.getByName("www.dendai.ac.jp");
            // ホストの可達性を確認（タイムアウトは5000ミリ秒）
            boolean reachable = inetAddress.isReachable(5000);
            // 結果を表示
            System.out.println("Is host reachable? " + reachable);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
