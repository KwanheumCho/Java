import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고_조관흠 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		substance[] arr = new substance[N];
		StringTokenizer stk;
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			int low = Integer.parseInt(stk.nextToken());
			int high = Integer.parseInt(stk.nextToken());
			arr[i] = new substance(low , high);
		}
		Arrays.sort(arr);
		int answer = 1;
		int tmp = arr[0].high;
		for(int i=1; i<N; i++) {
			if(arr[i].low <= tmp) {
				continue;
			}
			else {
				tmp = arr[i].high;
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static class substance implements Comparable<substance>{
		int low;
		int high;
		public substance(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(substance o) {
			// TODO Auto-generated method stub
			return this.high - o.high;
		}
		
	}
}
