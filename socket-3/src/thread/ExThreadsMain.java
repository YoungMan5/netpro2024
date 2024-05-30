package thread;

public class ExThreadsMain implements Runnable {

    private int n;

    public void setsum(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        // 26個の文字を初期化
        int[] sum = new int[3];
            sum[0] = 100;
            sum[1] = 200;
            sum[2] = 300;

        // CountAZTenRunnable クラスのインスタンス
        ExThreadsMain[] ct = new ExThreadsMain[3];
        Thread[] threads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            ct[i] = new ExThreadsMain();
            threads[i] = new Thread(ct[i], "th-" + String.valueOf(i));
            ct[i].setsum(sum[i]);
            threads[i].start();
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(String.valueOf(n) + "を"+ i +"倍したもの:" + n * i);

                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(100); // ミリ秒単位のスリープ時間
            }
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
}
