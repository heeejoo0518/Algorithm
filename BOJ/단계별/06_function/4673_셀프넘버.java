public class BOJ_4673_셀프넘버 {
	static final int SIZE = 10000;
	public static boolean[] selfNumCheck = new boolean[SIZE+1];
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<SIZE;i++) {
			if(!selfNumCheck[i]) {
				sb.append(i).append("\n");
			}
			selfNumCheck[selfNumber(i)] = true;
		}
		
		System.out.println(sb.toString());
	}

	public static int selfNumber(int num) {
		int n = num;
		
		while(num != 0) {
			n+=num%10;
			num/=10;
		}
		
		if(n>SIZE) return 0;
		
		return n;
		
	}
}
