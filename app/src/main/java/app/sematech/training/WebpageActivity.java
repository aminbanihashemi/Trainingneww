package app.sematech.training;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WebpageActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    String uri;
    Button searchWeb;
    EditText addressWeb;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpage);
        bind();
        Intent intent = getIntent();
        searchWeb.setOnClickListener(this);

    }

    private void bind() {

        webView = (WebView) findViewById(R.id.web);
        searchWeb = (Button) findViewById(R.id.search_web);
        addressWeb = (EditText) findViewById(R.id.address_web);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Waiting");
        dialog.setMessage("pls Wait to load website");

    }

    @Override
    public void onClick(View v) {

        String url = addressWeb.getText().toString();

        if (addressWeb.getText().toString().length() == 0) {
            url = "www.google.com";
        }

        if (!url.toLowerCase().startsWith("https://") || (!url.toLowerCase().startsWith("http://")))
            url = ("https://" + url);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebClient());
        webView.loadUrl(url);

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
