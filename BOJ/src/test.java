import java.io.IOException;
import java.util.ArrayList;

public class test {
	public static void main(String[] args) throws IOException {
		ArrayList al = new ArrayList();
		al.add("È£¶ûÀÌ");
		al.add(3);
		System.out.println(al.size());
		System.out.println(al.get(1));
		System.out.println(al.indexOf("È£¶ûÀÌ"));
		System.out.println(al.contains("È£¶ûÀÌ"));
	}
}
