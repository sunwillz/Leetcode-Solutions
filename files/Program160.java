package leetcode;
/**
 * 两个链表的公共起始节点
 * @author sunwill
 *
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Program160 {
	/**
	 * 算法一：先得到两个链表的长度，再移动长的链表的头指针使其指向新的节点，
	 * 这样两个新的链表的长度相同，最后同时移动指针，直到指向相同的节点
	 * @param headA
	 * @param headB
	 * @return
	 */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA = getLength(headA),lenB = getLength(headB);
    		while(lenA<lenB){
    			headB = headB.next;
    			lenB--;
    		}
    		while(lenA>lenB){
    			headA= headA.next;
    			lenA--;
    		}
    		while(headA!=headB){
    			headA = headA.next;
    			headB = headB.next;
    		}
    	
        return headA;
    }
    /**
     * 链表的长度
     * @param headA
     * @return
     */
	private int getLength(ListNode node) {
		int len = 0;
		while(node!=null){
			node = node.next;
			len++;
		}
		return len;
	}
	/**
	 * 算法二：不需要得到链表的长度，两个指针进行遍历，最后一定会在公共起始点相遇
	 * @param headA
	 * @param headB
	 * @return
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while(a!=b){
        		a= a==null?headB:a.next;
        		b= b==null?headA:b.next;
        }
        	return a;
        	
        	
    }
	
}