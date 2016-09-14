package datastructures.sorting;

/**
 * Created by ashsrivast on 21/08/16.
 */
public class RadixSort {
    static int[] numbers = {170, 45, 75, 90, 802, 24, 2, 66};
    static int[] numberso = {10, 100, 1000, 10000};

    public static void main(String args[]) {
        int min = Integer.MIN_VALUE;
        for (int k = 0; k < 4; k++) {
            min = -1;
            for (int j = 0; j < numbers.length; j++) {
                int last = numbers[j] % numberso[k];
                min = last;
                for (int i = j + 1; i < numbers.length; i++) {
                    int lastOfNext = numbers[i] % numberso[k];
                    if (lastOfNext < last && lastOfNext < min) {
                        System.out.println(numbers[j] + " and lastOfNext " + numbers[i]);
                        int temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                        last = lastOfNext;
                        min = lastOfNext;
                    }
                }
            }
            for (int i = 0; i < numbers.length - 1; i++) {
                System.out.println(numbers[i]);
            }
        }

    }
}
