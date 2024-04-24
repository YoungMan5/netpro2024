// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader というのは、データ読み込みのクラス(型)
			// クラスの変数を作るには、new を使う。

			// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
			//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
	while (true) {
		try {
			System.out.println("何歳ですか?(qまたはeで終了)");
			String line = reader.readLine();
			if (line.equalsIgnoreCase("q") || line.equalsIgnoreCase("e")) {
				System.out.println("終了します");
				break;
			}
			int age = Integer.parseInt(line);
			if (age < 0 || age >= 120) {
				System.out.println("正しい年齢を入力してください。");
				continue;
			} 
			System.out.println("あなたは" + age + "歳ですね。");
			System.out.println("あなたは2030年、" + (age + 2030-2024) + "歳ですね。");
			int era = 2024 - age;
			String eraName;
			if (era >= 1868 && era <= 1911) {
				eraName = "明治" + (era - 1867) + "年";
			} else if (era == 1912) {
				eraName = "大正" + (era - 1911) + "年";
			} else if (era >= 1926 && era <= 1988) {
				eraName = "昭和" + (era - 1925) + "年";
			} else if (era >= 1989 && era <= 2018) {
				eraName = "平成" + (era - 1988) + "年";
			} else if (era >= 2019) {
				eraName = "令和" + (era - 2018) + "年";
			} else {
				eraName = "エラー";
			}
			System.out.println("あなたが誕生した元号は,"+ eraName +"ですね。");
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

	}
}