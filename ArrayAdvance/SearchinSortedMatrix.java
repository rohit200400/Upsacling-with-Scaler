package ArrayAdvance;

public class SearchinSortedMatrix {
    public static void main(String[] args) {
        int[][] A = {{2, 2, 3},
            {2, 2, 3},
            {2, 2, 3}};
        int B = 2;
        for (int[] row : A) {
            for (int i : row) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();
        int out = solve(A, B);
        System.out.println(out);
    }
    public static int solve(int[][] A, int B) {
        int out = -1;
        int i= 0, j=A[0].length-1;
        while(j>=0 && i<A.length){
            if(A[i][j]==B){
                if(out==-1){out=(((i+1)*1009)+j+1);}
                else{out = Math.min(((i+1)*1009)+j+1,out);}
                if(A[i][j-1]==B){j--;}
                else{i++;}
            }
            else if(A[i][j]<B){
                i++;
            }
            else if(A[i][j]>B){
                j--;
            }
            
        }
        return out;
    }
}
