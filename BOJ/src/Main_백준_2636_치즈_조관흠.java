import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2636_치즈_조관흠{
	private static int[][] m;
	private static boolean[][] visited;
	private static int r;
	private static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		m= new int[r][c];
		
		for(int i=0; i<r; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				m[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		int time = 0;
		int	sec_before = 0;
		while(true) {
			tmp_remove = 0;
			visited = new boolean[r][c];
			remove_chk = new boolean[r][c];
			//1. 공기가 있는 공간을 찾아서 visited에 표시
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(!visited[i][j] && (i==0 ||i==r-1 || j==0 ||j==c-1) && m[i][j]==0){
						DFS(i,j);
					}
				}
			}
			//2. 공기와 접촉하는 치즈를 찾고 , remove_chk에 표시
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(!visited[i][j] && m[i][j]==1){
						DFS2(i,j);
					}
				}
			}
			if(tmp_remove == 0) break;
			//3. remove_chk를 보고 일괄적으로 치즈 제거
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(remove_chk[i][j] && m[i][j]==1){
						m[i][j] = 0;
					}
				}
			}
			sec_before = tmp_remove;
			time ++;
		}
		
		/*for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
			}*/
		System.out.println(time);
		System.out.println(sec_before);
		
	}//main
	
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static boolean remove_chk[][];
	static int tmp_remove = 0;
	
	static void DFS2(int row , int col) {
		visited[row][col] = true;
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if(nr>=0 && nr<r && nc>=0 && nc<c && m[nr][nc]==0 && visited[nr][nc]) { //공기와 접촉하는 치즈라면
				tmp_remove ++;
				remove_chk[row][col]= true;
				break;
			}
		}
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if(nr>=0 && nr<r && nc>=0 && nc<c && m[nr][nc]==1 && !visited[nr][nc]) {
				DFS2(nr, nc);				
			}
		}
	}
	
	static void DFS(int row , int col) {
		visited[row][col]= true;
		
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if(nr>=0 && nr<r && nc>=0 && nc<c && m[nr][nc]==0 && !visited[nr][nc]) {
				DFS(nr, nc);				
			}
		}
	}
}
