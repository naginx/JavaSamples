package Algolithm;

/**
 * 線形探索を行うクラス
 * 平均計算量 O(n)
 * 1. 渡された配列の先頭から要素を取り出し
 * 2. 要素の値と目的の値を比較
 *      ・一致すれば探索を完了し、要素の順番を出力
 *      ・一致しなければ1へ戻り、最後の要素まで一致しなければ"Not Found"を出力
 */
public class LinearSearch {
    public static int execute(int[] data, int target) {
        int notFound = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return notFound;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        int result;
        result = LinearSearch.execute(data, 3);
        if (result != -1) {
            System.out.println("Found: index key =" + result);
        } else {
            System.out.println("Not Found.");
        }
    }
}
