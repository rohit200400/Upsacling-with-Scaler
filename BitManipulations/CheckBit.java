package BitManipulations;

public class CheckBit {
    public static void main(String[] args) {
        int num = 10;
        int bit = 2 ; 
        System.out.println("Bit number "+ bit +" of integer "+ num +" is "+ solve(num,bit));
    }

    public static int solve(int A, int B) {
        if(((A>>B)&1)==1){
            return 1;
            }
        return 0;
    }
}
