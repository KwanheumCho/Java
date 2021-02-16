import java.util.Scanner;

public class boj1074 {
	private static int r;
	private static int c;
	private static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		func(N, 0, 0);
	}
	static int answer = 0;
	static void func(int N, int start_row , int start_col) {
		if(flag) return;
		
		int len = 1<<N;
		if(start_row+len <= r || start_col+len <= c ) {
			answer += len*len;
			return;
		}
		
		if(N==1) {
			int now_r, now_c;
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					now_r = start_row+i;
					now_c = start_col+j;
					if(now_r == r && now_c == c) {
						System.out.println(answer);
						flag = true;
					}
					answer++;
				}
			}
			return;
		}
		int gap = 1<<(N-1);
		func(N-1, start_row, start_col);
		func(N-1, start_row, start_col+gap);
		func(N-1, start_row+ gap, start_col);
		func(N-1, start_row+ gap, start_col+gap);
		
	}
}
