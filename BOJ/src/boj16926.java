import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int R = Integer.parseInt(stk.nextToken());
		int[][] arr = new int[N][M];
		 
		//배열 input 시작
		for(int i=0; i<N; i++) {
			String x = br.readLine();
			stk = new StringTokenizer(x);
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		//배열 input 종료
		
		int n = N;
		int m = M;
		int left_m=0, up_n=0;
		int right_m = m-1;
		int down_n = n-1;
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
			int index = R;
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
			//ll.clear();
			up_n+=1;
			down_n-=1;
			left_m+=1;
			right_m-=1;
		}
		//배열 output.
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}//main
}
