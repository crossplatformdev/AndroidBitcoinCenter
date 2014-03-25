package pw.whacka.androidbitcoincenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import android.os.AsyncTask;
import android.util.Log;

public class JSONFetcher extends AsyncTask<String, Float, Integer> {

	public JSONArray object = null;
	public boolean lock = false; // T: object acquired F: re-acquire object

	@Override
	protected void onPreExecute() {
		

		
	}

	@Override
	protected synchronized Integer doInBackground(String... urls) {
		/**
		 * Simularemos que descargamos un fichero mediante un sleep
		 */
		String url = urls[0];
		HttpClient httpclient = new DefaultHttpClient();
		// HttpPost("http://codeincloud.tk/json_android_example.php");
		HttpGet httpget = new HttpGet(url);
		
		try {
			if( lock == false){
				HttpResponse response = httpclient.execute(httpget);
				

				
				String jsonResult = inputStreamToString(
						response.getEntity().getContent()).toString();
				object = new JSONArray(jsonResult);

				Log.e("Object : ", "Acquiring...");
				if (object != null) lock = true;
			}
		
			Log.e("Object : ", "Acquired!");
			Log.e("Object : ", object.toString());
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e("Error ", e.toString());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			Log.e("Error ", e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			Log.e("Error ", e.toString());
		}
		
		lock = false;
		return 250;
	}

	private StringBuilder inputStreamToString(InputStream is) {
		String rLine = "";
		StringBuilder answer = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));

		try {
			while ((rLine = rd.readLine()) != null) {
				answer.append(rLine);
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return answer;
	}

}
