package BitManipulations;

public class Unset_ithBit {
    public static void main(String[] args) {
        //set bth bit in int A
        int A = 10, B = 3;
        System.out.println(solve(A, B));
    }
    public static int solve(int A, int B) {
        return (A&(~(1<<B)));
}
}
