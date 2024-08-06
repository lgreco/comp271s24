public class AccursedRecursion {

    public static long fact(int n) {
        if (n==0)
            return 1;
        return fact(n-1)*n;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 35; i++) {
            System.out.printf("\n%3d! = %,28d",i, fact(i));
        }
    }
}
