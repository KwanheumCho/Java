import java.util.Scanner;

public class Q1303 {
	public static void main(String[] args) {
		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int number = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(number++ + " ");
			}
			System.out.println();
		}
	}
}
