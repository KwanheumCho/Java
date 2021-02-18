import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea1247 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			StringTokenizer stk = new StringTokenizer(input);
			int[] arr = new int[N];
			int company=0;
			int home = 0;
			company += Integer.parseInt(stk.nextToken()) + Integer.parseInt(stk.nextToken());
			home += Integer.parseInt(stk.nextToken()) + Integer.parseInt(stk.nextToken());
			for(int i=0; i<N; i++) {
				arr[i] += Integer.parseInt(stk.nextToken()) + Integer.parseInt(stk.nextToken());
			}
			
			Arrays.sort(arr);
			int answer = Integer.MAX_VALUE;
			
			
			int idx1=0 , idx2=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i!=j) {
						int tmp = Math.abs(company-arr[i]) + arr[i]-arr[0] + arr[N-1]-arr[0];
						tmp += Math.abs(home-arr[j]) + arr[N-1]-arr[j];
						if(tmp < answer) {
							answer = Math.min(answer, tmp);
							idx1 = i;
							idx2 = j;
						}
					}
				}
			}
			System.out.println(idx1+" "+idx2);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
