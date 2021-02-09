import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class boj1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		//1, \\ 4, \, \ \
		//배열로하면 너무많이 돌아야될거같은데?
		List<Integer> ll = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			//1부터 N까지의 수가 들어감
			ll.add(i);
		}
		int[] arr = new int[N];
		int cnt = 0; // 
		int size = ll.size();
		int number = 0;
		while(! ll.isEmpty()) {
			cnt+=K-1;
			if(cnt>=size) {
				cnt %= size;
			}
			arr[number++] =  ll.get(cnt);
			ll.remove(cnt);
			size = ll.size();
		}
		//출력
		StringBuilder sb = new StringBuilder("<");
		for(int i=0; i<arr.length;i++) {
			sb.append(arr[i]).append(", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}//main
}
