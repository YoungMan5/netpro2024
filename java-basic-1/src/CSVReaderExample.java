import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderExample {
public static void main(String[] args) {
String csvFile = "path/to/your/csv/jusho.csv"; // ファイルのパスを指定してください
String line = "";
String csvSplitBy = ","; // CSVファイルの区切り文字を指定してください

try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        while ((line = br.readLine()) != null) {
            // 1行をカンマで分割して単語の配列を取得
            String[] words = line.split(csvSplitBy);

            if (words.length >= 4) {
                String ku = words[3];
                System.out.println(ku);
            }
        }//while end
    } catch (IOException e) {
        e.printStackTrace();
    }
}//main end
}//class end