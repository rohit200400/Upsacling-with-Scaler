package strings;

public class toupper {
    public static void main(String[] args) {
        char[] A = {'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'};
        char[] out = to_upper(A);
        for (char c : out) {
            System.out.print(c+" ");
        }
    }
    public static char[] to_upper(char[] A) {
        for(int i = 0 ; i < A.length ; i ++){
            if(A[i]>='a'&& A[i]<= 'z'){//checking if it is a lower case
                A[i] = (char)(A[i]-32);//converting and assigning it to array
            }
        }
        return A;
    }

}
