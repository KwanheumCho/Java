import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1861 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[]dr = new int[] {-1, 0, 1, 0};
		int[]dc = new int[] {0, 1, 0, -1};
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N+2][N+2];
			for(int n=1; n<=N; n++) {
				String x = br.readLine();
				StringTokenizer stk = new StringTokenizer(x);
				for(int j=1; j<=N; j++) {
					arr[n][j] = Integer.parseInt(stk.nextToken());
				}
			}
			int max_cnt = 0;
			int cmp_val = 0;
			for(int r=1; r<=N; r++) {
				for(int c=1; c<=N; c++) {
					int rr = r;
					int cc =c;
					int cnt = 1;
					int init_val = arr[r][c];
					while(true) {
						boolean flag = false;
						for(int i=0; i<4; i++) { //dir 위 오른쪽 아래 왼쪽
							int nr = rr+dr[i];
							int nc = cc+dc[i];
							//System.out.println("while: "+nr+" "+nc);
							if(arr[nr][nc] == arr[rr][cc]+1) {
								rr = nr;
								cc = nc;
								cnt++;
								flag = true;
							}
						}
						//System.out.println(rr+" "+cc+" "+cnt);
						if(!flag) {
							break;
						} 
					}//while
					if( cnt > max_cnt) {
						max_cnt = cnt;
						cmp_val = init_val;
					}
					else if(cnt == max_cnt) {
						cmp_val = Math.min(cmp_val, init_val);
					}
				}//for c
			}//for r
			sb.append("#").append(t).append(" ").append(cmp_val).append(" ").append(max_cnt).append("\n");
		}//test case
		System.out.println(sb);
	}
}
