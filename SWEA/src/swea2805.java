import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class swea2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				for(int j=0; j<N; j++) {
					arr[i][j] = input.charAt(j)-'0';
				}
			}//for
			//input finish
			int answer = 0;
			for(int i=0; i<N; i++) {
				answer += arr[i][N/2];
				if(i<N/2) {
					for(int j=1; j<=i; j++) {
						answer += arr[i][N/2-j] + arr[i][N/2+j];
					}
				}
				else {
					for(int j= N-1-i; j>=1; j--) {
						answer += arr[i][N/2-j] + arr[i][N/2+j];
					}
				}
			}
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}//testcase
		System.out.println(sb);
	}
}
