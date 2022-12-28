package ArrayInterviewQuestions;

public class SpecialIndex {
    public static void main(String[] args) {
        int[] A = {1, 1, 1};
        int spIdx = solve(A);
        System.out.println("there are total "+spIdx+" special index in the Array.");
    }
    public static int solve(int[] A) {
        int[] evenpf = new int[A.length];
        int[] oddpf = new int[A.length];
        evenpf[0]= A[0];
        oddpf[0]=0;
        for(int i = 1 ; i < A.length ; i ++){
            if(i%2 ==0){
                evenpf[i] = evenpf[i-1] +A[i];
                oddpf[i] = oddpf[i-1];
            }
            else{
                oddpf[i] = oddpf[i-1]+A[i];
                evenpf[i] = evenpf[i-1];
            }
        }
        if(evenpf[A.length-1]+oddpf[A.length-1] == 0) return A.length;
        int cntSplIdx = 0;
        for(int i = 1; i<A.length-1;i++){
            if(i%2==0){
                if((evenpf[i-1]+oddpf[A.length-1]-oddpf[i])==
                    (oddpf[i]+evenpf[A.length-1]-evenpf[i])){
                        cntSplIdx++;
                    }
            }
            else{
                if((oddpf[i-1]+evenpf[A.length-1]-evenpf[i])==
                    (evenpf[i]+oddpf[A.length-1]-oddpf[i])){
                        cntSplIdx++;
                    }
            }
        }
        return cntSplIdx;
    }
}
