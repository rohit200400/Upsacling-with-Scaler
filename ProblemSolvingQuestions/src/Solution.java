class LongestWordInDictionary {
    public static void main(String[] args) {
        String[] dict = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(dict));
    }
    static String answer = "";
    public static class Trie{
        Trie[] childrens = new Trie[26];
        String word;

        public void add(Trie root, String str){
            for(int i = 0; i < str.length(); i++){
                if(root.childrens[str.charAt(i) - 'a'] == null ){
                    root.childrens[str.charAt(i) - 'a'] = new Trie();
                }
                root = root.childrens[str.charAt(i) - 'a'];
            }
            root.word = str;
        }
    }
    public static String longestWord(String[] words) {

        Trie root  = new Trie();
        for(String word: words){
            root.add(root,word);
        }
        answer = "";
        dfs(root);
        return answer;
    }
    public static void dfs(Trie root){
        for(Trie child: root.childrens){
            if(child != null && child.word != null){
                if(child.word.length() > answer.length()){
                    answer = child.word;
                }
                dfs(child);
            }
        }
    }
}