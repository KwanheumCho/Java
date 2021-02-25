import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_조관흠 {
	private static int N;
	private static int[] arr;
	private static boolean[] chk;
	private static int[] perm_number;

	//순서도 고려
	//N이 1~9
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine()); ;
			arr = new int[N];
			chk = new boolean[N];
			total_sum = 0;
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
				total_sum += arr[i];
			}
			perm_number = new int[N];
			answer = 0;
			perm(0);
			//순열로 숫자의 순서를 미리 만들어놓고 (N!)
			//해당 숫자 순서에서, 각 순서가 왼쪽으로갈지 오른쪽으로갈지 세팅(2^N)
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		
	}//main
	
	static int answer;
	static int total_sum;
	static void perm(int cnt) {
		
		if(cnt == N) {
			subset(0,0,0);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!chk[i]) {
				chk[i] = true;
				perm_number[cnt] = arr[i];
				perm(cnt+1);
				chk[i] = false;
			}
		}
	}
	
	static void subset(int cnt , int left_sum, int right_sum) {
		if(left_sum < right_sum) return;
		if(left_sum > total_sum/2) {
			int tmp=1;
			for(int i=1; i<=N-cnt; i++) {
				tmp*=2;
			}
			answer+= tmp;
			return;
		}
		if(cnt == N) {
			answer++;
			return;
		}
		subset(cnt+1, left_sum+perm_number[cnt], right_sum);
		subset(cnt+1, left_sum, right_sum+perm_number[cnt]);
		
	}
}
