import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HeikinCKadai {
    public static final int N = 100;
    static Kamoku[] MathScores = new Kamoku[N];

    public static void main(String[] args) {

        Random random = new Random();
        int sum = 0;
        int ave = 0;
        for (int i = 0; i < N; i++) {
            MathScores[i] = new Kamoku(random.nextInt(N + 1));
            sum += MathScores[i].getScore();
        }
        ave = sum / N;
        System.out.println("数学の平均点は" + ave + "ですね");
        System.out.println("以下合格者の点数です");
        ArrayList<Integer> Successfulapplicants = new ArrayList<>();
        for (Kamoku k : MathScores) {
            if (k.getScore() >= 80) {
                Successfulapplicants.add(k.getScore());
            }
        }
        Collections.sort(Successfulapplicants);
        for (Integer score : Successfulapplicants) {
            System.out.println(score);
        }
    }
}

class Kamoku {
    String name;
    int score;
    private int studentid;

    Kamoku(int s) { // これがコンストラクタ。特殊なメソッド。クラス名と同じ。
        score = s;
    }

    // setScore というメソッドを定義する。
    // score に値を設定する。
    public void setScore(int num) {
        score = num;
    }

    // getScore というメソッドを定義する。
    // scoreを返す。
    public int getScore() {
        return score;
    }
}
