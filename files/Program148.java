package leetcode;

public class Program148 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1= new ListNode(3);
		ListNode node2= new ListNode(2);
		ListNode node3= new ListNode(4);
		ListNode node4= new ListNode(4);
		ListNode node5= new ListNode(3);
		ListNode node6= new ListNode(5);
		//ListNode node7= new ListNode(10);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		//node6.next=node7;
		print(node1);
		System.out.println();
		System.out.println(getMiddleOfList(node1).val);
		ListNode node =sortList(node1);
		print(node);
	}
	public static ListNode getMiddleOfList(ListNode head) {  
        ListNode slow = head;  
        ListNode fast = head.next;  
        while(fast!=null&&fast.next!=null) {  
            slow = slow.next;  
            fast = fast.next.next;  
        }  
        return slow;  
    }  
	public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
		ListNode mid = getMiddleOfList(head);
		ListNode next=mid.next;
		mid.next=null;
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(next);
		return mergeList(l1,l2);
    }
	private static ListNode mergeList(ListNode a, ListNode b) {
		ListNode helper = new ListNode(-1);
		ListNode cur = helper;
		
		while(a!=null && b!=null){
			if(a.val<=b.val){
				cur.next = a;
				a= a.next;
			}else{
				cur.next = b;
				b= b.next;
			}
			cur = cur.next;
		}
		if(a!=null){
			cur.next = a;
		}
		if(b!=null) {
			cur.next = b;
		}
		return helper.next;
	}
	public static void print(ListNode head){
		ListNode temp = head;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
 