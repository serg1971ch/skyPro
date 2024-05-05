import java.util.*;

/*
## Задание 4

Напишите код, который выводит в консоль количество дублей для каждого уникального слова.
Код должен работать с любой последовательностью и объемом списка слов.
В качестве отладочной информации используйте:
 */
public class Main4 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("один", "два", "два", "два", "три", "три", "три", "четыре", "четыре", "четыре"));
        printDoubleWords(strings);
    }

    public static void printDoubleWords(List<String> arr) {
        var res = findDoubles(arr);
        for (Map.Entry<String,Integer> entry : res.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static HashMap<String, Integer> findDoubles(List<String> arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String stroke : arr) {
            if (!map.containsKey(stroke)) {
                map.put(stroke, 0);
            }
            map.put(stroke, map.get(stroke) + 1);
        }
        return map;
    }
}

