public class targetArray {
    public static void shift(int[] arr, int idx) {
        int i1 = arr.length - 1;
        while(i1 > idx) {
            int i2 = i1 - 1;
            int temp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = temp;
            i1 = i2;
        }
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] arr = new int[nums.length];

        for(int i = 0; i < arr.length; i++){
            arr[i] = -1;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[index[i]] == -1) {
                arr[index[i]] = nums[i];
            } else {
                System.out.println("in else " + i);
                shift(arr, index[i]);
                arr[index[i]] = nums[i];
                // if(arr[i] == -1) {
                // }
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] input = new int[]{0,1,2,3,4};
        int[] idx = new int[]{0,1,2,2,1};
        int[] output = createTargetArray(input, idx);
        for(int i : output) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
