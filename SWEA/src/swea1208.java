import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1208 {
	public static void main(String[] args) throws IOException {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			int dump = Integer.parseInt(br.readLine());
			String input = br.readLine();
			StringTokenizer stk = new StringTokenizer(input);
			int height_arr[] = new int[101];// 높이1: arr[1] ,, arr[0]:dummy
			
			//100개의 높이가 읽어질거임
			int max_h = Integer.MIN_VALUE;
			int min_h = Integer.MAX_VALUE;
			int sum = 0;
			while(stk.hasMoreTokens()) {
				int x = Integer.parseInt(stk.nextToken());
				sum += x;
				height_arr[x]++;
				if( max_h < x) max_h = Integer.max(max_h, x);
				if( min_h > x) min_h = Integer.min(min_h, x);
			}
			//target은 평탄화를 통해 도달할 수 있는 값을 의미함
			int target = 1;
			if(sum%100 ==0) {
				target = 0;
			}
			//
			for(int d=0; d<dump && max_h-min_h>target ; d++) {
				
				height_arr[max_h] -= 1;
				height_arr[max_h-1] +=1;
				height_arr[min_h] -= 1;
				height_arr[min_h+1] += 1;
				if( height_arr[max_h] <= 0) {
					max_h -= 1;
				}
				if(height_arr[min_h] <= 0) {
						min_h += 1;
				}
			} //for
			
			sb.append("#").append(t+1).append(" ").append(max_h-min_h).append("\n");
		}//Test case
		System.out.println(sb);
	} // main
}
