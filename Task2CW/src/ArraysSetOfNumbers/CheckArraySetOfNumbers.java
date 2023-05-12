package ArraysSetOfNumbers;

import java.util.Arrays;

public class CheckArraySetOfNumbers {
    public static boolean sameNumberSet(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        boolean result = sameNumberSet(arr1, arr2);
        System.out.println(result); // true

        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {5, 4, 3, 2, 6};
        result = sameNumberSet(arr3, arr4);
        System.out.println(result); // false
    }
}