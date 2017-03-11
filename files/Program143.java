package leetcode;

public class Program143 {

	public static void main(String[] args) {
		ListNode head= new ListNode(1);
		ListNode n1= new ListNode(2);
		ListNode n2= new ListNode(3);
		ListNode n3= new ListNode(4);
		head.next=n1;
		n1.next=n2;
		n2.next=n3;
		print(reverse1(head));
	}
	
	/**
	 * 反转链表，递归
	 * @param head
	 * @return
	 */
	public static ListNode reverse(ListNode head){
		if(head==null || head.next==null) return head;
		
		ListNode reversedHead = reverse(head.next);
		head.next.next = head;
		head.next=null;
		return reversedHead;
	}
	
	/**
	 * 反转链表，非递归
	 * @param head
	 * @return
	 */
	public static ListNode reverse1(ListNode head){
		if(head==null || head.next==null) return head;
		ListNode pre = null;
		ListNode cur = head;
		ListNode nex = null;
		while(cur!=null){
			nex = cur.next;
			cur.next=pre;
			pre = cur;
			cur = nex;
		}
		return pre;
	}
	public static void reorderList(ListNode head) {
        if(head==null) return;
        ListNode one = head;
        ListNode two = head;
        while(two.next!=null) {
        	two = two.next;
        }
        System.out.println(two==null);
        while(one.next!=two){
        	two.next= one.next;
        	one.next = two;
        	one = two.next;
        	ListNode tnode = one;
        	while(tnode.next!=two) tnode = tnode.next;
        	two = tnode;
        }
    }
	public static void print(ListNode head){
		ListNode temp = head;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
	}
}
