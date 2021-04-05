import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_14502_연구소_조관흠 {
	private static int[][] arr;
	private static int N;
	private static int M;
	private static int wall_cnt;
	private static ArrayList<pos> virus;
	private static int virus_cnt;
	private static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		arr = new int[N][M];
		wall_cnt = 0;
		virus = new ArrayList<>();
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
				if(arr[i][j]==2) {
					virus.add(new pos(i, j));
				}
				else if(arr[i][j]==1) {
					wall_cnt++;
				}
			}
		}
		//0 : 빈칸 1: 벽  2: 바이러스
		answer = 0;
		make_wall(0);
		
		System.out.println(answer);
	}
	static void make_wall(int cnt)	{
		if(cnt == 3) {
			virus_cnt = 0;
			chk = new boolean[N][M];
			for(int i=0; i<virus.size();i++) {
				pos now = virus.get(i);
				spread(now.r, now.c);
			}
			int tmp = N*M - (virus_cnt +virus.size() + wall_cnt + 3);
			//System.out.println(tmp);
			answer = Math.max(tmp, answer);
			return;
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==0) {
					//System.out.println(i+" "+j+" "+cnt);
					arr[i][j] = 1;
					make_wall(cnt+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][]chk;
	static void spread(int r, int c) {
		
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0&&nr<N && nc>=0&&nc<M && !chk[nr][nc]) {
				if(arr[nr][nc] == 0) {
					//arr[nr][nc] = 2;
					chk[nr][nc] = true;
					virus_cnt++;
					spread(nr, nc);
				}
			}
		}
	}
	
	static class pos{
		int r, c;

		public pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
