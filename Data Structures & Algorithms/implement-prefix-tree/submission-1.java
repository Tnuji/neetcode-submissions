class PrefixTree {

    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean isEnd = false;
    }
    private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray())
        {
            if(current.children[c - 'a'] == null)current.children[c - 'a'] = new TrieNode();
            current = current.children[c-'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray())
        {
            if(current.children[c - 'a'] == null) return false;
            current = current.children[c-'a'];
        }
        if(current.isEnd) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c : prefix.toCharArray())
        {
            if(current.children[c - 'a'] == null) return false;
            current = current.children[c-'a'];
        }
        return true;
    }
}