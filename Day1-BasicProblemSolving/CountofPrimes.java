import java.util.Scanner;

public class CountofPrimes {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Input a number\n");
        int n = Scan.nextInt();
        Scan.close();
        System.out.println("Total Prime numbers are "+solve(n));
    }
    public static int solve(int A) {
        if(A==1) return 0;
        int count = 0;
        for(int j = 2;j<=A;j++){
            if(isPrime(j)) count++;
        }
        return count;
    }
    public static boolean isPrime(int N){
        for(int i = 2; i*i<=N;i++){
            if(N%i==0) return false;
        }
        return true;
    }
}
