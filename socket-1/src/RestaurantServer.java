
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class RestaurantServer {
    public static void main(String[] args) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in, "Shift_JIS");
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                try {
            Food food = (Food) ois.readObject();// Integerクラスでキャスト。

            String FoodFromClient = food.getContent();
            System.out.println("料理名：" + FoodFromClient);
            String msgFood = food.getMessage();
            System.out.println("料理に関するメモ：" + msgFood);

            Random random = new Random();
            int randomMoney = 1000 + random.nextInt(2001); // 1000から3000円

            Food response = new Food();
            response.setMoney( randomMoney );
            response.setMessage("レストランです。注文承りました！" + response.getMoney() + "円になります！" );
            response.setContent( FoodFromClient );

            oos.writeObject(response);
            oos.flush();

            int receivedMoney = ois.readInt();
                System.out.println("受信したお金: " + receivedMoney + "円");
            } catch (Exception e) {
                break; // クライアントが終了した場合、ループを抜ける
            }
        }

            // close処理

            ois.close();
            oos.close();
            // socketの終了。
            socket.close();
            server.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}