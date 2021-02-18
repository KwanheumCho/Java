import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_1987_알파벳_조관흠 {
	private static char[][] map;
	private static int R;
	private static int C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for(int r=0; r<R; r++) {
			String input = sc.next();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
			}
		}
		//input end
		chk = new boolean[26];
		map_chk = new boolean[R][C];

		chk[map[0][0]-'A'] = true;
		map_chk[0][0] = true;
		DFS(0, 0, 1);
		System.out.println(answer);
	}
	static boolean[] chk;
	static boolean[][] map_chk;
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int answer;
	//목적지가 따로 없네?
	static void DFS(int r, int c, int number) {
		
		
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<R && nc>=0 && nc<C) {
				if(!map_chk[nr][nc] && !chk[map[nr][nc]-'A']) {
					//방문하지 않았고, 알파벳도 겹치지않으면
					chk[map[nr][nc]-'A'] = true;
					map_chk[nr][nc] = true;
					DFS(nr , nc , number+1);
					chk[map[nr][nc]-'A'] = false;
					map_chk[nr][nc] = false;
				}
			}
		}
		//4방향 다 못가는 경우 여기로 내려옴
		answer = Math.max(answer, number);
		return;
	}
}
