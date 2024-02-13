import javax.xml.transform.sax.SAXResult;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
 /*
 Задача 1
Объявите три массива:
Целочисленный массив, заполненный тремя цифрами — 1, 2 и 3 — с помощью ключевого слова
new
 */
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
 /*
 Массив, в котором можно хранить три дробных числа
 — 1.57, 7.654, 9.986. Массив сразу заполните значениями.
 */
        double[] doubles = new double[3];
        doubles[0] = 1.57;
        doubles[1] = 7.654;
        doubles[2] = 9.986;
 /*
Произвольный массив. Тип и количество данных определите сами.
Самостоятельно выберите способ создания массива: с помощью ключевого слова или сразу заполненный элементами.
 */
        String[] strs = new String[]{"Soda", "Oil", "Gaz"};
/*
 Задача 2
Распечатайте на отдельной строчке элементы каждого массива по порядку через запятую.
В конце строки запятую ставить не надо.
*/
        System.out.println("============== хотелось бы так выполнить задание============================================\n");
        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(doubles).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(Arrays.stream(strs).map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println("============== хотя можно и проще выполнить это задание============================================\n");
        String str = ", ";
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d", nums[i]);
            if (i == nums.length - 1) {
                break;
            }
            System.out.print(str);
        }

        out.println();

        for (int i = 0; i < doubles.length; i++) {
            System.out.printf("%.2f", doubles[i]);
            if (i == doubles.length - 1) {
                break;
            }
            System.out.print(str);
        }
        out.println();
        for (int i = 0; i < strs.length; i++) {
            System.out.printf("%s", strs[i]);
            if (i == strs.length - 1) {
                break;
            }
            System.out.print(str);
        }
        out.println();
        out.println("\nЗадача №3");
/*
 Задача 3
Распечатайте на отдельной строчке элементы каждого массива в обратном порядке через запятую.
В конце строки запятую ставить не надо.
*/
        int i = nums.length - 1;
        while (i > -1) {
            System.out.printf("%d", nums[i]);
            if (i == 0) {
                break;
            }
            System.out.print(str);
            i--;
        }

        int j = doubles.length - 1;
        out.println(i);
        while (j > -1) {
            System.out.printf("%.2f", doubles[j]);
            if (j == 0) {
                break;
            }
            System.out.print(str);
            j--;
        }

        int k = strs.length - 1;
        out.println(i);
        while (k > -1) {
            System.out.printf("%s", strs[k]);
            if (k == 0) {
                break;
            }
            System.out.print(str);
            k--;
        }
        out.println();
        out.println("\nЗадача №4");
 /*
 Задача 4
Пройдитесь по первому целочисленному массиву и все нечетные числа в нем сделайте четными (нужно прибавить 1).
Важно: код должен работать с любым целочисленным массивом, поэтому для решения задания используйте циклы.
Распечатайте результат преобразования в консоль.
*/
        for (int l = 0; l < nums.length; l++) {
            if (nums[l] % 2 != 0) {
                nums[l] += 1;
            }
            System.out.printf("%d", nums[l]);
            if (l == nums.length - 1) {
                break;
            }
            System.out.print(str);
        }
    }
}