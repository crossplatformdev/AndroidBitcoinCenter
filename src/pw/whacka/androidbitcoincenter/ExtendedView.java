package pw.whacka.androidbitcoincenter;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ExtendedView extends Activity {

	private TextView ask_text_view;
	private TextView bid_text_view;
	private TextView close_text_view;
	private TextView currency_text_view;
	private TextView symbol_text_view;
	private TextView date_text_view;
	private TextView avg_text_view;
	private TextView volume_text_view;
	private TextView currency_volume_text_view;
	private TextView high_text_view;
	private TextView low_text_view;

	private static ArrayList<JSONObject> map = Adapter.getMap();
	//private static LinkedHashMap<String, JSONObject> map = Adapter.getMap();
	static int position;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.extendeditem);

		try {

			avg_text_view = (TextView) findViewById(R.id.e_avg_text_view);
			avg_text_view.setTextColor(Color.BLACK);
			avg_text_view.setText("Avg: " + map.get(position).getString("avg")
					+ "");

			volume_text_view = (TextView) findViewById(R.id.e_volume_text_view);
			volume_text_view.setTextColor(Color.BLACK);
			volume_text_view.setText("Volume: "
					+ map.get(position).getString("volume") + "");

			currency_volume_text_view = (TextView) findViewById(R.id.e_currency_volume_text_view);
			currency_volume_text_view.setTextColor(Color.BLACK);
			currency_volume_text_view.setText("Currency Volume: "
					+ map.get(position).getString("currency_volume") + "");

			high_text_view = (TextView) findViewById(R.id.e_high_text_view);
			high_text_view.setTextColor(Color.BLACK);
			high_text_view.setText("High: "
					+ map.get(position).getString("high") + "");

			low_text_view = (TextView) findViewById(R.id.e_low_text_view);
			low_text_view.setTextColor(Color.BLACK);
			low_text_view.setText("Low: "
					+ map.get(position).getString("low") + "");

			ask_text_view = (TextView) findViewById(R.id.e_ask_text_view);
			ask_text_view.setTextColor(Color.BLACK);
			ask_text_view.setText("Ask: " + map.get(position).getString("ask")
					+ "");

			bid_text_view = (TextView) findViewById(R.id.e_bid_text_view);
			bid_text_view.setTextColor(Color.BLACK);
			bid_text_view.setText("Bid: " + map.get(position).getString("bid")
					+ "");

			close_text_view = (TextView) findViewById(R.id.e_close_text_view);
			close_text_view.setTextColor(Color.BLACK);
			close_text_view.setText("Close: "
					+ map.get(position).getString("close") + "");

			symbol_text_view = (TextView) findViewById(R.id.e_symbol_text_view);
			symbol_text_view.setTextColor(Color.BLACK);
			symbol_text_view.setText("Symbol: "
					+ map.get(position).getString("symbol") + "");

			date_text_view = (TextView) findViewById(R.id.e_latest_trade_text_view);
			date_text_view.setTextColor(Color.BLACK);
			date_text_view.setText("Date: "
					+ new java.util.Date(Long.parseLong(map.get(position).getString("latest_trade"))*1000).toString() + "");

			currency_text_view = (TextView) findViewById(R.id.e_currency_text_view);
			currency_text_view.setTextColor(Color.BLACK);
			currency_text_view.setText("Currency: "
					+ map.get(position).getString("currency") + "");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
