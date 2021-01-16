package JsonParser;

import java.io.File;

public class CheckUnmarshal {

	public static void main(String[] args) {
		
		File f = new File("Employee.json");
		
		JavaToJsonParser parser = new JavaToJsonParser();
		Employee eobj = parser.unmarshalling(f, Employee.class);
		
		System.out.println(eobj);
	}
}
