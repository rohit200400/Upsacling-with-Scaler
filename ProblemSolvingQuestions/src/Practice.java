import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
//        System.out.println(String.valueOf(8));
//        System.out.println(String.valueOf((char)('d'+1)));
        String x = "";
        System.out.println(x);
        x += '9';
        System.out.println(x);
        Integer n = Integer.valueOf(x);
        System.out.println(n);
        int[] arr = new int[10];
        Arrays.fill(arr, -1);
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(2);
        System.out.println(set.contains(2));
        for (Integer k : set
        ) {
            System.out.println(k);
        }
        HashMap<Integer, String> map = new HashMap<>();

    }
}
