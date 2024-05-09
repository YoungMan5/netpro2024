public class XmasTreeKadai {
    public static void main(String[] args) {
        String snow = "`";
        String leaf = "*";
        int N = 16;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - i; j++) {
                System.out.print(snow);
            }
            for (int j = 0; j < i; j++) {
                System.out.print(leaf);
                System.out.print(leaf);
            }
            for (int j = 0; j <= N - i; j++) {
                System.out.print(snow);
            }
            System.out.print("\n");
        }

        for (int i = 0; i <= 8; i++) {
            System.out.print("　　　　　　　 ");
            System.out.print("****");
            System.out.print("\n");
        }
        for (int i = 0; i <= 8; i++) {
        }
    }
}
