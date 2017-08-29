package leetcode;

import java.util.Random;

public class Program382 {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	ListNode head;
	Random rand;
	public Program382(ListNode head) {
		this.head = head;
		this.rand = new Random();
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode result = null;
		ListNode node = head;
		for(int i=1;node!=null;i++){
			
			if(rand.nextInt(i)==0)
				result = node;
			node = node.next;
		}
		return result.val;
	}
}
