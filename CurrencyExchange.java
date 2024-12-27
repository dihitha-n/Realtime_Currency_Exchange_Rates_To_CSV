import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Link{
	public static final String ACCESS_KEY = "3afda89335dda091e63492a7534798dd";
	public static final String BASE_URL = "https://apilayer.net/api/";
	public static final String ENDPOINT = "live";
	static CloseableHttpClient httpClient = HttpClients.createDefault();
	public static void sendLiveRequest(){		
		HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);		
		try {
			CloseableHttpResponse response =  httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));	
			System.out.println("Live Currency Exchange Rates");
			Date timeStampDate = new Date((long)(exchangeRates.getLong("timestamp")*1000)); 
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
			String formattedDate = dateFormat.format(timeStampDate);
			System.out.println("1 " + exchangeRates.getString("source") + " in GBP : " + exchangeRates.getJSONObject("source").getDouble("USDGBP") + " (Date: " + formattedDate + ")");
			System.out.println("\n");
			response.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException{
		sendLiveRequest();
		httpClient.close();
		new BufferedReader(new InputStreamReader(System.in)).readLine();
	}
}
/*LIB:
httpcore-4.4.1.jar
httpclient-4.4.1.jar
commons-logging-1.2.jar
json.jar

OUTPUT:(SHOULD COME IN THIS FORMAT)
	Live Currency Exchange Rates
	1 USD in GBP : 0.66046 (Date: 2015-05-02 21:26:15 PM)
*/