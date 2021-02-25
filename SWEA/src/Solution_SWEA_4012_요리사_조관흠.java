
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_조관흠 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			answer=Integer.MAX_VALUE;
			for(int n=0; n<N; n++) {
				String x = br.readLine();
				StringTokenizer stk = new StringTokenizer(x);
				for(int j=0; j<N; j++) {
					arr[n][j] = Integer.parseInt(stk.nextToken());
				}
			}//Input 끝
			chk = new boolean[N+1]; //false default
			divide(0, 1);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}//main
	
	static int N;
	static int[][]arr; //점수 배열
	static boolean[] chk;
	static int answer;
	static void divide(int cnt, int start) {
		if(cnt == N/2) {
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					//i==j여도 어차피 0
					if(chk[i] == chk[j]) {
						if(chk[i]) sum1+= arr[i][j] + arr[j][i];
						else sum2+= arr[i][j] +arr[j][i];
					}
				}
			}
			int tmp = Math.abs(sum1-sum2);
			answer = Math.min(tmp, answer);
			return;
		}
		if(N-start+cnt < N/2) {//start~N-1까지 남아있는 수 +cnt가 N이될수없을때
			return;
		}
		
		for(int i=start; i<N; i++) {
			chk[i] = true;
			divide(cnt+1, i+1);
			chk[i] = false;
		}
	}//divide
}
