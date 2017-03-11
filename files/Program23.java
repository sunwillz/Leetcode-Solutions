package leetcode;

public class Program23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1= new ListNode(2);
		ListNode node2= new ListNode(3);
		ListNode node3= new ListNode(9);
		ListNode node4= new ListNode(1);
		ListNode node5= new ListNode(6);
		ListNode node6= new ListNode(8);
		ListNode node7= new ListNode(4);
		ListNode node8= new ListNode(5);
		ListNode node9= new ListNode(7);
		node1.next=node2;
		node2.next=node3;
		node4.next=node5;
		node5.next=node6;
		node7.next=node8;
		node8.next=node9;
		ListNode[] lists =new ListNode[]{node1,node4,node7};
		print(node1);
		print(node4);
		print(node7);
		print(mergeKLists(lists));
	}
	public static ListNode swapPairs(ListNode head) {
		ListNode helper = new ListNode(-1);
		helper.next=head;
		ListNode cur = helper;
		while(cur.next!=null && cur.next.next!=null){
			ListNode pre = cur.next;
			ListNode nex = cur.next.next;
			pre.next = nex.next;
			cur.next=nex;
			cur.next.next=pre;
			cur = cur.next.next;
		}
        return helper.next;
    }
	static ListNode dummy;
	public static void print(ListNode head){
		ListNode temp = head;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public static ListNode mergeKLists(ListNode[] lists) {
		 if(lists.length == 0) return null;
	        dummy = new ListNode(0);
	        int i = 0;
	        int j = lists.length - 1;
	        while(j!=0) {
	            while(i < j) {
	                lists[i] = mergeTwoList(lists[i++], lists[j--]);
	            }
	            i = 0;
	        }
	        return lists[0];
        
    }
	public static ListNode mergeTwoList(ListNode a,ListNode b){
		ListNode helper = new ListNode(-1);
		ListNode cur = helper;
		while(a!=null && b!=null){
			if(a.val<b.val){
				cur.next = a;
				a=a.next;
			}else{
				cur.next = b;
				b = b.next;
			}
			cur = cur.next;
		}
		if(a!=null){
			cur.next=a;
		}
		if(b!=null){
			cur.next = b;
		}
		return helper.next;
	}

}
