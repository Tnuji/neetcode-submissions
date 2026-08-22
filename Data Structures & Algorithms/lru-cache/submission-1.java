class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    public HashMap<Integer, Node> map;
    public int capacity; 

    public Node left;
    public Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        left = new Node(0 , 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    public void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(Node node){
        node.next = left.next;
        node.prev = left;

        left.next.prev = node;
        left.next = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return - 1;
        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            remove(old);
        }

        Node neww = new Node(key, value);
        insert(neww);
        map.put(key, neww);

        if(map.size() > capacity)
        {
            Node lru = right.prev;
            remove(lru);
            map.remove(lru.key);
        }
    } 
}
