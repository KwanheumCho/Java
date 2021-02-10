import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17406_배열돌리기4_조관흠 {
	private static int[][] arr;
	private static int[][] original;
	private static int N;
	private static int M;
	private static int K;
	static boolean[] chk;
	static int[] order;
	static r_set[] r_arr;
	static int answer=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N=Integer.parseInt(stk.nextToken());
		M=Integer.parseInt(stk.nextToken());
		K=Integer.parseInt(stk.nextToken());
		
		original= new int[N+1][M+1];
		for(int i=1; i<=N;i++) { //행,열의 시작인덱스 : 1
			stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				original[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		arr = new int[N+1][M+1];//회전해서 다룰 배열. 현재까지는 빈 배열. copy해야함 permu에서
		
		r_arr = new r_set[K]; //로테이션 명령의 집합
		for(int k=0; k<K; k++) {
			stk = new StringTokenizer(br.readLine());
			int r=Integer.parseInt(stk.nextToken());
			int c=Integer.parseInt(stk.nextToken());
			int s=Integer.parseInt(stk.nextToken());
			r_arr[k] = new r_set(r,c,s);
		}
		chk = new boolean[K];
		order = new int[K];
		permu(0);
		
		System.out.println(answer);
		
	}//main
	
	
	static void original_copy() { // 회전해서 다룰 arr에 original 값을 옮김
		for(int i=1;i<=N;i++) {
			for(int j=1; j<=M; j++) {
				arr[i][j] = original[i][j];
			}
		}
	}
	
	
	static void permu(int cnt ) {
		if(cnt == K) {
			original_copy();
			for(int j=0; j<K; j++) {
				//order에 실행해야하는 회전 순서가 있음
				int number = order[j];
				rotate(r_arr[number].r, r_arr[number].c, r_arr[number].s);
			}
			answer = Math.min(answer, calc());
			
			return;
		}
		for(int i=0; i<K; i++) {
			if(!chk[i]) {
				chk[i] = true;
				order[cnt] = i;
				permu(cnt+1);
				chk[i] = false;
			}
		}
	}
	
	static int calc() {
		int min_val = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			int tmp = 0;
			for(int j=1; j<=M; j++) {
				tmp += arr[i][j];
			}
			min_val = Math.min(min_val, tmp);
		}
		return min_val;
	}
	
	
	
	static void rotate(int r, int c , int s) {
		int left_m=c-s, up_n=r-s;
		int right_m = c+s;
		int down_n = r+s;
		int [] tmp;
		while( up_n <= down_n && left_m <= right_m) {
		/*->	1 2 3  4    <-
				5 6 7  8
				9 10 11 12
		 ->		13 14 15 16  <-*/
			int cnt = 0;
			tmp = new int[2*(right_m-left_m + down_n-up_n)];
			for(int j=left_m; j<right_m; j++) {
				tmp[cnt++] = arr[up_n][j];
			}
			for(int i=up_n; i<down_n; i++) {
				tmp[cnt++] = arr[i][right_m];
			}
			for(int j=right_m; j>left_m; j--) {
				tmp[cnt++] =arr[down_n][j];
			}
			for(int i=down_n; i>up_n; i--) {
				tmp[cnt++] =arr[i][left_m];
			}

			//다시 테두리 배열에 넣는 과정
			int size = tmp.length;
			int index = tmp.length-1;//시계방향 회전
			for(int j=left_m; j<right_m; j++) {	
				arr[up_n][j] = tmp[index%size];
				index++;
			}
			for(int i=up_n; i<down_n; i++) {
				arr[i][right_m] = tmp[index%size];
				index++;
			}
			for(int j=right_m; j>left_m; j--) {
				arr[down_n][j] = tmp[index%size];
				index++;
			}
			for(int i=down_n; i>up_n; i--) {
				arr[i][left_m] =tmp[index%size];
				index++;
			}
			up_n+=1;
			down_n-=1;
			left_m+=1;
			right_m-=1;
		}
	}//rotate
}

class r_set{
	int r;
	int c;
	int s;
	public r_set() {
		// TODO Auto-generated constructor stub
	}
	public r_set(int r, int c, int s){
		this.r = r;
		this.c = c;
		this.s = s;
	}
}
