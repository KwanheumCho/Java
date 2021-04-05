import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로_조관흠 {
	private static boolean[] chk;
	private static int N;
	private static int[][] cost;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		cost = new int[N][N];
		StringTokenizer stk = null;
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				
				cost[i][j]= Integer.parseInt(stk.nextToken());
			}
		}//for i
		
		//1번에서 출발하여 다시 1번으로 와야돼
		//최소로 순환..?
		
		chk = new boolean[N];
		answer = Integer.MAX_VALUE;
		chk[0] = true;
		DFS(0, 0, 0); //1번에서 출발 cnt = 0
		System.out.println(answer);
		
	}//main
	static int answer;
	static void DFS(int now , int cnt, int dist) {
		if(cnt==N-1) {
			if(cost[now][0] > 0)	answer = Math.min(answer, dist+cost[now][0]);
			else return;
		}
		if(dist > answer) return;
		
		for(int i=0; i<N; i++) {
			if(!chk[i] && cost[now][i] > 0) {
				chk[i] = true;
				DFS(i , cnt+1, dist+cost[now][i]);
				chk[i] = false;
			}
		}
	}
	
	
	
	
	
	
}
