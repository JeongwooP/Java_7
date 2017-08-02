import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlTest {
	public UrlTest(String ss) {
		try {
			URL url = new URL(ss);
			
			InputStream in = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str;
			while((str = br.readLine()) != null){
				System.out.println(str);
			}
			in.close();
			br.close();
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
	}
	
	public static void main(String[] args) {
		new UrlTest("http://www.daum.net:80/index.html");
		
	}

}
