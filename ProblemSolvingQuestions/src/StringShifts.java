/*A shift is a process in which alphabets are incremented by 1 in their ASCII value.
For the last alphabet z it starts again i.e. shift of z will be a. In perform string shifts leetcode problem
 we have Given a string s (lowercase characters only) and an array a[ ] of size equal to the length of a string
  containing a number of shifts to perform on the string. For each a[i] apply a[i] number of shifts on all the
  characters in string till i’th position.

 */
public class StringShifts {
    public static void main(String[] args) {
        String s = "abc";
        int[] a = { 1, 4, 7};
        StringShifts stringShifts = new StringShifts();
        System.out.println(stringShifts.shift(s,a));
        // mmj -> answer
    }
    public String shift(String str, int[] siftArray){
        String out = "";
        for (int i = 0; i < siftArray.length; i++) {
            int curr = siftArray[i];
            siftArray[i] = 0;
            for (int j = 0; j <= i; j++) {
                siftArray[j] = (siftArray[j]+curr)%26;
            }
        }
        for (int i = 0; i < siftArray.length; i++) {
            //out += (char)'a' + (('a' -str.charAt(i)) + siftArray[i])%26;
            out += (char)('a' + (((int)str.charAt(i) + siftArray[i]) % 'a') % 26);
        }
        return out;
    }
}
