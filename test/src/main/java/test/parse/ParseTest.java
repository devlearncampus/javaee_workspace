package test.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ParseTest {

	public ParseTest() {
		URL url=this.getClass().getClassLoader().getResource("test/parse/servlet-mapping.json");
		try(Reader reader = new FileReader(new File(url.toURI()))) {
			
			Gson gson = new Gson();
			
			JsonElement root=JsonParser.parseReader(reader);
			System.out.println(root);
			
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ParseTest();
	}

}
