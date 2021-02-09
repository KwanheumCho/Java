import java.util.Scanner;

public class Main_백준_2563_색종이_조관흠 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		paper = new boolean[100][100];
		chk = new boolean[100][100];
		for(int i=0; i<N; i++) {
			int a = sc.nextInt(); // x좌표
			int b = sc.nextInt(); // y좌표
			//x,y좌표 기준으로 위로 10 오른쪽으로 10
			for(int r=0; r<10; r++ ) {
				for(int c =0; c<10; c++) {
					paper[a+r][b+c] = true;
				}
			}
		}
		//검은색종이가 있는 칸은 모두 true
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j] && !chk[i][j]) {//검은색종이의 영역이고, 방문하지않았다면
					chk[i][j] = !chk[i][j];
					move(i,j);
				}
			}
		}
		System.out.println(answer);
	}//main
	
	static int[] dr = new int[] {1, 0, -1, 0}; //북 동 남 서
	static int[] dc = new int[] {0, 1, 0, -1};
	static int answer = 0;
	static boolean[][] paper;
	static boolean[][] chk;
	
	static void move(int r, int c) {
			answer++;
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr>=0 && nr<100 && nc>=0 && nc<100) {//흰색종이 범위안
					if(paper[nr][nc] && !chk[nr][nc]) {//검은색종이의 영역이고, 방문하지않았다면
						chk[nr][nc] = !chk[nr][nc];
						move(nr,nc);
					}
				}
			}
		
	}//move
}//class
