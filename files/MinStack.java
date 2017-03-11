package leetcode;

import java.util.Stack;

public class MinStack {

	Stack<Integer> s,minS;
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(-1);
		ms.push(0);
		ms.push(-2);
		ms.push(-1);
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.top());
		ms.pop();
		System.out.println(ms.getMin());
	}
    /** initialize your data structure here. */
    public MinStack() {
       s= new Stack<>();
       minS = new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
        if(!minS.isEmpty() && minS.peek()<x) return ;
        minS.push(x);
    }
    
    public void pop() {
        int m = s.pop();
        if(m==minS.peek()) minS.pop();
    }
    
    public int top() {
		return s.peek();
        
    }
    
    public int getMin() {
		return minS.peek();
        
    }

}
