/**
 * 
 */
package pw.whacka.androidbitcoincenter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Markets extends ListActivity {

	private JSONFetcher jsf;
	private Context context = this;

	// private ArrayList<HashMap<String, String>> marketList;
	// private HashMap<String, String> element;
	private ArrayList<JSONObject> elementsMap;
	//private LinkedHashMap<String, JSONObject> elementsMap;
	private Adapter adp;

	public ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.markets);

		dialog = new ProgressDialog(this);
		
		dialog.setProgress(0);
		dialog.setMax(255);
		dialog.setMessage("Descargando...");
        dialog.setTitle("Progreso");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCancelable(false);
        dialog.show(); // Mostramos el diálogo antes de comenzar
		
        
		// marketList = new ArrayList<HashMap<String, String>>();
		// element = new HashMap<String, String>();
		elementsMap = new ArrayList<JSONObject>();
        //elementsMap = new LinkedHashMap<String, JSONObject>();

		Toast.makeText(this, "Updating Markets!", Toast.LENGTH_LONG).show();
		// Toast.makeText(this, "JSON ===> " + jsf.object.toString(),
		// Toast.LENGTH_LONG).show();
		// Realizamos cualquier otra operación necesaria
		// Creamos una nueva instancia y llamamos al método ejecutar
		// pasándole el string.
		jsf = new JSONFetcher();
		jsf.execute("http://api.bitcoincharts.com/v1/markets.json");

		initList();

		adp = new Adapter(this, elementsMap);
		ListView listView = (ListView) findViewById(android.R.id.list);

		listView.setAdapter(adp);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				//final JSONObject item = (JSONObject) parent
				//		.getItemAtPosition(position);
				
				//view.animate().setDuration(2000).alpha(0)
				//		.withEndAction(new Runnable() {
				//			@Override
				//			public void run() {
								// elementsMap.remove(item);
				//				adp.notifyDataSetChanged();
				//				view.setAlpha(1);

				//			}
				//		});
			}
		});

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ExtendedView.position = position;
				Intent i = new Intent(context, ExtendedView.class);
				startActivity(i);
			}
		});
		dialog.dismiss();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.android_bitcoin_center, menu);
		return true;
	}

	private synchronized void initList() {

		try {

			while (jsf.lock == false) {
				Thread.sleep(100);
			}

			JSONArray jsonMainNode = jsf.object;

			for (int i = 0; i < jsonMainNode.length(); i++) {
				JSONObject object = jsonMainNode.getJSONObject(i);
				createElement(object);
				Log.i("JSON Object: ", object.toString());
			}
		} catch (JSONException e) {
			Toast.makeText(getApplicationContext(), "Error" + e.toString(),
					Toast.LENGTH_LONG).show();
			Log.e("JSON ERROR: ", e.toString());
			Log.e("JSON ARRAY: ", jsf.object.toString());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("Error : ", "Timeout");
		}
		// notify();
		
	}

	private void createElement(JSONObject object) {
		elementsMap.add(object);
		dialog.setProgress(elementsMap.size());
		// return elementsMap;
	}

}
