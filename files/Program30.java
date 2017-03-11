package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program30 {

	public static void main(String[] args) {
		String[] words={"foo", "bar"};
		System.out.println(findSubstring("barfoothefoobarman",words));
		
	}
	public static List<Integer> findSubstring(String s,String[] words){
		List<Integer> res = new ArrayList<Integer>();
		Map<String,Integer> map =new HashMap<String,Integer>();
		int len = words[0].length();
		for (String word : words) {
			map.put(word, map.containsKey(word)?map.get(word)+1:1);
		}
		for (int i = 0; i <= s.length()-len*words.length; i++) {
			Map<String,Integer> copy = new HashMap<String,Integer>(map);
			for(int j=0;j<words.length;j++){
				String next = s.substring(i+j*len, i+(j+1)*len);
				if(copy.containsKey(next)){
					int cnt = copy.get(next);
					if(cnt==1) copy.remove(next);
					else copy.put(next, cnt-1);
					if(copy.isEmpty()){
						res.add(i);
						break;
					}
				}else break;
			}
		}
		
		return res;
	}
	public static List<Integer> find(String a,String b)
	{	
		List<Integer> ind = new ArrayList<Integer>();
		int c=-1;
		for(int y=0;y<a.length();y++)
		{
			c=a.indexOf(b,c+1);
			if(c==-1)
			{
				break;
			}
			else	
			{		
				ind.add(c);
			}
		}
		return ind;
	}

}
