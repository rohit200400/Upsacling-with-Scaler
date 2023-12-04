import java.util.HashMap;

    public class SubstringWithDistinctCharacters {

        public static String findMinLengthSubstring(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            HashMap<Character, Integer> map  = new HashMap<>();
            int start = 0, minLen = Integer.MAX_VALUE;
            int minStart = 0, distinctCount = 0;
            for (Character ch: s.toCharArray()
                 ) {
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
            distinctCount = map.size();
            for (Character ch: map.keySet()
                 ) {
                map.put(ch, 0);
            }
            for (int i = 0; i < distinctCount; i++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            }
            if(isComplete(map)){
                return s.substring(0,distinctCount);
            }

            for (int i = distinctCount; i < s.length(); i++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
                if(isComplete(map)){
                    while(isComplete(map)){
                        if(minLen > i-start){
                            minLen = i-start;
                            minStart = start;
                        }
                        map.put(s.charAt(start), map.get(s.charAt(start))-1);
                        start++;
                    }
                }
            }

            return s.substring(minStart, minStart + minLen +1);
        }
        public static boolean isComplete(HashMap<Character, Integer> map ){
            for (Integer value: map.values()
                 ) {
                if(value <=0){
                    return false;
                }
            }
            return true;
        }
        public static void main(String[] args) {
            String inputString = "abbbccfbbaacbbbbbfbac";
            String output = findMinLengthSubstring(inputString);
            System.out.println("Input string: " + inputString);
            System.out.println("Output substring: " + output);

             inputString = "deabccdef";
             output = findMinLengthSubstring(inputString);
            System.out.println("Input string: " + inputString);
            System.out.println("Output substring: " + output);
        }
    }
