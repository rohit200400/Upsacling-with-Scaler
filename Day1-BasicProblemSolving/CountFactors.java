import java.util.Scanner;

public class CountFactors{
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        System.out.println("Input a number\n");
        int n = Scan.nextInt();
        Scan.close();
        System.out.println(countFactors(n));
    
    } 
    /**
     * @param A
     * @return
     */
    public static int countFactors(int A) {
        int count = 2 ; // counting factors before hand (1,A)
        for(int i =2;i*i<=A;i++){ // test for factors from 2 to half of A
            if(A%i==0){
                count++;
                if(i*i!=A)count++;
                
            }
        }
        return count;
    }
}