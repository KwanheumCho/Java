import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_조관흠 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		for(int t=0; t<T; t++) {
			String x = br.readLine();
			stk = new StringTokenizer(x);
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			int[][] arr = new int[N][N];
			for(int n=0; n<N; n++) {
				String xx = br.readLine();
				stk = new StringTokenizer(xx);
				for(int j=0; j<N; j++) {
					arr[n][j] = Integer.parseInt(stk.nextToken());
				}
			}//input 종료
			
			int answer = 0;
			for(int r=0; r<= N-M; r++) {
				for(int c=0; c<= N-M; c++) {
					int tmp = 0;
					for(int dr=0; dr<M; dr++) {
						for(int dc=0; dc<M; dc++) {
							int row = r+dr;
							int col = c+dc;
							tmp += arr[row][col];
						}
					}//M block
					answer = Math.max(answer, tmp);
				}
			}
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}//testcase
		System.out.println(sb);
	
	}//main
}
