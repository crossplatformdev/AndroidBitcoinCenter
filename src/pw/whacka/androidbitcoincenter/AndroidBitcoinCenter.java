package pw.whacka.androidbitcoincenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class AndroidBitcoinCenter extends Activity {

	public static MarketStore store = new MarketStoreArray();
	public Context context = this;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_android_bitcoin_center);
	    //WakefulIntentService.scheduleAlarms(new AppListener(), this, false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);

		MenuInflater inflater = getMenuInflater();

		inflater.inflate(R.menu.android_bitcoin_center, menu);

		return true;
		/** true -> el menú ya está visible */

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.menu_update_markets:
			launchUpdateMarkets();
			break;

		case R.id.menu_about:

			launchAbout();
			break;
		case R.id.menu_exit:

			launchExit();
			break;
		case R.id.menu_donate:

			launchDonateBTC();
			break;
		case R.id.menu_settings:

			launchSettings();
			break;
		case R.id.buy_and_sell_bitcoins:

			launchBuynSell();
			break;
		default:
			break;

		}

		return false;
		/** true -> consumimos el item, no se propaga */

	}

	private void launchBuynSell() {
		Intent i = new Intent(this, BrowseWeb.class);
		i.putExtra("url", "https://www.bitstamp.net");
		startActivity(i);
	}

	private void launchUpdateMarkets() {
		
		Intent i = new Intent(this, Markets.class);
		startActivity(i);
	}

	private void launchDonateBTC() {
		Intent i = new Intent(this, DonateBTC.class);
		startActivity(i);
	}

	private void launchSettings() {
		// TODO Auto-generated method stub

	}

	private void launchExit() {
		finish();
	}

	private void launchAbout() {
		Intent i = new Intent(this, About.class);
		startActivity(i);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onPause() {
		super.onPause();
		Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onSaveInstanceState(Bundle estadoGuardado) {
		super.onSaveInstanceState(estadoGuardado);
		// estadoGuardado.putInt("posicion", pos);
	}

	@Override
	protected void onRestoreInstanceState(Bundle estadoGuardado) {
		super.onRestoreInstanceState(estadoGuardado);
		// int pos = estadoGuardado.getInt("posicion");
	}

}
