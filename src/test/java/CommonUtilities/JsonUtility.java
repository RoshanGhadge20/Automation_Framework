package CommonUtilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import BaseTest.Base_Test;

public class JsonUtility extends Base_Test {
	public JsonObject jobj;
	String json_file_path = "E://Automation_Framework//POM//Test_Data//logindetails.json";

	public JsonUtility() throws IOException, FileNotFoundException {
		super();
	}

	public void load_jsonfile(String json_file_path) throws FileNotFoundException {
		FileReader fr = new FileReader(json_file_path);
		jobj = JsonParser.parseReader(fr).getAsJsonObject();

	}

	public String getvaluebykey(String key) {
		return jobj.get(key).getAsString();
	}

}
