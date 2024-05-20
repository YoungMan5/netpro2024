import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in, "UTF-8");
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            while (true) {
                System.out.println("入力値x以下の最大素数を求める。");
                System.out.println("値xを入力してください （例：10）");
                System.out.println("終了する場合は 'q' を入力してください");

                String input = scanner.next();

                if (input.equalsIgnoreCase("q")) {
                    break; // 'q' が入力されたらループを抜ける
                }

                int x;
                try {
                    x = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("無効な入力です。再度入力してください。");
                    continue;
                }

                if (x <= 1) {
                    System.out.println("入力値が1以下のため、終了します。");
                    break; // 入力値が1以下ならループを抜ける
                }

                TaskObject task = new TaskObject();
                task.setExecNumber(x);

                oos.writeObject(task);
                oos.flush();

                TaskObject result = (TaskObject) ois.readObject();

                int replayNumber = result.getResult();
                System.out.println("計算結果は" + replayNumber + "\n");

            }
            ois.close();
            oos.close();
            socket.close();
            scanner.close();
        } catch (BindException be) {
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
