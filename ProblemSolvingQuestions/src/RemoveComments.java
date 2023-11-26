import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public static void main(String[] args) {
        String[] source = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ",
                "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        List<String> out = removeComments(source);
        for (String s : out) {
            System.out.println(s);
        }
    }

    public static List<String> removeComments(String[] source) {
        List<String> output = new ArrayList<>();
        boolean isCommented = false;
        for (String line : source) {
            line.trim();
            if (line.contains("//")) {
                if (line.indexOf("//") == 0) {
                    continue; // whole line is commented
                } else {
                    String currLine = line.substring(0, line.indexOf("//"));
                    if (currLine.trim().length() != 0) {
                        output.add(currLine);
                    }
                }
                continue;
            }

            if (line.contains("/*")) {
                if (line.indexOf("/*") != 0) {
                    output.add(line.substring(0, line.indexOf("/*")));
                }
                isCommented = true;
            }
            if (!isCommented) {
                output.add(line);
            }
            if (line.contains("*/")) {
                if (line.indexOf("*/") != (line.length() - 2)) {
                    output.add(line.substring(line.indexOf("*/") + 2, line.length() - 2));
                }
                isCommented = false;
            }


        }
        return output;
    }
}
