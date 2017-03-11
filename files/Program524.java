package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program524 {

	public static void main(String[] args) {
		String str = "apple";
		String[] d = new String[]{"zxc","vbn"};
 		System.out.println(findLongestWord(str, Arrays.asList(d)));
	}
	/**
	 * str1字符串能不能通过str2删除一些字母得到
	 * 比如str1="apple",str2="abpcplea",返回true
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean canFormByDelete(String str1,String str2){
		int cur1 = 0;
		int cur2 = 0;
		while(cur1<str1.length()&&cur2<str2.length()){
			if(str1.charAt(cur1)==str2.charAt(cur2)){
				++cur1;
				++cur2;
			}
			else ++cur2;
		}
		if(cur1==str1.length())
		return true;
		else
			return false;
	}
	public static String findLongestWord(String s, List<String> d) {
		int maxlen = 0;
		List<String> list = new ArrayList<String>();
        for (String str : d) {
			if(canFormByDelete(str, s)){
				if(maxlen<=str.length()){
					maxlen = str.length();
					list.add(str);
				}
			}
		}
        Collections.sort(list, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int x = o2.length()-o1.length();
				int y = o1.compareTo(o2);
				if(x==0){
					return y;
				}
				return x;
				}
        	});
        if(list.size()>0)
		return list.get(0);
        else
        	return "";
		}
	public static void sort(String[] d){
		List<String> list = Arrays.asList(d);
		System.out.println(list.toString());
		Collections.sort(list, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				int x = o2.length()-o1.length();
				int y = o1.compareTo(o2);
				if(x==0){
					return y;
				}
				return x;
				}
			
		});
		System.out.println(list.toString());
	}
}
