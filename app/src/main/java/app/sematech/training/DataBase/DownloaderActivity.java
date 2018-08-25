package app.sematech.training.DataBase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;

import app.sematech.training.R;
import cz.msebera.android.httpclient.Header;
import es.dmoral.toasty.Toasty;

public class DownloaderActivity extends AppCompatActivity implements View.OnClickListener {
    EditText url;
    Button download;
    ProgressBar downloadPercent;
    TextView percent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloader);
    }
    void bind(){
        url = (EditText) findViewById(R.id.url);
        downloadPercent = (ProgressBar)findViewById(R.id.download_percent);
        percent =  (TextView) findViewById(R.id.percent);
        download= (Button) findViewById(R.id.download);
        download.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        download(url.getText().toString());
    }

    private void download(String url) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                Toast.makeText(DownloaderActivity.this, "Error in downloading file", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                String fileAddres = file.getAbsolutePath(); //Get address of file

            }
        });
    }
}
