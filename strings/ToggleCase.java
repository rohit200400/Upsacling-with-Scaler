package strings;

public class ToggleCase {
    public static void main(String[] args) {
        String A = "RohitChaudhary";
        System.out.println(solve(A));
    }
    public static String solve(String A) {
        int N = A.length();
        // converting string to char array
        char[] charArr = A.toCharArray();
        // toogle code
        for(int i = 0; i < N ; i ++){
            //if small 
            if(charArr[i]>='a'&& charArr[i]<='z'){
                charArr[i]=(char)(charArr[i]-32);
            }
            //if capital
            else{
                charArr[i]=(char)(charArr[i]+32);
            }
        }
        //converting Char array to String
        String string = new String(charArr);
        return string;  
    }
}
