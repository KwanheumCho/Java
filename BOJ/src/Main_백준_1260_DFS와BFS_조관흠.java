import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1260_DFS와BFS_조관흠 {
	static StringBuilder sb ;
	private static boolean[] visited;
	static List< List<Integer> > l;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer (br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int V = Integer.parseInt(stk.nextToken());

		l = new LinkedList<>();
		for(int i=0; i<=N; i++) { // N번까지의 리스트 생성 // 0은 더미.
			l.add(new LinkedList<>());
		}
		
		for(int i=0; i<M;i++) {
			stk = new StringTokenizer (br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			l.get(from).add(to);
			l.get(to).add(from);
		}
		
		for(int i=1; i<=N; i++) { // N번까지의 리스트를 오름차순 정렬
			l.get(i).sort( (o1, o2) -> {return o1 - o2;});
		}
		//DFS 방식
		sb = new StringBuilder();
		visited = new boolean[N+1];
		DFS(V);
		System.out.println(sb);
		
		//BFS 방식으로 체크
		Queue<Integer> q = new LinkedList<>();
		sb = new StringBuilder();
		visited = new boolean[N+1];
		q.add(V);
		visited[V] = true;
		while(!q.isEmpty()) {
			int before = q.poll();
			int list_size = l.get(before).size();
			for(int i=0; i< list_size; i++) {
				int item = l.get(before).get(i);
				if( !visited[item] ) {
					q.add(item);
					visited[item] = !visited[item];
				}
			}
			sb.append(before).append(" ");
		}//while q.isempty
		System.out.println(sb);
		//BFS 종료
		
	}//main
	
	static void DFS(int start) {
		visited[start] = !visited[start];
		sb.append(start).append(" ");
		
		int list_size = l.get(start).size();
		for(int i=0; i<list_size; i++) {
			int item = l.get(start).get(i);
			if( !visited[item] ) {
				DFS(item);
			}
		}
	}
	
	
	
	
}
