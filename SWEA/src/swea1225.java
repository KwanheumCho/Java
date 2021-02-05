import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for(int t=1; t<=T; t++) {
			br.readLine(); //test case number이 입력받지만 불필요
			String x = br.readLine();
			StringTokenizer stk = new StringTokenizer(x);
			Queue<Integer> q = new LinkedList<>();
			for(int n=0; n<8; n++) { //8개의 암호
				int number = Integer.parseInt(stk.nextToken());
				q.offer(number);
			}
			boolean flag = false;
			while(true) {
				for(int i=1; i<=5; i++) {
					int now = q.poll()-i;
					if(now<=0) {
						now = 0;
						flag = true;
					}
					q.offer(now);
					if(flag) break;
				}
				if(flag) break; // 반복문이 두개라 flag를 통해 break를 한번 더 세팅
			}
			
			
			//출력문
			sb.append("#").append(t).append(" ");
			while(!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}//testcase
		System.out.println(sb);
	}//main
}
