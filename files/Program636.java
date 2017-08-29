package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Program636 {
	public static void main(String[] args) {
		String[] logs = new String[]{"0:start:0","1:start:2","2:start:3","1:end:5","2:end:7","0:end:9"};
		System.out.println(Arrays.toString(exclusiveTime(3, Arrays.asList(logs))));
	}
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            if (!stack.isEmpty()) res[stack.peek()] +=  Integer.parseInt(parts[2]) - prevTime; 
            prevTime = Integer.parseInt(parts[2]);
            if (parts[1].equals("start")) stack.push(Integer.parseInt(parts[0]));
            else {
                res[stack.pop()]++;
                prevTime++;
            }
        }
        return res;
    }
}
