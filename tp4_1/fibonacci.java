package tp4_1;

public class fibonacci {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("["+i+"]: " + fiboRec(i));
        }
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            System.out.println("["+i+"]: " + fiboIt(i));
        }
    }

    public static int fiboIt(int n) {
        int r1 = 0;
        int r2 = 1;
        int r=0;
        for (int i = 0; i < n; i++) {
            r=r1+r2;
            r1=r2;
            r2=r;
        }
        return r;
    }
    
    public static int fiboRec(int n) {
        int r=0;
        if(n==1){
            r=1;
        } else if(n>1){
            r=fiboRec(n-1)+fiboRec(n-2);
        }
        return r;
    }
}
