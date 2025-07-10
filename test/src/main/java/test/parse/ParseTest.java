package test.parse;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class ParseTest {

	public ParseTest() {
		URL url=this.getClass().getClassLoader().getResource("test/parse/servlet-mapping.json");
		try {
			File file= new File(url.toURI());
			System.out.println(file.getAbsolutePath());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ParseTest();
	}

}
