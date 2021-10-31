class Node {
	char c;
	boolean isEnd = false;
	HashMap<Character, Node> children = new HashMap<Character, Node>();
  
    public Node() {
    }
    public Node(char c) {
    	this.c = c;
    }
}


class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        HashMap<Character, Node> children = node.children;
        for(int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if(!children.containsKey(temp)) {
                Node nextNode = new Node(temp);
                children.put(temp, nextNode);
            }
            node = children.get(temp);
            children = node.children;
            if(i == word.length() - 1)  {
                node.isEnd = true;
            }
        }
    }
    
    public boolean search(String word) {
        Node node = root;
        HashMap<Character, Node> children = node.children;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if (!children.containsKey(c)) {
        		return false;
        	} else {
        		node = children.get(c);
        		children = node.children;
        	}
			if (i == word.length() - 1) {
        		return node.isEnd;
        	}
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        HashMap<Character, Node> children = node.children;
        for (char c : prefix.toCharArray()) {
        	if (!children.containsKey(c)) {
        		return false;
        	} else {
        		node = children.get(c);
        		children = node.children;
        	}
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */