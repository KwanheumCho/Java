import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class test {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "abcdefg";
		String ss = "asdfasfd";
		bw.write(s);
		bw.newLine();
		bw.write(ss);
		//bw.flush();
		//bw.close();
	}
}
