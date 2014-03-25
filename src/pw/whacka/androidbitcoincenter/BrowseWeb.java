package pw.whacka.androidbitcoincenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowseWeb extends Activity {

	// Nuestra vista necesaria para la web
	private WebView mWebView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_layout);

		// asociamos
		mWebView = (WebView) findViewById(R.id.webview);
		mWebView.setWebViewClient(new WebViewClient());
		//WebSettings webSettings = myWebView.getSettings();
		//webSettings.setJavaScriptEnabled(true);
		
		String url = getIntent().getExtras().getString("url");

		// cargo un .html que he situado en la carpeta asset/ del proyecto
		mWebView.loadUrl(url);
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    // Check if the key event was the Back button and if there's history
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
	        mWebView.goBack();
	        return true;
	    }
	    // If it wasn't the Back key or there's no web page history, bubble up to the default
	    // system behavior (probably exit the activity)
	    return super.onKeyDown(keyCode, event);
	}

}
