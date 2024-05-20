import java.io.Serializable;

public class TaskObject implements Serializable, ITask {

    int x;

    public void setExecNumber(int x) {
        this.x = x;
    }

    public void exec() {
        int maxPrime = -1;

        for (int n = x; n >= 2; n--) {
            if (isPrime(n) == true) {
                maxPrime = n;
                break;
            }
        }
        if (maxPrime == -1) {
            System.out.println("素数が見つかりませんでした");
        } else {
            x = maxPrime;
            System.out.println("最大の素数: " + x);
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public int getResult() {
        return x;
    }
}