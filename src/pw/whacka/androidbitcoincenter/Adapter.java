package pw.whacka.androidbitcoincenter;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class Adapter extends BaseAdapter {

	private Activity act;
	//private List<HashMap<String, String>> map;
	static ArrayList<JSONObject> map;
	//private static LinkedHashMap<String, JSONObject> map;

	private TextView ask_text_view;
	private TextView bid_text_view;
	private TextView close_text_view;
	private TextView currency_text_view;
	private TextView symbol_text_view;
	private TextView date_text_view;
	
	public Adapter (Activity act, ArrayList<JSONObject> map) {
		super();
		this.act = act;
		Adapter.map = map;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = act.getLayoutInflater();
		View view = inflater.inflate(R.layout.list_element, null, false);
		
		//Iterator<JSONObject> valuesIterator = getMap().values().iterator();
		

		try {
		//	while ( valuesIterator.hasNext() ){		
				ask_text_view = (TextView) view.findViewById(R.id.ask_text_view);
				ask_text_view.setTextColor(Color.BLACK);
				ask_text_view.setText("Ask: " + map.get(position).getString("ask") + "");
		
				bid_text_view = (TextView) view.findViewById(R.id.bid_text_view);
				bid_text_view.setTextColor(Color.BLACK);
				bid_text_view.setText("Bid: " + map.get(position).getString("bid") + "");
				
				close_text_view = (TextView) view.findViewById(R.id.close_text_view);
				close_text_view.setTextColor(Color.BLACK);
				close_text_view.setText("Close: " + map.get(position).getString("close") +  "");
				
				symbol_text_view = (TextView) view.findViewById(R.id.symbol_text_view);
				symbol_text_view.setTextColor(Color.BLACK);
				symbol_text_view.setText("Symbol: " + map.get(position).getString("symbol") + "");
								
				date_text_view = (TextView) view.findViewById(R.id.date_text_view);
				date_text_view.setTextColor(Color.BLACK);
				date_text_view.setText("Date: " + new java.util.Date(Long.parseLong(map.get(position).getString("latest_trade"))*1000) + "");
				
				currency_text_view = (TextView) view.findViewById(R.id.currency_text_view);
				currency_text_view.setTextColor(Color.BLACK);
				currency_text_view.setText("Currency: " + map.get(position).getString("currency") + "");
			//}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
		return view;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return map.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return map.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return map.get(position).hashCode();
	}
	public static ArrayList<JSONObject> getMap() {
		return map;
	}
	public static void setMap(ArrayList<JSONObject> map) {
		Adapter.map = map;
	}	
}
