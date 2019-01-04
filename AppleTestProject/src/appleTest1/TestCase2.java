package appleTest1;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestCase2 {

    public static void main(String[] args) throws IOException {
    	final double THRESHOLD =0.01;
    	 String urlToTest = "http://someTestUrl";
    	 String response = Util.getResponse(urlToTest);
    	 JSONArray jarray = new JSONArray(response);
    	 
    	 double minPrice = Double.MAX_VALUE;
    	 double minPriceDiscount = Double.MAX_VALUE;
    	 for (int i=0;i < jarray.length(); i++){
    		 JSONObject jsonobject = jarray.getJSONObject(i);
    		 JSONObject carObj = jsonobject.getJSONObject("Car");
    		 JSONObject perdayrent = carObj.getJSONObject("perdayrent");
    		 double price = perdayrent.getDouble("Price");
    		 double discount = perdayrent.getDouble("Discount");
    		 if(minPrice < price ){
    			 minPrice = price;   			
    		 }
    		 if(minPriceDiscount < price - discount){
    			 minPriceDiscount = price - discount;
    		 }
    	 }
    	 System.out.println("The car list with lowest per day rental cost without discount:");
    	 for (int i=0; i< jarray.length();i++){
    		 JSONObject jsonobject = jarray.getJSONObject(i);
    		 JSONObject carObj = jsonobject.getJSONObject("Car");
    		 JSONObject perdayrent = carObj.getJSONObject("perdayrent");
    		 double price = perdayrent.getDouble("Price");
    		 if (Math.abs(price - minPrice) < THRESHOLD){
    			 System.out.println(carObj.toString());
    		 }   		    		 
    	 }
    	 System.out.println("The car list with lowest per day rental cost with discount:");
    	 for (int i=0; i< jarray.length();i++){
    		 JSONObject jsonobject = jarray.getJSONObject(i);
    		 JSONObject carObj = jsonobject.getJSONObject("Car");
    		 JSONObject perdayrent = carObj.getJSONObject("perdayrent");
    		 double price = perdayrent.getDouble("Price");
    		 double discount = perdayrent.getDouble("Discount");
    		 if (Math.abs(minPriceDiscount - (price - discount)) < THRESHOLD){
    			 System.out.println(carObj.toString());
    		 }   		    		 
    	 }
    }
}
