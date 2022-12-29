package BitManipulations;

public class Decimal_toAnyBase {
    public static void main(String[] args) {
        int decimalNumber = 10;
        int base = 2;
        int converted = DecimalToAnyBase(decimalNumber, base);
        System.out.println("decimal number: "+converted);
    }

    public static int DecimalToAnyBase(int A, int B) {
        int answer = 0 ; 
        int power = 0 ; 
        while(A>0){
            int reminder = A%B;
            answer += reminder*Math.pow(10,power);
            power++;
            A=A/B;
        }
        return answer; 
     }
}
