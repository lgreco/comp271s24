public class AccursedRecursion {

    /**
     * Algorithmic implementation of n!
     * 
     * @param n
     * @return n!
     */
    public static long factorial(int n) {
        if (n == 0) // base case
            return 1L;
        return factorial(n - 1) * n;
    } // method factorial

    /**
     * Single return statement implementation
     * @param n 
     * @return n!
     */
    public static long fact(int n) {
        long result = 1L; // base case by default
        if (n > 0)
            result = n * fact(n - 1);
        return result;
    } // method fact

    /** Driver code / demo */
    public static void main(String[] args) {
        // print out both factorial() and fact() to compare values for consistency
        for (int i = 0; i < 35; i++) {
            System.out.printf("\n%3d! = %,28d = %,28d", i, factorial(i), fact(i));
        }
    } // method main
}
