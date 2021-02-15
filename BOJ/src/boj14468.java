import java.util.Arrays;
import java.util.Scanner;

public class boj14468 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int[][] arr = new int[26][2];
		for(int i=0; i<arr.length; i++) {
			Arrays.fill(arr[i], -1);
		}
		
		for(int i=0; i<input.length(); i++) {
			char x = input.charAt(i);
			int idx = x-'A';
			if(arr[idx][0] == -1 ) arr[idx][0] = i;
			else {
				arr[idx][1] = i;
			}
		}
		int answer = 0;
		for(int i=0; i<26; i++) {
			int start = arr[i][0];
			int end = arr[i][1];
			for(int j=0; j<26; j++) {
				if(i!=j) {
					if((arr[j][0] < start && arr[j][1] > start && arr[j][1] < end)||(arr[j][0] > start && arr[j][0] < end && arr[j][1] > end )) {
						answer++;
					}
				}
			}
		}
		System.out.println(answer/2);
	}
}
