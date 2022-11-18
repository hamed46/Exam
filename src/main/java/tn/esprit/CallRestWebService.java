package tn.esprit;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * @author Walid-YAICH
 * URL utiles :
 * http://theoryapp.com/parse-json-in-java/
 * https://jsonformatter.curiousconcept.com/
 */

public class CallRestWebService {

	
	public static final String endpoint = "http://ip-api.com/json";
	//public static final String endpoint = "https://httpbin.org/get";
	public static void main(String[] args) {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		String ip = "not found";
		System.out.println("Hello");
		try {
			HttpResponse response = client.execute(request);
			String jsonResponse = EntityUtils.toString(response.getEntity());
			System.out.println("Response as String : " + jsonResponse);

			//ip = responseObj.getString("origin");
			System.out.println("ip : " + ip); 

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestExemple() {
		System.out.println("This is a Test");
	}
}
 
