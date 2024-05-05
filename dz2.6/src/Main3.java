import java.util.*;
/*
Напишите код, который выводит в консоль все уникальные слова из списка слов,
в котором могут встречаться дубли. Код должен работать с любой последовательностью и объемом списка слов.
*/

public class Main3 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("солнце","луна", "звезды", "ветер", "солнце", "дождь", "снег", "ночь", "день", "ветер", "снег"));
        printUniqWords(words);
    }

    public static void printUniqWords(List<String> arr) {
        var res = new HashSet<String>();
        for (String word : arr) {
            res.add(word);
        }
        System.out.print(String.join(", ", res));
    }
}
