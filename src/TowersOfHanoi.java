import java.util.Scanner;

/**
 * A Java program to solve the Towers of Hanoi for values of n between 1 and 10
 */
public class TowersOfHanoi {
    /**
     * Main function for Towers of Hanoi
     * @param args no args
     */
    public static void main(String[] args) {
        // get n
        String start = "a";
        String temp = "b";
        String end = "c";

        int n = getN();
        System.out.println("N = " + n);

        // call recursive fn
        hanoi(n, start, end, temp);
    }


    /**
     * A recursive function to solve the Towers of Hanoi. Prints the moves needed to solve the
     * puzzle for n discs.
     *
     * base cases: n = 1, n = 2
     *
     * @param n The number of discs to move, an integer >= 1 and < 10
     * @param start The starting peg
     * @param end The ending peg
     * @param temp The peg that acts as a temporary location
     */
    private static void hanoi(int n, String start, String end, String temp){
        if (n == 1) {
            // base case 1
            System.out.println("move " + start + " -> " + end);
        }
        else if (n == 2) {
            // base case 2
            System.out.println("move " + start + " -> " + temp);
            System.out.println("move " + start + " -> " + end);
            System.out.println("move " + temp + " -> " + end);
        }
        else {
            // hanoi(n-1, start, temp, end)
            hanoi(n - 1, start, temp, end);
            // hanoi(1, start, end, temp)
            hanoi(1, start, end, temp);
            // hanoi(n-1, temp, end, start)
            hanoi(n - 1, temp, end, start);
        }
    }


    /**
     * Gets and validates an integer n from the user.
     * @return an integer n
     */
    private static int getN() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (n <= 0 || n >= 10) {
            System.out.print("Enter an integer greater than 0 and less than 10: ");
            n = in.nextInt();
        }

        return n;
    }
}
