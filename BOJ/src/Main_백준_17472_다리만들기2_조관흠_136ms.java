import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17472_다리만들기2_조관흠_136ms {
	private static int N;
	private static int M;
	private static boolean[][] visited;
	private static int[][] m;
	private static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk= new StringTokenizer(br.readLine());
		N= Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		m = new int[N][M]; // map
		int i_num = 7; //island_number max
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				m[i][j] = Integer.parseInt(stk.nextToken());
				
			}
		}
		//input end
		//프림알고리즘을 쓰기 위한 dist setting
		dist = new int[i_num][i_num];
		for(int i=0; i<i_num; i++) {
			for(int j=0; j<i_num; j++) {
				if(i==j) continue;
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		visited = new boolean[N][M]; //섬안에서 dfs 돌때 체크하는 방문배열
		//섬마다 번호 부여
		int number = 0; 
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(m[i][j]!=0 && !visited[i][j]) {
					find_island(new pos(i,j), ++number);
				}
			}
		}
		//최종 number가 섬의 수
		visited = new boolean[N][M]; //섬끼리 연결을 체크할때 섬안에서 도는 dfs
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(m[i][j]!=0 && !visited[i][j]) {
					find_way(new pos(i,j), m[i][j]);
				}
			}
		}
		
	
		boolean mst_visited[] = new boolean[number+1]; //0 is dummy
		int cnt = 0;
		int[] mst_dist = new int[number+1];
		Arrays.fill(mst_dist, Integer.MAX_VALUE);
		mst_dist[1] = 0;
		int result = 0;
		while(cnt < number) {
			int min_val = Integer.MAX_VALUE;
			int min_idx = -1;
			for(int i=1; i<=number; i++) {
				if(!mst_visited[i] && min_val > mst_dist[i]) {
					min_val = mst_dist[i];
					min_idx = i;
				}
			}
			if(min_idx==-1) {
				result = -1;
				break;
			}
			result += min_val;
			mst_visited[min_idx] = true;
			for(int i=1; i<=number; i++) {
				if(!mst_visited[i]) {
					mst_dist[i] = Math.min(mst_dist[i], dist[min_idx][i]);
				}
			}
			cnt++;
		}
		System.out.println(result);
	}//main
	
	
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static void find_island(pos start, int number) {
		int r = start.r;
		int c = start.c;
		m[r][c] = number;
		visited[r][c] = true;
		
		//섬의 시작점을 기준으로 dfs를 하며 연결성 파악
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] &&m[nr][nc]==1) {
				find_island(new pos(nr,nc), number);
			}
		}
	}
	
	static void find_way(pos start, int number) {
		int r = start.r;
		int c = start.c;
		visited[r][c] = true;
		make_bridge(start, number);
		
		//섬의 시작점을 기준으로 dfs를 하며 연결성 파악
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] &&m[nr][nc]==number) {
				find_way(new pos(nr,nc), number);
			}
		}
	}
	static void make_bridge(pos start, int number) {
		for(int i=0; i<4; i++) {			
			int r = start.r;
			int c = start.c;
			int len = 0;
			while(true) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					if(m[nr][nc] ==0) {
						len++;
						r = nr;
						c = nc;
					}
					else {
						if(len>=2 && m[nr][nc]!=number) {
							dist[number][m[nr][nc]] = Math.min(dist[number][m[nr][nc]], len);
						}
						break;
					}
				}
				else break;
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
