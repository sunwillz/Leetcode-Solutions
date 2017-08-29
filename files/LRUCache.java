package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUcache
 * @author sunwill
 *
 */
public class LRUCache {
	private int capacity;
	private int count;
	private Map<Integer,DequeNode> map = new HashMap<>();
	private DequeNode head, tail;
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new DequeNode();
        head.pre = null;
        
        tail = new DequeNode();
        tail.next = null;
        
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DequeNode node= map.get(key);
        if(node==null)return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DequeNode node = map.get(key);
        
        if(node==null){
        		DequeNode newNode = new DequeNode();
        		newNode.key = key;
        		newNode.value = value;
        		
        		addNode(newNode);
        		map.put(key, newNode);
        		++count;
        		
        		if(count>capacity)
        		{
        			DequeNode tail = this.popTail();
        			this.map.remove(tail.key);
        			--count;
        		}
        }else{
        		node.value = value;
        		this.moveToHead(node);
        }
    }
	class DequeNode{
		int key;
		int value;
		DequeNode pre;
		DequeNode next;
	}
	
	private void addNode(DequeNode node){
		node.pre = head;
		node.next = head.next;
		
		head.next.pre = node;
		head.next = node;
	}
	private void moveToHead(DequeNode node){
		this.removeNode(node);
		this.addNode(node);
	}
	
    private void removeNode(DequeNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}
    private DequeNode popTail(){
    		DequeNode ret = tail.pre;
    		this.removeNode(ret);
    		
    		return ret;
    }
	public static void main(String[] args) {
    	//["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
    	//[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
		LRUCache lru = new LRUCache(3);
		lru.put(1, 1);
		lru.put(2, 2);
		lru.put(3, 3);
		lru.put(4, 4);
		System.out.println(lru.get(4));
		System.out.println(lru.get(3));
		System.out.println(lru.get(2));
		System.out.println(lru.get(1));
		lru.put(5, 5);
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
		System.out.println(lru.get(4));
		System.out.println(lru.get(5));
//    	List<Integer> list = new ArrayList<>();
//    	list.add(1);
//    	list.add(2);
//    	System.out.println(list.toString());
//    	list.remove(2);
//    	System.out.println(list.toString());
	}
}
