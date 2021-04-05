import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_SWEA_1263_사람네트워크2_조관흠 {
	private static int[][] network;
	private static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = null;
		for(int t= 1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			stk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(stk.nextToken());
			network = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					network[i][j] = Integer.parseInt(stk.nextToken());
				}
			}//input end
			
			int min_val = Integer.MAX_VALUE;
			for(int s=0; s<n; s++) {		
				int tmp = 0;
				int[] answer = Dijk(s);
				for(int i : answer) {
					tmp+=i;
				}
				min_val = Math.min(min_val, tmp);
			}
			sb.append(min_val).append("\n");
			
		}//test case
		System.out.println(sb); 
	}//main
	static int[] Dijk(int start) {
		boolean visited[] = new boolean[n];
		int dist[] = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		visited[start] = true;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start, dist[start]));
		
		while(!pq.isEmpty()) {
			node now = pq.poll();
			
			for(int i=0; i<n; i++) {
				if(!visited[i] && network[now.idx][i]>0 ) {
					int new_dist = now.dist+network[now.idx][i];
					dist[i]= Math.min(dist[i], new_dist);
					pq.offer(new node(i, dist[i]));
					visited[i] = true;
				}
			}
		}
		return dist;
	}
	
	static class node implements Comparable<node>{
		int idx;
		int dist;
		public node(int idx, int dist) {
			super();
			this.idx = idx;
			this.dist = dist;
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}
		
	}
}
