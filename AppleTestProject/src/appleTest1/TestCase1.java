package appleTest1;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestCase1 {
    public static void main(String[] args) throws IOException {
    	 String urlToTest = "http://someTestUrl";
    	 String response = Util.getResponse(urlToTest);
    	 JSONArray jarray = new JSONArray(response);
    	 for (int i=0;i < jarray.length(); i++){
    		 JSONObject jsonobject = jarray.getJSONObject(i);
    		 JSONObject carObj = jsonobject.getJSONObject("Car");
    		 String carMake = carObj.getString("make");
    		 JSONObject metadata = carObj.getJSONObject("metadata");
    		 String carColor = metadata.getString("Color");
    		 String carNotes = metadata.getString("Notes");
    		 if (carMake.equals("Tesla") && carColor.equals("Blue")){
    			 System.out.println(carObj.toString());
    			 System.out.println(carNotes);
    		 }
    	 }
    }
}
