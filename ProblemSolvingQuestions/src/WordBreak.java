import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak wordBreakObj = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("le","leet","etc");
        boolean result = wordBreakObj.wordBreak(s, wordDict);
        // The string "leetcode" can be segmented into "leet" and "code", so the expected output is true.
        System.out.println(result);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        Trie trie = new Trie();
        for(String x:wordDict){
            insert(x,trie);
        }
        return solve(s,trie,0,1,dp);
    }

    private boolean solve(String s,Trie trie,int i,int j,Boolean[] dp){
        if(i==s.length()){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        Trie dict = trie;
        for(int k=i;k<s.length();k++){
            dict = dict.a[s.charAt(k)-'a'];
            if(dict==null){
                return dp[i] = false;
            }
            if(dict.stop){
                if(solve(s,trie,k+1,k+2,dp))
                    return true;
            }
        }
        return dp[i] = false;
    }

    private void insert(String s,Trie trie){
        for(char ch:s.toCharArray()){
            if(trie.a[ch-'a']==null) {
                trie.a[ch-'a'] = new Trie();
            }
            trie=trie.a[ch-'a'];
        }
        trie.stop=true;
    }
}

class Trie{
    Trie[] a;
    boolean stop;

    public Trie(){
        a=new Trie[26];
        stop=false;
    }
//    public class Trie{
//        boolean isEnd;
//        Trie[] children;
//
//        Trie(){
//            children = new Trie[26];
//            isEnd = false;
//        }
//    }
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Trie root = new Trie();
//        int n = s.length();
//        for (String str: wordDict
//             ) {
//            Trie currNode = root;
//            for (char ch: str.toCharArray()
//                 ) {
//                if(currNode.children[ch - 'a'] == null){
//                    currNode.children[ch - 'a'] = new Trie();
//                }
//                currNode = currNode.children[ch - 'a'];
//            }
//            currNode.isEnd = true;
//        }
//
//        Boolean[] dp = new Boolean[n + 1];
//        dp[0] = true;
//        return solve(s,root,0,dp);
//    }
//    private boolean solve(String s, Trie trie, int i, Boolean[] dp){
//        if(i==s.length()){
//            return true;
//        }
//        if(dp[i]!= null){
//            return dp[i];
//        }
//        Trie dict = trie;
//        for(int k=i;k<s.length();k++){
//            dict = dict.children[s.charAt(k)-'a'];
//            if(dict==null){
//                return dp[i] = false;
//            }
//            if(dict.isEnd){
//                if(solve(s,trie,k+1,dp))
//                    return true;
//            }
//        }
//        return dp[i] = false;
//    }
}
