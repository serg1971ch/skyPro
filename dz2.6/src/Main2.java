import java.util.*;
/*
Напишите код, с помощью которого можно напечатать только четные числа без повторений в порядке возрастания.
Код должен работать с любой последовательностью и объемом списка чисел.
 */

public class Main2 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        printEvenNumbers((ArrayList<Integer>) nums);
    }

    public static void printEvenNumbers(ArrayList<Integer> arr) {
        var res = new HashSet<String>();
        int i = arr.size() - 1;
        while (i > -1) {
            if (i == 0) {
                break;
            }
            i++;
        }
        for (int x : arr) {
            if (x % 2 == 0) {
                res.add(Integer.toString(x));
            }
        }
        System.out.print(String.join(", ", res));
    }
}
