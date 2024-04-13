import java.util.*;
public class Sort {
    public static Scanner scn = new Scanner(System.in);

    public static void swap(int num1,int num2, int[] array) {
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;

    }
    public static void sort_sel(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int min = i;
            for(int j = i; j < array.length; j++) {
                if(array[i] > array[j]) {
                   min = j;
                }
            }
            if(i != min) {
                swap(i, min, array);
            }
        }
    }
    public static void sort_insert(int[] array) {
        
    }
    public static void main(String[] args) {
        int array_size = scn.nextInt();

        int[] unsorted_array = new int[array_size];
        int i = 0;
        while(scn.hasNext()) {
            unsorted_array[i] = scn.nextInt();
            i++;
        }

        for(i = 0; i < unsorted_array.length; i++) {
            System.out.print(unsorted_array[i] + " ");
        }

        System.out.println();
        sort_sel(unsorted_array);
        for (int num : unsorted_array) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}