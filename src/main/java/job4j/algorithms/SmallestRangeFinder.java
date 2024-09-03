package job4j.algorithms;


import java.util.Arrays;

/**
 * Алгоритм нахождение наименьшего диапазона с данным количеством различных элементов.
 * Есть отсортированный массив целых чисел и число k.
 */
public class SmallestRangeFinder {

    /**
     * Добавьте реализацию метода здесь
     * Метод должен принимать массив nums и целочисленное значение k,
     * и возвращать массив из двух целых чисел, представляющих наименьший диапазон
     * с k различными элементами в массиве nums
     * Если такой диапазон найти невозможно, вернуть null
     * @param nums
     * @param k
     * @return
     */
    public static int[] findSmallestRange(int[] nums, int k) {
        int[] result = new int[k];
        int left = 0, right = 1;
        int resultIndex = 0;
        int[] range = new int[2];
        int[] main = nums;
        int offset = 0;

        while (resultIndex <= k) {
            if (right > nums.length - 1) {
                return null;
            }
            if (nums[left] < nums[right]) {
                result[resultIndex] = nums[left];
                resultIndex++;
                result[resultIndex] = nums[right];
                if (resultIndex == result.length - 1) {
                    break;
                }
                left++;
                right++;
            } else {
                nums = Arrays.copyOfRange(nums, right, nums.length);
                offset = 1;
                left = 0;
                right = 1;
                resultIndex = 0;
            }
        }
        range[0] = Arrays.binarySearch(main, result[offset]) - offset;
        range[1] = Arrays.binarySearch(main, result[result.length - 1]);
        return range;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }

}
