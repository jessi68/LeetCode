class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(0, 0);
    private int capacity;
    
    public LRUCache(int capacity) {
        head.next = head;
        head.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node curr = map.get(key);
        if (curr == null) {
            return -1;
        }
        
        remove(curr);
        moveToEnd(curr);
        return curr.value;
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
        
    private void moveToEnd(Node node) {
        head.prev.next = node;
        node.next = head;
        node.prev = head.prev;
        head.prev = node;
    }
    
    public void put(int key, int value) {
        Node curr = map.get(key);
        if (curr == null) {
            Node newNode = new Node(key, value);
            moveToEnd(newNode);
            map.put(key, newNode);
            if (map.size() > capacity) {
                Node toRemove = head.next;
                remove(toRemove);
                map.remove(toRemove.key);
            }
            return;
        }
    
        curr.value = value;
        remove(curr);
        moveToEnd(curr);
    }
    
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */