class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private int capacity;

    // Dummy nodes
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        left = new Node(0, 0);   // MRU side
        right = new Node(0, 0);  // LRU side

        left.next = right;
        right.prev = left;
    }

    // Removes a node from the list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Inserts a node right after the left dummy (MRU position)
    private void insert(Node node) {
        node.next = left.next;
        node.prev = left;

        left.next.prev = node;
        left.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node old = map.get(key);
            remove(old);
        }

        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);

        if (map.size() > capacity) {
            Node lru = right.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}