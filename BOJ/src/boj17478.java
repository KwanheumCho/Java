import java.util.Scanner;

public class boj17478 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		func(N);
	}
	
	static int N;
	
	static void func(int p) {
		func2(N-p);
		System.out.println("\"����Լ��� ������?\"");
		if(p==0) {
			func2(N-p);
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			func2(N-p);
			System.out.println("��� �亯�Ͽ���.");
			return;
		}
		func2(N-p);
		System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		func2(N-p);
		System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		func2(N-p);
		System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		// func recursive
		func(p-1);
		
		func2(N-p);
		System.out.println("��� �亯�Ͽ���.");
	}
	
	static void func2(int x) {
		if(x==0) return;
		System.out.print("____");
		func2(x-1);
	}
}
