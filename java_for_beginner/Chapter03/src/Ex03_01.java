import java.util.Scanner;
public class Ex03_01 {
		
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("정수를 입력하세요 ==> ");
		int a = s.nextInt();
		
		System.out.printf("10진수 ==> %d\n", a);
		System.out.printf("16진수 ==> %X\n", a );
		System.out.printf("8진수 ==> %o\n", a );
		
	}

}
