package appleTest1;
import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Util {
	public static String getResponse(String testURL) throws IOException {
		URL urlToTest = new URL(testURL);
		String readLine = null;
		HttpURLConnection conn = (HttpURLConnection) urlToTest.openConnection();
		conn.setRequestMethod("GET");
		int responseCode = conn.getResponseCode();
		
		if(responseCode == HttpURLConnection.HTTP_OK){
			BufferedReader br = new BufferedReader(
			   new InputStreamReader(conn.getInputStream()));		  
		    StringBuffer response = new StringBuffer();
		    while ((readLine = br.readLine()) != null){
		    	response.append(readLine);
		    } br.close();
		    return response.toString();
		   
		} else {
			System.out.println("GET Do not Work!!");
			return "";
		}
	}

}
