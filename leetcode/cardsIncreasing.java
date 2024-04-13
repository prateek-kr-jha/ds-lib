// [17,13,11,2,3,5,7]
import java.util.Arrays;

public class cardsIncreasing {
    public static int[] arrangeCards(int[] array) {
        int[] arranged_array = new int[array.length];
        int i = 0;
        int j = 0;
        int starting = 0;
        int length = array.length;
        Arrays.sort(array);
        for(int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        while(i < array.length && j < array.length) {
            arranged_array[i] = array[j];
            i += 2;
            j++;
            length--;
            if(i == array.length) {
                i = 2 * (starting + 1);
                starting = i;

            } else {
                i = 2 * starting + 1; 
                starting = i;
            }
        }
        System.out.println(i + "===============");
        return arranged_array;
    }
    public static void main(String[] args) {

        int[] array_1 = new int[]{17,13,11,2,3,5,7};
        int[] array_2 = arrangeCards(array_1);
        for(int num : array_2) {
            System.out.print(num + " ");
        }
        System.out.println();
    } 
}