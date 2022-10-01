import java.util.Scanner;

public class IsPerfectSquare{
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Input a number\n");
        int n = Scan.nextInt();
        Scan.close();
        String answer = (isPerfectSquare(n)==-1)? "Not a Perfect Square" : "Number is a Perfect Square";
        System.out.println(answer);
    }
    /**
     * @param A Input integer
     * @return
     */
    public static int isPerfectSquare(int A) {
        int high = A, low = 0;
        while(low<=high){
            int mid = low+(high-low)/2 ;
            long sqr = (long)mid*mid;
            if((long) A == sqr) return mid;
            if((long) A < sqr){
                high = mid-1;
            }
            else low = mid+1;
        }
        return -1;
    }
}