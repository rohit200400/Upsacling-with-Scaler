package ArrayAdvance;

public class AddOneToNumber {
    public static void main(String[] args) {
        int[]  array = {9, 9, 9, 9, 9};
        int[] out    = plusOne(array);
        for (int i : out) {
            System.out.print(i+" ");
        }
    }
    public static int[] plusOne(int[] A) {
        int leadingZeros = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]>0){break;}
            else{leadingZeros++;}
        }
        int carry = 1;
        for(int i=A.length-1;i>=0;i--){
            if(A[i]+carry ==10){
                carry=1;
                A[i] = 0;
            }
            else{
                A[i]+=carry;
                carry = 0;
                break;
            }
        }
        
        if(carry==0){
            int[] out = new int[A.length-leadingZeros];
            for(int i=leadingZeros,j=1;i<A.length;i++,j++){
                out[j] = A[i];
            }
            return out;
        }
        else{
            int[] out = new int[A.length-leadingZeros+1];
            out[0]=1;
            for(int i=leadingZeros,j=1;i<A.length;i++,j++){
                out[j] = A[i];
            }
            return out;
        }
        
    }
}
