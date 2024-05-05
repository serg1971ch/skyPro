import java.util.List;
import java.util.ArrayList;
/*
## Задание 1

Напишите код, с помощью которого можно напечатать только нечетные числа в консоль.
Код должен работать с любой последовательностью и объемом списка чисел.
 */


public class Main1 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        printOddNumbers((ArrayList<Integer>) nums);
    }

    public static void printOddNumbers(ArrayList<Integer> arr) {
        var res = new ArrayList<String>();

        for (int x : arr) {
            if (x % 2 != 0) {
                res.add(Integer.toString(x));
            }
        }
        System.out.print(String.join(", ", res));
    }
}