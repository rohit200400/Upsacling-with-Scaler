package ArrayBasics;

import java.util.Scanner;

public class GoodPair {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in); //Declaring Scanner object
        System.out.println("Input number of elememts in the array\n"); 
        int n = Scan.nextInt();    //getting input from console
        int[] array = new int[n];
        System.out.println("Input of elememts in the array, one in a line\n"); 
        for (int index = 0; index < n; index++) {
            array[index] = Scan.nextInt();
        }
        System.out.println("Give number for comparing a good pair\n"); 
        int B = Scan.nextInt();
        Scan.close();   //closing scanner
        String answer = (solve(array,B)==1)? "Good pair exist." : "Good pair dose not exist in the array.";
        System.out.println(answer);
    }
    public static int solve(int[] A, int B) {
        for(int i=0;i<A.length;i++){
            for(int j = i+1; j<A.length;j++){
                if(A[i]+A[j]==B) return 1;
            }
        }
        return 0;
    }
}
