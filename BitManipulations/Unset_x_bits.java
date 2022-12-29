package BitManipulations;

public class Unset_x_bits {
    // Unset x bits from right
    public static void main(String[] args) {
        int A = 10, B = 2;
        System.out.println(solve(A, B));
    }

    public static long solve(long A, int B) {
        int x = 0;
        while(B>0){
            x=(x|(1<<B-1));
            B--;
        }
        return A&(~(x));
    }
}
