package app.sematech.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        intentActivityMethod();
        String url="http://www.google.com";
        showWebPages(url);


    }

    private void showWebPages(String url) {
        WebView webView = (WebView) findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    private void intentActivityMethod() {
        Intent intent = getIntent();
        String MessagID = intent.getStringExtra("meesage");
    }
}
