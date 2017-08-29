package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author sunwill
 *
 */
public class Program207 {

	public static void main(String[] args) {

	}
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        int[][] edge = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
			int prefix = prerequisites[i][1];
			int suffix = prerequisites[i][0];
			if(edge[prefix][suffix]==0)
				indegree[suffix] +=1;
			edge[prefix][suffix] =1;
		}
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
			if(indegree[i]==0)
				queue.offer(i);
        }
        while(!queue.isEmpty()){
        		int course = queue.poll();
        		count++;
        		for (int i = 0; i < numCourses; i++) {
					if(edge[course][i]!=0){
						if(--indegree[i]==0)
						queue.offer(i);
						}
				}
        }
        return count==numCourses;
    }
}
