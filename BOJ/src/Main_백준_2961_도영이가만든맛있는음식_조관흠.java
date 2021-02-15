import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2961_도영이가만든맛있는음식_조관흠 {
	private static int N;
	private static int[] sin;
	private static int[] sseun;
	private static boolean[] chk;
	private static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sin = new int[N];
		sseun = new int[N];
		chk = new boolean[N];
		answer = Integer.MAX_VALUE;
		StringTokenizer stk;
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(stk.nextToken());
			sseun[i] = Integer.parseInt(stk.nextToken());
		}
		//재료는 적어도 하나 이상 ~ N개까지.
		for(int i=1; i<=N; i++) {
			comb(0, i, 1, 0);
		}
		System.out.println(answer);
	}
	
	static void comb(int cnt, int target, int mul, int sum) {
		if(cnt == target) {
			int tmp = Math.abs(mul - sum);
			answer = Math.min(answer, tmp);
		}
		
		for(int i=0; i<N; i++) {
			if(!chk[i]) {
				chk[i] = true;
				comb(cnt+1, target, mul*sin[i], sum+sseun[i]);
				chk[i] = false;
			}
		}//for
	}
	
}
