import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_조관흠 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		for(int t=1; t<=10; t++) {
			sb.append("#").append(t).append(" ");
			stk = new StringTokenizer (br.readLine());
			int len = Integer.parseInt(stk.nextToken());
			int start = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer (br.readLine());
			boolean chk[][] = new boolean[101][101]; //input 체크
			List< List<Integer> > l = new LinkedList<>();
			for(int i=0; i<=100; i++) { // 0번 ~ 100번까지의 리스트 생성 // 0은 더미.
				l.add(new LinkedList<>());
			}
			for(int i=0; i<len/2; i++) {
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				if(!chk[from][to]) { //중복된 입력이 있을수 있으니 체크
					chk[from][to] = !chk[from][to];
					l.get(from).add(to);
				}
			}//for i
			//BFS 방식으로 체크
			Queue<Integer> q = new LinkedList<>();
			
			boolean visited[] = new boolean[101];
			q.add(start);
			visited[start] = true;
			int answer = 0;
			while(!q.isEmpty()) {
				int size = q.size(); // BFS에서의 거리에 따른 q의 size
				answer = 0;
				while(size > 0) {
					int before = q.poll();
					int list_size = l.get(before).size();
					for(int i=0; i< list_size; i++) {
						int item = l.get(before).get(i);
						if( !visited[item] ) {
							q.add(item);
							visited[item] = !visited[item];
						}
					}
					answer = Math.max(before, answer);
					size --;
				}//while size
			}//while q.isempty
			sb.append(answer).append("\n");
		}//test case
		System.out.println(sb);
		
		
		
	}//main
}
