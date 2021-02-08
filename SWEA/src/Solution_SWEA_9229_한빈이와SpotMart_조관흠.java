import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart_조관흠 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String x = br.readLine();
			StringTokenizer stk = new StringTokenizer(x);
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			// 두봉지의 무게 <= M
			// 완탐 => N^2
			// 정렬 후 선형탐색 => NlogN
			stk = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			int answer = -1;
			boolean flag = false;
			//Solution1. 그냥 완탐으로 진행
			  for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					int sum = arr[i] + arr[j];
					if( sum < M) {
						answer = Math.max(answer, sum);
					}
					else if(sum == M ) { // break구문 : 시간을 줄여보기 위한 시도
						answer = M;
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			
			// Solution2. 정렬후 완탐느낌.. 유의미한 시간차이 X
			 /* Arrays.sort(arr);
			for(int i=0; i<N; i++) {
				if( arr[i] > M/2) break; // 정렬되어있으므로 M/2보다 크다면 들수없다.break!
				for(int j=i+1; j<N; j++) {
					int sum = arr[i] + arr[j];
					if( sum < M) {
						answer = Math.max(answer, sum);
					}
					else if(sum == M ) { // break구문 : 시간을 줄여보기 위한 시도
						answer = M;
						flag = true;
						break;
					}
				}
				if(flag) break;
			}*/
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}//test case
		System.out.println(sb);
	}//main
}
