class Solution {
    class TrieNode{
        boolean isEnd;
        String word;
        TrieNode[] children;
        public TrieNode(){
            isEnd = false;
            word ="";
            children = new TrieNode[26];
        }
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insertNode(String word){
            TrieNode node = root;
            for(int i = 0; i< word.length() ; i++){
                int idx = word.charAt(i) - 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
            node.word = word;
        } 
        public boolean search(String word){
            TrieNode node = root;
            for(int i = 0 ;i < word.length();i++){
                int idx = word.charAt(i) - 'a';
                if(node.children[idx] == null){
                    return false;
                }
                node = node.children[idx];
            }
            return node.isEnd && node.word.equals(word);
        }
    }
    List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        result = new ArrayList<>();
        Trie trie = new Trie();
        for(String s: words){
            trie.insertNode(s);
        }
        for(int i =0 ;i < n ;i++){
            for(int j = 0;j<m;j++){
                dfs(board , i , j , trie.root);
            }
        }
        return result;
    }

    int dx[] = {0,1,0,-1};
    int dy[] = {1,0,-1,0};
    public void dfs(char[][] board , int i , int j , TrieNode root){
        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length)return;
        if(board[i][j] == '$' || root.children[board[i][j] - 'a'] == null)return;

        char temp = board[i][j];

        root = root.children[board[i][j] - 'a'];
        if(root.isEnd == true){
            result.add(root.word);
            root.isEnd = false;
        }

        board[i][j] = '$';
        for(int k = 0; k< 4 ;k++){
            int new_i = i+ dx[k];
            int new_j = j+ dy[k];
            dfs(board , new_i , new_j , root);
        }
        board[i][j] = temp;
    }
}