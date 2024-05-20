import java.net.InetAddress;
import java.net.UnknownHostException;

public class CheckLocalAddreess {
    public static void main(String[] args) {
        try {
            // 指定されたIPアドレスからInetAddressオブジェクトを取得
            InetAddress addr = InetAddress.getByName("8.8.8.8");
            
            // ホスト名を取得
            System.out.println("Host name is: " + addr.getHostName());
            
            // IPアドレスを取得
            System.out.println("IP address is: " + addr.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}