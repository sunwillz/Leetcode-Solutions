package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program609 {
	public static void main(String[] args) {
//		String[] s = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
//				System.out.println(findDuplicate(s).toString());
	    // 要验证的字符串
	    String str = "1.txt(abcd)";
	    // 正则表达式规则
	    String regEx = ".*\\.txt";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 查找字符串中是否有匹配正则表达式的字符/字符串
	    boolean rs = matcher.find();
	    
	    System.out.println(matcher.group());
	}
    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans=  new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<>();
        String regEx = "*\\.txt";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher;
        String fname = null;
        String path;
        String content;
        for (String str: paths) {
			String[] strArr = str.split(" ");
			String dir = strArr[0];
			for(int i =1;i<strArr.length;i++){
				matcher = pattern.matcher(strArr[i]);
				if(matcher.find())
					fname = matcher.group();
				content = strArr[i].substring(fname.length()+1,strArr[i].length()-1);
				path = dir+"/"+fname;
				System.out.println(content+"   "+path);
				if(!map.containsKey(content))map.put(content, new ArrayList<String>());
				map.get(content).add(path);
			}
		}
        for (String s : map.keySet()) {
        		if(map.get(s).size()>1)
			ans.add(map.get(s));
		}
        return ans;
    }
}
