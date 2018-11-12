/**
 * Scanner import.
 */
import java.util.Scanner;
/**
 * Arrays import.
 */
import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        Quick3string qs = new Quick3string();
        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextLine();
        }
        qs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}



