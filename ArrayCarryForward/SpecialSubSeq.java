package ArrayCarryForward;

/**
 * SpecialSubSeq
 */
public class SpecialSubSeq {

    public static void main(String[] args) {
        System.out.println(solve("ABCGAG"));
    }
    public static int solve(String A) {
        int cntG = 0;
        int cntnumberOfSubSeq = 0;
        for( int index = A.length()-1; index>=0; index--){
            //if(A.charAt(index) == 'A' && cntG==0 ) continue;
            if(A.charAt(index) =='G') cntG++;
            else if(A.charAt(index) == 'A'&& cntG!=0) cntnumberOfSubSeq = cntnumberOfSubSeq%1000000007 +cntG%1000000007;
        }
        return cntnumberOfSubSeq%1000000007 ;
    }
}