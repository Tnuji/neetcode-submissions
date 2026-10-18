class WordDictionary {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
    TrieNode root;
    String global;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for(char s : word.toCharArray())
        {
            if(current.children[s - 'a'] == null)
            {
                current.children[s-'a'] = new TrieNode();
            }
            current = current.children[s - 'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        global = word;
        return search(0 , root);
    }

    public boolean search(int index, TrieNode root)
    {
        if(index == global.length()) return root.isEnd;

        TrieNode current = root;

        if(global.charAt(index) != '.')
        {
            int whereAMI = global.charAt(index) - 'a';
            if(current.children[whereAMI] == null) return false;
            return search(index + 1, current.children[whereAMI]);
        }

        for(TrieNode son : current.children)
        {
            if(son == null) continue;
            if(search(index + 1, son)) return true;
        }
        return false;
    }


}
