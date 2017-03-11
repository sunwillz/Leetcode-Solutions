package leetcode;



public class HelloWorld {
	
	public static void main(String[] args)  {
		for(int i=1;i<20;i++){
			for(int j=1;j<33;j++){
				int k = 100-i-j;
				if((5*i+3*j+k/3)==100 && k%3==0) 
					System.out.println("公鸡："+i+",母鸡："+j+",小鸡："+k);
			}
		}
		
	}

}
