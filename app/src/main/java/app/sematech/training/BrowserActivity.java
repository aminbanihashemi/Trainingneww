package app.sematech.training;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowserActivity extends AppCompatActivity {

    WebView webViewBrowser;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        Intent intent = getIntent();
        String url = intent.getStringExtra("UrlIntent");
        bind();
        webViewBrowser.getSettings().setJavaScriptEnabled(true);
        webViewBrowser.setWebViewClient(new MyWebClient());
        webViewBrowser.loadUrl(url);


    }

    private void bind() {
        webViewBrowser = (WebView) findViewById(R.id.web_browser_activity);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Waiting");
        dialog.setMessage("pls Wait to load website");
    }
    class MyWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            dialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            dialog.dismiss();
        }
    }
}
