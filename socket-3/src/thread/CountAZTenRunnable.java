package thread;

public class CountAZTenRunnable implements Runnable {

    private char Char;

    public void setChar(char Char) {
        this.Char = Char;
    }

    public static void main(String[] args) {
        // 26個の文字を初期化
        char[] chars = new char[26];
        for (int i = 0; i < 26; i++) {
            chars[i] = (char) (97 + i);
        }

        // CountAZTenRunnable クラスのインスタンス
        CountAZTenRunnable[] ct = new CountAZTenRunnable[26];
        Thread[] threads = new Thread[26];

        for (int i = 0; i < 26; i++) {
            ct[i] = new CountAZTenRunnable();
            threads[i] = new Thread(ct[i], "th-" + String.valueOf(i));
            ct[i].setChar(chars[i]);
            threads[i].start();
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Char + String.valueOf(i));

                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(100); // ミリ秒単位のスリープ時間
            }
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
}
