import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea1210 {
	//일단 이차원 배열에 입력을 받고, 0번row에 값이 1인 index를 1차원배열에 따로 저장
	//재귀함수 이용? 현재 좌표와 진행방향을 넘겨주면될거같은데
	//조건문에서 좌,우를 살펴서 연결된 가로축 사다리가 있는지 확인 후 있다면 그방향으로 진행
	//만약 row가 100일때 값이 2라면 flag를 true로 체크하고 답을 출력 후 종료
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			arr = new int[101][102]; // row : 1~100 , col : 1~100 // col에서 0과 101은 dummy
			int arrive_idx = 0;
			int test_number =Integer.parseInt(br.readLine());
			for(int l=1; l<=100; l++) {
				String input = br.readLine();
				StringTokenizer stk = new StringTokenizer(input);
				for(int s=1; s<=100; s++) {//숫자100개
					arr[l][s] = Integer.parseInt(stk.nextToken());
					if(l==100 && arr[l][s]==2) arrive_idx = s; 
				}
			}
			//Input 종료
			//arrive_idx부터 위로 올라간다고생각
			func(100, arrive_idx, 0);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		} // for
		System.out.println(sb);
	}//main
	static int[] dr = {-1, 0, 1, 0}; //북 동 남 서 순서
	static int[] dc = {0, 1, 0, -1};
	static int answer = 0;
	static void func(int row, int col, int dir) {
		if(row==1) {
			answer = col-1; // 문제에선 인덱스가 0기준
			return;
		}
		int nr, nc;
		if(dir==0) {//방향이 위쪽이라면, 우선 좌or우를 체크
					//범위 끝도 생각해야하지만, 배열만들때 dummy만들어놔서 체크안해도 됨. 
			if(  arr[row+dr[3]][col+dc[3]] == 1) {
				dir = 3;
			}
			else if( arr[row+dr[1]][col+dc[1]] == 1) {
				dir = 1;
			}
			nr = row+dr[dir];
			nc = col+dc[dir];
			if(arr[nr][nc]==1) func(nr, nc, dir); //조건문 없어도 될듯?
		}
		else if(dir==3 || dir==1) {
			nr = row+dr[dir];
			nc = col+dc[dir];
			if(arr[nr][nc]!=1) {
				nr = row+dr[0];
				nc = col +dc[0];
				dir = 0;
			}
			func(nr,nc,dir);
		}
	}
}
