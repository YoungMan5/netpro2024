
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {
    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in, "Shift_JIS");
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
                System.out.println("料理名を入力してください。(例:カレーライス, quit で終了) ↓");
                String content = scanner.next();
                if (content.equalsIgnoreCase("quit") || content.equalsIgnoreCase("exit")) {
                    break;
                }
            System.out.println("料理に関するメモ（例：トマト抜き） ↓");
            String message = scanner.next();

            Food food = new Food();
            food.setMessage(message);
            food.setContent(content);

            oos.writeObject(food);
            oos.flush();

            Food receivefood = (Food) ois.readObject();

            String replayMsg = receivefood.getMessage();
            System.out.println(replayMsg);
            String replayContent = receivefood.getContent();
            System.out.println(replayContent + "をもらいました！");
            int replayMoney = receivefood.getMoney();
            System.out.println("値段は" + replayMoney + "円です。");
            int money = -1;
            while (true) {
                System.out.println("入力してください。(例：1000)");
                try {
                    money = scanner.nextInt();
                    if (money != replayMoney) {
                        System.out.println("金額が一致しません。再度入力してください。");
                        continue;
                    }
                    break; // 正しい入力の場合ループを抜ける
                } catch (InputMismatchException e) {
                    System.out.println("無効な入力です。整数を入力してください。");
                    scanner.next(); // 無効な入力をクリアする
                }
            }
            
            oos.writeInt(money);
            oos.flush();
        }

            scanner.close();
            ois.close();
            oos.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}

