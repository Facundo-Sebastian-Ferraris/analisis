package tp4_1;

public class fibonacci {

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println("[" + i + "]: " + fiboRec(i));
//        }
//        System.out.println("");
//        for (int i = 0; i < 100; i++) {
//            System.out.println("[" + i + "]: " + fiboIt(i));
//        }
            System.out.println(fiboRec(10));
    }

    public static long fiboIt(int n) {
        //advertencia: tope n=49;
        long r = 0;
        if (n <= 1) {
            r = n;
        } else {

            int a = 0, b = 1, c;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            r = b;
        }
        return r;
    }

    public static long fiboRec(int n) {
        //advertencia: tope n=49;
        long r = 0;
        if (n == 1) {
            r = 1;
        } else if (n > 1) {
            r = fiboRec(n - 1) + fiboRec(n - 2);
        }
        return r;
    }
    public static long fiboTailRec(int n) {
        //advertencia: tope n=49;
        
    }
}
