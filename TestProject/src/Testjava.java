/**
 * Created by ashsrivast on 27/08/16.
 */
public class Testjava {
    public static void main(String args[]) {
        System.out.println(bit_swaps_required(8, 16));
    }

    private static long bit_swaps_required( int a, int b ) {
        long count = 0;
        for( int c = a ^ b; c != 0; c = c >> 1 ) {
            System.out.println(c);
            System.out.println(" >> " + (c & 1));
            count += c & 1;
        }
        return count;
    }
}
