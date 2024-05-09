import java.util.Scanner;

public class MyExceptionHoliday {

    public static void main(String[] args) {
        MyExceptionHoliday myE = new MyExceptionHoliday();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("日付を入力してください（例：5/1）qで終了");
                String input = scanner.nextLine();
                if (input.equals("q")) {
                    break;
                }
                System.out.println("日付" + input + "ですね。");
                myE.test(input);
            } catch (NoHolidayException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    void test(String date) throws NoHolidayException {
        if (date.matches("5/(1|2|7|8|9|10|13|14|15|16|17|20|21|22|23|24|27|28|29|30|31)")) {
            throw new NoHolidayException();
        }
    }
}