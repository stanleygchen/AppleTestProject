package appleTest1;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestCase3 {

    public static void main(String[] args) throws IOException {
    	final double THRESHOLD =0.01;
    	 String urlToTest = "http://someTestUrl";
    	 String response = Util.getResponse(urlToTest);
    	 JSONArray jarray = new JSONArray(response);
    	 
    	 double maxCarRevenue = Double.MIN_VALUE;    	 
    	 for (int i=0;i < jarray.length(); i++){
    		 JSONObject jsonobject = jarray.getJSONObject(i);
    		 JSONObject carObj = jsonobject.getJSONObject("Car");
    		 JSONObject perdayrent = carObj.getJSONObject("perdayrent");
    		 double price = perdayrent.getDouble("Price");
    		 double discount = perdayrent.getDouble("Discount");
    		 JSONObject metrics = carObj.getJSONObject("metrics"); 
    		 double yoymaintenancecost = metrics.getDouble("yoymaintenancecost");
    		 double depreciation = metrics.getDouble("depreciation");
    		 JSONObject rentalcount = metrics.getJSONObject("rentalcount");
    		 int yeartodate = rentalcount.getInt("yeartodate");
    		 double revenue = (price -discount) * yeartodate - depreciation - yoymaintenancecost;
    		 if(revenue > maxCarRevenue  ){
    			 maxCarRevenue = revenue ;   			
    		 }    		 
    	 }
    	 
    	 System.out.println("The car list which produced the highest profit:");
    	 for (int i=0;i < jarray.length(); i++){
    		 JSONObject jsonobject = jarray.getJSONObject(i);
    		 JSONObject carObj = jsonobject.getJSONObject("Car");
    		 JSONObject perdayrent = carObj.getJSONObject("perdayrent");
    		 double price = perdayrent.getDouble("Price");
    		 double discount = perdayrent.getDouble("Discount");
    		 JSONObject metrics = carObj.getJSONObject("metrics"); 
    		 double yoymaintenancecost = metrics.getDouble("yoymaintenancecost");
    		 double depreciation = metrics.getDouble("depreciation");
    		 JSONObject rentalcount = metrics.getJSONObject("rentalcount");
    		 int yeartodate = rentalcount.getInt("yeartodate");
    		 double revenue = (price -discount) * yeartodate - depreciation - yoymaintenancecost;
    		 if(Math.abs(revenue - maxCarRevenue) < THRESHOLD ){
    			 System.out.println(carObj.toString());			
    		 }    		 
    	 }
    	
    }
}
