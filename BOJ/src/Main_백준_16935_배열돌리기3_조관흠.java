import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16935_배열돌리기3_조관흠 {
	private static int[][] arr;
	private static int[][] tmp;
	private static int N;
	private static int M;
	private static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		int[] inst = new int[R];
		stk = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			inst[i] = Integer.parseInt(stk.nextToken());
			switch(inst[i]) {
				case 1 :
					func1();
					break;
				case 2 :
					func2();
					break;
				case 3 :
					func3();
					break;
				case 4 :
					func4();
					break;
				case 5 :
					func5();
					break;
				case 6 :
					func6();
					break;
			}
		}
		// N, M이 시계방향 회전때문에 계속해서 바뀐다
		N = arr.length;
		M = arr[0].length;
		for(int i=0; i<N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}//main
	
	static void func1() {
		N = arr.length;
		M = arr[0].length;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[N-1-i][j];
				arr[N-1-i][j] = tmp;
			}
		}
	}
	static void func2() {
		N = arr.length;
		M = arr[0].length;
		for(int i=0; i<M/2; i++) {
			for(int j=0; j<N; j++) {
				int tmp = arr[j][i];
				arr[j][i] = arr[j][M-1-i];
				arr[j][M-1-i] = tmp;
			}
		}
	}
	static void func3() {
		copy(); //tmp에 저장
		arr = new int[M][N];
		int left = 0, right =M-1;
		int up=0, down=N-1;
		int xleft = 0, xright= N-1;
		int xup=0, xdown=M-1;
		while(left<=right && up<=down) {
			for(int i=0; i<right-left; i++) {
				arr[xup+i][xright] = tmp[up][left+i];
				arr[xdown-i][xleft] = tmp[down][right-i];
			}
			for(int i=0; i<down-up; i++) {
				arr[xdown][xright-i] = tmp[up+i][right];
				arr[xup][xleft+i] = tmp[down-i][left];
			}
			left++;
			right--;
			up++;
			down--;
			xleft++;
			xright--;
			xup++;
			xdown--;
		}
	}//func3
	static void func4() {
		func3();
		func1();
		func2();
	}
	static void func5() {
		copy();
		N = arr.length;
		M = arr[0].length;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				arr[i][j+M/2] = tmp[i][j];
				arr[i][j] = tmp[i+N/2][j];
				arr[i+N/2][j] = tmp[i+N/2][j+M/2];
				arr[i+N/2][j+M/2] = tmp[i][j+M/2];
			}
		}
	}
	static void func6() {	
		copy();
		N = arr.length;
		M = arr[0].length;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				arr[i+N/2][j] = tmp[i][j];
				arr[i+N/2][j+M/2] = tmp[i+N/2][j];
				arr[i][j+M/2] = tmp[i+N/2][j+M/2];
				arr[i][j] = tmp[i][j+M/2];
			}
		}
	}
	
	
	static void copy() {
		N = arr.length;
		M = arr[0].length;

		tmp = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
	}
	
}//class
