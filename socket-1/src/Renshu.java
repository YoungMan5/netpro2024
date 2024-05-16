public class Renshu {

    // xを2倍にして返すメソッド
    public int doubleValue(int x) {
        return x * 2;
    }

    // 1からnまでの整数の合計を計算するメソッド
    public int sumUpToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // pからqまでの整数の合計を計算するメソッド
    public int sumFromPtoQ(int p, int q) {
        if (p > q) {
            return -1; // p > qの場合、-1を返す
        }
        int sum = 0;
        for (int i = p; i <= q; i++) {
            sum += i;
        }
        return sum;
    }

    // 配列aの指定されたインデックスから末尾までの要素の合計を計算するメソッド
    public int sumFromArrayIndex(int[] a, int index) {
        if (index < 0 || index >= a.length) {
            return -1; // インデックスが無効な場合、-1を返す
        }
        int sum = 0;
        for (int i = index; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    // 配列から最大値を選択するメソッド
    public int selectMaxValue(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    // 配列から最小値を選択するメソッド
    public int selectMinValue(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    // 配列から最大値のインデックスを選択するメソッド
    public int selectMaxIndex(int[] a) {
        int max = a[0];
        int maxIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // 配列から最小値のインデックスを選択するメソッド
    public int selectMinIndex(int[] a) {
        int min = a[0];
        int minIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // 配列の指定された位置の要素を入れ替えるメソッド
    public void swapArrayElements(int[] array, int i, int j) {
        if (i >= 0 && i < array.length && j >= 0 && j < array.length) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // 2つの配列の要素を交換するメソッド
    public boolean swapTwoArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false; // 長さが異なる場合、交換不可とする
        }
        for (int i = 0; i < array1.length; i++) {
            int temp = array1[i];
            array1[i] = array2[i];
            array2[i] = temp;
        }
        return true;
    }
}