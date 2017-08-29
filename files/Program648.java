package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program648 {
    public String replaceWords(List<String> dict, String sentence) {
    		if(dict==null||dict.size()==0) return sentence;
    		
    		Set<String> set = new HashSet<>();
    		for (String s : dict) set.add(s);
				
    		StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");
        
        for (String word : words) {
			String prefix = "";
			for (int i = 1; i <= word.length(); i++) {
				prefix = word.substring(0,i);
				if(set.contains(prefix))break;
			}
			sb.append(" "+prefix);
		}
        
        return sb.deleteCharAt(0).toString();
    }
    //trie
    public String replaceWords1(List<String> dict, String sentence) {
        String[] words = sentence.split("\\s+");
        TrieNode root = buildTrie(dict);
        
        return replaceWords(root,words);
    }
	private String replaceWords(TrieNode root, String[] words) {
		StringBuilder sb = new StringBuilder();
		for (String w : words) {
			sb.append(getShortestPrefix(root,w)).append(" ");
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
	private String getShortestPrefix(TrieNode root, String word) {
		StringBuilder sb = new StringBuilder();
		TrieNode cur = root;
		for (char ch: word.toCharArray()) {
			sb.append(ch);
			if(cur.child[ch-'a']!=null)
			{
				if(cur.child[ch-'a'].isWord) return sb.toString();
				cur = cur.child[ch-'a'];
			}
			else
			{
				return word;
			}
		}
		return word;
	}
	private TrieNode buildTrie(List<String> dict) {
		TrieNode root = new TrieNode(' ');
		for (String w : dict) {
			TrieNode temp = root;
			for (char c : w.toCharArray()) {
				if(temp.child[c-'a']==null)
				temp.child[c-'a'] = new TrieNode(c);
				
				temp = temp.child[c-'a'];
			}
			temp.isWord = true;
		}
		return root;
	}
}
class TrieNode {
	char val;
	TrieNode[] child;
	boolean isWord;
	
	public TrieNode(char val){
		this.val = val;
		this.child = new TrieNode[26];
		this.isWord = false;
	}
}
