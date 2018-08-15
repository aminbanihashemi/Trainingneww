package app.sematech.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WebpageActivity extends AppCompatActivity implements View.OnClickListener {
    WebView webView;
    String uri;
    Button searchWeb;
    EditText addressWeb;
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

    }

    @Override
    public void onClick(View v) {
        String url = addressWeb.getText().toString();

        if (addressWeb.length()==0){
            url = "www.google.com";
        }

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://"+ url);


    }
}
