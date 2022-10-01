import java.util.Scanner;

public class PowerFunction {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Input a number\n");
        int m = Scan.nextInt();
        System.out.println("Input its exponent\n");
        int n = Scan.nextInt();
        Scan.close();
        System.out.println("Answer: " + power(m, n));
    }
    public static int power(final int A, final int B) {
        int ans = A;
        for(int i=1;i<B;i++){
            ans*=A;
        }
        return ans;
    }
}
