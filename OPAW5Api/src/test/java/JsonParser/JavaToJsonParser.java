package JsonParser;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

public class JavaToJsonParser {

	public void marshalling(Employee eobj)
	{
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("Employee.json"), eobj);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Employee unmarshalling(File jsonData	, Class<Employee> edata)
	{
		Employee eobj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			eobj = mapper.readValue(jsonData, edata);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return eobj;
	}
}



















