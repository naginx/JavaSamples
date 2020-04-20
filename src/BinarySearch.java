import java.util.*;

/**
 * 二分探索を行うクラス
 * 平均計算量 O(log n)
 * 1. 配列をソートする
 * 2. 配列の中央にある要素を調べる
 * 3. 中央の要素が目的の値ではなく、目的の値が中央の値より大きい場合、中央より後ろの値を調べる。
 *    中央の要素が目的の値ではなく、目的の値が中央の値より小さい場合、中央より前の値を調べる。
 * 4. 2に戻る
 */
public class BinarySearch {
    public static boolean execute(int[] data, int target) {
        int startIndex = 0;
        int endIndex = data.length - 1;
        while (startIndex <= endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            if (data[middleIndex] == target) {
                return true;
            } else if (data[middleIndex] < target) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data = {23, 35, 98, 25, 53, 5466, 12646};
        Arrays.sort(data);
        boolean result;
        result = BinarySearch.execute(data, 25);
        if (result) {
            System.out.println("Found.");
        } else {
            System.out.println("Not Found.");
        }
    }
}
