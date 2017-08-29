package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author sunwill
 *
 */
public class Program210 {

	public static void main(String[] args) {
		int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
		System.out.println(Arrays.toString(findOrder(4, prerequisites)));
	}
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<Integer>();
        int[][] graph = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
			int prefix = prerequisites[i][1];
			int suffix = prerequisites[i][0];
			if(graph[prefix][suffix]==0)
				indegree[suffix]+=1;
			graph[prefix][suffix] = 1;
		}
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
			if(indegree[i]==0){
				ans.add(i);
				queue.offer(i);
			}
		}
        while(!queue.isEmpty()){
        		int course = queue.poll();
        		for (int i = 0; i < numCourses; i++) {
        			if(graph[course][i]!=0){
        				if(--indegree[i]==0){
        					queue.offer(i);
        					ans.add(i);
        				}
        			}
				}
        }
        
        if(ans.size()==numCourses){
			int[] ret = new int[ans.size()];
			for (int i = 0; i < ret.length; i++) {
				ret[i] = ans.get(i);
			}
			return ret;
		}
        else return new int[]{};
    }
}
