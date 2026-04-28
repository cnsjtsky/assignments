import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        SelectionSort selection = new SelectionSort();
        QuickSort quick = new QuickSort();
        BinarySearch binary = new BinarySearch();

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            System.out.println("\nArray Size: " + size);

            int[] random = generateRandomArray(size);
            int[] sorted = generateSortedArray(size);

            // Selection Sort
            int[] arr1 = Arrays.copyOf(random, random.length);

            long start = System.nanoTime();
            selection.sort(arr1);
            long end = System.nanoTime();

            System.out.println("Selection Sort: " + (end - start) + " ns");

            // Quick Sort
            int[] arr2 = Arrays.copyOf(random, random.length);

            start = System.nanoTime();
            quick.sort(arr2, 0, arr2.length - 1);
            end = System.nanoTime();

            System.out.println("Quick Sort: " + (end - start) + " ns");

            // Binary Search
            int target = size / 2;

            start = System.nanoTime();
            int index = binary.search(sorted, target);
            end = System.nanoTime();

            System.out.println("Binary Search Index: " + index);
            System.out.println("Binary Search Time: " + (end - start) + " ns");
        }
    }

    public static int[] generateRandomArray(int size) {

        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }

        return arr;
    }

    public static int[] generateSortedArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        return arr;


    }
}