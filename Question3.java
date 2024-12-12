public class Question3 {

    public static void main(String[] args) {
        Integer[] list = {3, 4, 5, 1, -3, -5, -1};
        System.out.println(linearSearch(list, 2));
        System.out.println(linearSearch(list, 5));
    }

    public static <E extends Comparable<E>> int linearSearch(E[] list, E
            key) {
        // Loop
        for (int i = 0; i < list.length; i++) {
            // Check if current element equals key
            if (list[i].compareTo(key) == 0) {
                return i; // Return index if found
            }
        }
        return -1; // If not found
    }
}
