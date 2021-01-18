import java.util.Scanner;
public class Q2046 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		n = sc.nextInt();
		m = sc.nextInt();
		switch(m) {
		case 1: first(n); break;
		case 2: second(n); break;
		case 3: third(n); break;
		}
	}
	
	static void first(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		return;
	}
	static void second(int n) {
		for(int i=1; i<=n; i++) {
			if(i%2 == 1) {
				for(int j=1; j<=n; j++) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
			else {
				for(int j=n; j>=1; j--) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
		}
		return;	
	}
	static void third(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(i*j + " ");
			}
			System.out.println();
		}
	}


}
