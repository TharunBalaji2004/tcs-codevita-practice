package SortingBoxes;

import java.util.*;

class SortingBoxes {
    static int i, j, sum = 0, min1, max1, swap1, swap2;
    static int[] arr, arr1, arr2;

    static int swapping(int c, int a, int b) {
        int temp;
        if (c == 1) {
            temp = arr2[a];
            arr2[a] = arr2[b];
            arr2[b] = temp;
            return arr[2] * arr2[b];
        } else {
            temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            return arr[a] * arr[b];
        }
    }

    static int prep() {
        for (int k = 0; k < arr.length; k++) {
            for (int k2 = 0; k2 < arr1.length; k2++) {
                if (arr[k2] == arr1[k]) {
                    if (k2 == k) {
                        break;
                    } else {
                        if (arr[k2] > arr[k]) {
                            min1 = k;
                            max1 = k2;
                        } else {
                            min1 = k2;
                            max1 = k;
                        }
                        swap1 = swapping(1, k2, k);
                        swap2 = swapping(2, 0, min1) + swapping(2, min1, max1) + swapping(2, 0, max1);
                        if (swap1 < swap1) {
                            sum += swap1;
                            for (int i = 0; i < arr.length; i++) {
                                arr[i] = arr2[i];
                            }
                        } else {
                            for (int i = 0; i < arr.length; i++) {
                                arr2[i] = arr1[i];
                            }
                            sum += swap2;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            i = sc.nextInt();
            j = sc.nextInt() - 1;
            arr = new int[i];
            arr1 = new int[i];
            arr2 = new int[i];
            for (int k = 0; k < i; k++) {
                arr[k] = sc.nextInt();
            }
        }
        for (int k = 0; k < i; k++) {
            arr2[k] = arr[k];
        }
        for (int k = 0; k < i; k++) {
            arr1[k] = arr[k];
        }
        Arrays.sort(arr1);
        for (int i = arr1.length - 1; i > j; i--) {
            arr1[i] = arr1[i - 1];
        }
        arr1[j] = max1;
        System.out.println(prep());
    }
}

