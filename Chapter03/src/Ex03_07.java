import java.util.Scanner;
public class Ex03_07 {

	public static void main(String[] args) {
		System.out.print("���ڿ��� �Է��ϼ��� => ");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String answer = "";
		for(int i=input.length()-1; i>=0; i--) {
			answer += input.charAt(i);
		}
		System.out.println(answer);
	}

}
