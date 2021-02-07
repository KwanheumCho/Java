import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
		char[] ch = x.toCharArray();
		for(char c : ch) {
			System.out.println(c);
		}
		StringTokenizer st = new StringTokenizer(x, "_");
		//StringTokenizer stk = new StringTokenizer()
		System.out.println(st.countTokens());
	}
}
