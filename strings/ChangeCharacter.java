package strings;

import java.util.Arrays;

public class ChangeCharacter {
    public static void main(String[] args) {
        String A = "abcabbccd";
        int B = 3;
        System.out.println(solve(A, B));
    }
    public static int solve(String A, int B) {
        char[] arr = A.toCharArray();
        if(arr.length == 1 && B==1){
            return 1;
        }
        int[] count = new int[26];
        for(int i = 0; i <arr.length; i++){
            int idx = arr[i] - 'a';
            count[idx] = count[idx] + 1;
        }
        int filledidx= 0;
        for(int i = 0 ; i < count.length; i++){
            if(count[i] != 0){
                filledidx++;
            }
        }
        Arrays.sort(count);
        for(int j = 0 ; j < count.length; j++){
            if(count[j] > 0 && count[j] <= B){
                filledidx--;
                B = B-count[j];
            }
            else if(count[j] == 0){
                continue;
            }
            else{
                break;
            }
        }
        return filledidx;
    }
}
