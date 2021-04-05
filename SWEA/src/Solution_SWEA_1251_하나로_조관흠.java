import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1251_하나로_조관흠 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			for(int i=0; i<2; i++) {
				stk = new StringTokenizer(br.readLine());				
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
		double E = Double.parseDouble(br.readLine());	
		//input end
		double [][] dist = new double[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i!=j) {
					dist[i][j] = Math.pow(arr[0][i] - arr[0][j], 2) + Math.pow(arr[1][i] - arr[1][j], 2);
				}
			}
		}
		
		boolean[] visited = new boolean[n];
		double[] chk_d = new double[n];
		double total_dist = 0;
		Arrays.fill(chk_d, Double.MAX_VALUE);
		chk_d[0] = 0;
		int cnt = 0;
		while(cnt < n) {
			int min_idx = -1;
			double min_val = Double.MAX_VALUE;
			for(int i=0; i<n; i++) {
				if(!visited[i] && chk_d[i] < min_val) {
					min_val = chk_d[i];
					min_idx = i;
				}
			}
			total_dist += min_val;
			//min_idx 이 새로선택하는 노드.
			//이걸 기준으로 chk_d 업데이트
			visited[min_idx] = true;
			for(int i=0; i<n; i++) {
				//if(i==min_idx) continue;
				if( !visited[i] && chk_d[i] > dist[min_idx][i]) {
					chk_d[i] = dist[min_idx][i];
				}
			}
			cnt++;
		}//while
		long answer =(long) Math.round(Math.floor(total_dist*E*10)/10);
		sb.append(answer).append("\n");
		}//test  case
		System.out.println(sb);
	}
}	
