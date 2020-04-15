import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {

        // カードの枚数を受け取る
        Scanner scn = new Scanner(System.in);
        int count = scn.nextInt();

        // 枚数を元にカードを受け取る
        Scanner scan = new Scanner(System.in);
        String[] cardsStr = scan.nextLine().split(" ");
        ArrayList<Integer> cards = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            cards.add(Integer.parseInt(cardsStr[i]));
        }

        // 配列を昇順にソートする
        cards.sort(Collections.reverseOrder());

        // 配列の偶数番をAliceの得点合計に加算
        // 配列の奇数番をBobの得点合計に加算
        int aliceTotal = 0;
        int bobTotal = 0;
        for (int j = 0; j < count; j++) {
            if (j % 2 == 0) {
                aliceTotal += cards.get(j);
            } else {
                bobTotal += cards.get(j);
            }
        }

        // ①-②を出力
        System.out.println(aliceTotal - bobTotal);
    }
}
