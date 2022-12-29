package BitManipulations;

public class NumberofSetBits {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("Total set bit in decimal number "+num+ " are " + numSetBits(num));
    }
    public static int numSetBits(int A) {
        int count = 0 ,a=A; 

        while(a>0){
            if((a&1)==1) count++;
            a=a>>1;
        } 
        return count;
    }
}
