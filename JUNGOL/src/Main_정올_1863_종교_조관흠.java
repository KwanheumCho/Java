import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1863_종교_조관흠 {
	private static int n;
	private static int m;
	private static int[] parents;
	private static boolean[] chk;
	private static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		parents = new int[n+1];
		make();
		chk = new boolean[n+1];
		answer = 0;
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			union(x , y);
		}
		
		for(int i=1; i<n+1; i++) {
			int final_parent = find_parent(i);
			if(!chk[final_parent]) {
				chk[final_parent] = true;
				answer++;
			}
		}
		System.out.println(answer);
		
		
	}//main
	static void make() {
		for(int i=1; i<n+1; i++) {
			parents[i] = i;
		}
		return;
	}
	
	static int find_parent(int idx) {
		if(parents[idx] == idx) return idx;
		return parents[idx] = find_parent(parents[idx]);
	}
	
	static void union(int a, int b) {
		int aRoot = find_parent(a);
		int bRoot = find_parent(b);
		if(bRoot < aRoot) { //root번호가 작은쪽으로 계속합쳐나감.
			int tmp = aRoot;
			aRoot = bRoot;
			bRoot = tmp;
		}
		if(aRoot == bRoot) return;
		else {
			parents[bRoot] = aRoot;
		}
		
		return;
	}
}	
