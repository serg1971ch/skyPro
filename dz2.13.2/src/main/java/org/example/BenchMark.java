package org.example;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class BenchMark {
    public static void main(String[] args) {
        System.out.printf("Среднее время выполнение сортировки пузырьком: %d ms %n", calculateExecuteCodeTime(10, 10000, BenchMark::sortBubble));
        System.out.printf("Среднее время выполнение сортировки выбором: %d ms %n", calculateExecuteCodeTime(10, 10000, BenchMark::sortSelection));
        System.out.printf("Среднее время выполнение сортировки вставками: %d ms %n", calculateExecuteCodeTime(10, 10000, BenchMark::sortInsertion));
    }

    private static long calculateExecuteCodeTime(int repeat,
                                                 int size,
                                                 Consumer<int[]> sortAlgorithms) {
        long timeMills = 0;
        for (int i = 0; i < repeat; i++) {
            long start = System.currentTimeMillis();
            sortAlgorithms.accept(generateArray(size));
            timeMills += System.currentTimeMillis() - start;
        }
        return timeMills/repeat;
    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0,1000);
        }
        return array;
    }

    private static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    private static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static void swapElements(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
