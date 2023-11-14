public class Client {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<Integer>();
        for(int i = 0; i < 10; i++) {
            array.put(i * 2);
        }
        System.out.println(array.get(9));
        // System.out.println(array.get(10));
        // System.out.println(array.get(-1));
        System.out.println(array.get(5));
        for(int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        array.replace(5, 500);
        for(int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(array.size());
    }
}