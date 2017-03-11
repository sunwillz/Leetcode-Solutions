package leetcode;

public class Program520 {

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("mL"));
	}
	public static boolean detectCapitalUse(String word) {
		
		return word.matches("[A-Z]*|[A-Z]?[a-z]*");
		
		/*if(word.length()==0 || word==null) return false;
		if(word.length()==1)return true;
		boolean hasUpper = false;
		boolean hasLower = false;
		for (char c : word.toCharArray()) {
			if(Character.isUpperCase(c)){
				hasUpper = true;
			}else{
				hasLower = true;
			}
		}
		if(hasUpper && ! hasLower || hasLower && ! hasUpper){
			return true;
		}else if(Character.isLowerCase(word.charAt(0))){
			return false;
		}
		else{
			for (int i = 1; i < word.length(); i++) {
				char c = word.charAt(i);
				if(Character.isUpperCase(word.charAt(0))&&Character.isUpperCase(c))
					return false;
			}
		}
		return true;*/
    }

}
