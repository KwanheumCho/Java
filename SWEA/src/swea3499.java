import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			String x = br.readLine();
			StringTokenizer stk = new StringTokenizer(x);
			String arr[] = new String[N];
			for(int i=0; i<N; i++) {
				arr[i] = stk.nextToken();
			}
			sb.append("#").append(t);
			if(N%2 == 1) { //홀수인경우
				for(int i=0; i<N/2; i++) {
					sb.append(" ").append(arr[i]);
					sb.append(" ").append(arr[i+(N+1)/2]);
				}
				sb.append(" ").append(arr[N/2]);
			}
			else {
				for(int i=0; i<N/2; i++) {
					sb.append(" ").append(arr[i]);
					sb.append(" ").append(arr[i+N/2]);
				}
			}
			sb.append("\n");
		} // testcase

		System.out.println(sb);
	}
}
