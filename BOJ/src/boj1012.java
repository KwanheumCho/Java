import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class boj1012 {
	static int T, col, row, number;
	static int[] mr = {1, 0, -1, 0};
	static int[] mc = {0, 1, 0, -1};
	static boolean[][] _map;
	static boolean[][] _chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			col = Integer.parseInt(stk.nextToken());
			row = Integer.parseInt(stk.nextToken());
			number = Integer.parseInt(stk.nextToken());
			_map = new boolean[row][col];
			_chk = new boolean[row][col];
			for(int i=0; i<number; i++) {
				stk = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(stk.nextToken());
				int r = Integer.parseInt(stk.nextToken());
				_map[r][c] = true; //���߰� ������ true
			}
			
			int cnt = 0;
			for(int r=0; r<row; r++) {
				for(int c = 0; c<col; c++) {
					if(_map[r][c] && !_chk[r][c]) { //���߰� �ְ�, �湮���� ���� ��ġ
						_chk[r][c] = true; //�湮 ���� üũ �� DFS����
						DFS(r, c);
						cnt++;
					}
				}//for c
			}//for r
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}// main

	static void DFS(int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r + mr[i];
			int nc = c + mc[i];
			if(nr>=0 && nr<row && nc>=0 && nc<col) {
				if(_map[nr][nc] && !_chk[nr][nc]) {
					_chk[nr][nc] = true;
					DFS(nr, nc);
				}
			}
		}//for
		return;
	}
}
