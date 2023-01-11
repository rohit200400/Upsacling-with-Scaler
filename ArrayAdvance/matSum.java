package ArrayAdvance;

public class matSum {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};
        
        for (int[] row : A) {
            for (int i : row) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] pfMat = new int[A[0].length][A.length];
        for(int j=0;j<A.length;j++){
            pfMat[j][0] += A[j][0];
            for(int i=1; i<A[0].length;i++){
                pfMat[j][i] = pfMat[j][i-1] + A[j][i];
            }
        }
        for (int[] row : pfMat) {
            for (int i : row) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();

        // column pf sum
        for(int j=0;j<A[0].length;j++){
            //pfMat[0][j] += A[0][j];
            for(int i=1; i<A.length;i++){
                pfMat[i][j] = pfMat[i-1][j] + pfMat[i][j];
            }
        }

        for (int[] row : pfMat) {
            for (int i : row) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

        int[]  B = {1, 1}, C = {1, 4}, D = {2, 2},  E = {2, 4};
        int[] sumOutput = new int[B.length];
        for(int i=0; i<B.length; i++){
            // row start = B,row end = D -- 
            // column start = C,column end = E --
            int rs=B[i], re=D[i], cs=C[i], ce=E[i],sum=0;
            if(rs==1 && cs==1){
                sum = pfMat[re-1][ce-1];
                B[i] = sum;
                continue;
            }
            else if(rs==1){
                sum = pfMat[re-1][ce-1] - pfMat[re-1][cs-2];
                B[i] = sum;
                continue;
            }
            else if(cs==1){
                sum = pfMat[re-1][ce-1] - pfMat[rs-2][ce-1];
                B[i] = sum;
                continue;
            }
            else{
                sum = pfMat[D[i]-1][E[i]-1] - pfMat[B[i]-2][E[i]-1] -
                        pfMat[D[i]-1][C[i]-2] + pfMat[B[i]-2][C[i]-2];
            }
            B[i] = sum;
        }
        System.out.println();
        for (int i : sumOutput) {
            System.out.print(i+" ");
        }
    }
}
