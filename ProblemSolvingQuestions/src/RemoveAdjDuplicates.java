import java.util.Stack;

public class RemoveAdjDuplicates {
    public static void main(String[] args) {
        RemoveAdjDuplicates removeAdjDuplicates = new RemoveAdjDuplicates();

        // Example 1
        String s1 = "abbaca";
        int k1 = 2;
        String result1 = removeAdjDuplicates.removeDuplicates(s1, k1);
        System.out.println("Original String 1: " + s1);
        System.out.println("After removing adjacent duplicates with k=" + k1 + ": " + result1);
        System.out.println();

        // Example 2
        String s2 = "deeedbbcccbdaa";
        int k2 = 3;
        String result2 = removeAdjDuplicates.removeDuplicates(s2, k2);
        System.out.println("Original String 2: " + s2);
        System.out.println("After removing adjacent duplicates with k=" + k2 + ": " + result2);
    }
    public class Pair {
        char value;
        int count;

        public Pair (char value, int count)
        {
            this.value = value;
            this.count = count;
        }


    }

    public String removeDuplicates(String s, int k) {

        Stack<Pair> pairStack = new Stack <>();

        for(char c: s.toCharArray())
        {
            if(! pairStack.empty() && pairStack.peek().value==c)
                pairStack.peek().count++;

            else
                pairStack.push(new Pair(c, 1));

            if (pairStack.peek().count==k) {

                pairStack.pop();
            }

        }
        StringBuilder result = new StringBuilder();

        for(Pair element : pairStack)
        {
            result.append(String.valueOf(element.value).repeat(element.count));
        }
        return result.toString();
    }
}
