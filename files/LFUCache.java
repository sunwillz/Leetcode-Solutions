package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	
	int min;
	int capacity;
	HashMap<Integer,Integer> cache ;
	HashMap<Integer,Integer> counts;
	HashMap<Integer,LinkedHashSet<Integer>> lists;
	
    public LFUCache(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.counts = new HashMap<>();
        this.lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
        		return -1;
        	int count = counts.get(key);
        	counts.put(key, count+1);
        	lists.get(count).remove(key);
        	if(count==min&&lists.get(count).size()==0)
        		min++;
        	if(!lists.containsKey(count+1))
        		lists.put(count+1, new LinkedHashSet<>());
        	lists.get(count+1).add(key);
        	
        	return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key))
        {
        		cache.put(key, value);
        		get(key);
        }
        if(cache.size()>=capacity)
        {
        		int remove = lists.get(min).iterator().next();
        		lists.get(min).remove(remove);
        		cache.remove(remove);
        }
        cache.put(key, value);
        min = 1;
        counts.put(key, 1);
        lists.get(1).add(key);
    }
    public static void main(String[] args) {
		LFUCache lfu = new LFUCache(3);
		lfu.put(1, 1);
		lfu.put(2, 2);
		lfu.put(3, 3);
		lfu.put(4, 4);
		System.out.println(lfu.get(4));
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(1));
		lfu.put(5, 5);
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(4));
		System.out.println(lfu.get(5));
	}
}
