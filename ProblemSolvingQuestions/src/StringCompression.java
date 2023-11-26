public class StringCompression {
    public static void main(String[] args) {
        char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c'};
        System.out.println(compress(input)); // 6
//        for (char c: input
//             ) {
//            System.out.println(c);
//        }
    }

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0; // Handle edge case of an empty array
        }

        int countChar = 1;
        char currChar = chars[0];
        StringBuilder compressedStringBuilder = new StringBuilder();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == currChar) {
                countChar++;
            } else {
                compressedStringBuilder.append(currChar);
                if (countChar > 1) {
                    compressedStringBuilder.append(countChar);
                }
                countChar = 1;
                currChar = chars[i];
            }
        }

        // Append the last character and its count
        compressedStringBuilder.append(currChar);
        if (countChar > 1) {
            compressedStringBuilder.append(countChar);
        }

        // Update the input array with the compressed characters
        char[] compressedChars = compressedStringBuilder.toString().toCharArray();
        System.arraycopy(compressedChars, 0, chars, 0, compressedChars.length);

        return compressedChars.length;
    }
}
