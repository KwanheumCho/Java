import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2105 {
	private static int[][] map;
	private static int N;
	private static int dr[] = {-1, -1, 1, 1}; //왼위 , 오위, 오른아래, 왼아래
	private static int dc[] = {-1, 1, 1, -1};
	private static boolean type_chk[];
	private static boolean visited_chk[][];
	private static boolean[] dir_chk;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int type_max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
					type_max = Math.max(type_max, map[i][j]);
				}
			}
			//Input End
			answer = -1;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					type_chk = new boolean[type_max+1];
					visited_chk = new boolean[N][N];
					type_chk[map[i][j]] = true;
					visited_chk[i][j] = true;
					dir_chk = new boolean[4];
					start_row = i;
					start_col = j;
					DFS(i, j, 1, 0);
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}//test case
		System.out.println(sb);
	}
	static int start_row;
	static int start_col;
	static int answer;
	static void DFS(int row, int col, int cnt, int dir) {
		for(int i=dir; i<4; i++) {
			int nr=0,nc=0;
			nr = row+dr[i];
			nc = col+dc[i];
			if(nr>=0&&nr<N&&nc>=0&&nc<N) {
				if(cnt>=3 && nr==start_row && nc==start_col) {
					answer = Math.max(answer, cnt);
				}
				int new_type = map[nr][nc];
				if(!type_chk[new_type] && !visited_chk[nr][nc]) {
					type_chk[new_type] = true;
					visited_chk[nr][nc] = true;
					DFS(nr , nc , cnt+1, i);
					type_chk[new_type] = false;
					visited_chk[nr][nc] = false;
				}
			}
		}
		return;
	}
}
