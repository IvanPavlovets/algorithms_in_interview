package ru.job4j.algorithms;

import java.util.Arrays;

/**
 * Алгоритм двух укказателей:
 * Дан отсортированный массив от большего к меньшему.
 * Нужно возвести каждый элемент в квадрат, чтобы результирующий массив был тоже отсортирован.
 * Двигаемсяся по массиву с двух сторон: с начала и с конца,
 * возводя элементы в квадрат и помещая их в результирующий массив.
 * Шаги алгоритма:
 * 1. Создайте результирующий массив той же длины, что и исходный массив.
 * 2. Установите два указателя: один указывает на начало исходного массива, а другой - на его конец.
 * 3. Начните двигаться по массиву с обоих концов, возводя элементы в квадрат и помещая их
 * в результирующий массив.
 * 4. Следите за тем, чтобы значения в результирующем массиве шли от большего к меньшему.
 * Это решение будет иметь временную сложность O(n), где n - количество элементов в исходном массиве,
 * так как мы пройдемся только один раз по каждому элементу массива.
 */
public class Main {
    public static int[] squareSortedArray(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int resultIndex = n - 1;

        while (left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                result[resultIndex] = arr[left] * arr[left];
                left++;
            } else {
                result[resultIndex] = arr[right] * arr[right];
                right--;
            }
            resultIndex--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] sortedArray = {-4, -2, 0, 2, 3, 5};
        int[] resultArray = squareSortedArray(sortedArray);
        System.out.println(Arrays.toString(sortedArray));
    }

}
