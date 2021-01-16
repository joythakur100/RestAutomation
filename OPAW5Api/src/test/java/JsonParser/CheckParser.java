package JsonParser;

public class CheckParser {

	public static void main(String[] args) {
		
		Employee eobj = new Employee("Kushal", "Manager", 13, 70000);
		
		JavaToJsonParser parser = new JavaToJsonParser();
		parser.marshalling(eobj);
		System.out.println("pass");
	}
}
