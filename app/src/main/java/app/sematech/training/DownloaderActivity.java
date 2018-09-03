package app.sematech.training;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class DownloaderActivity extends AppCompatActivity implements View.OnClickListener {
    EditText url;
    Button download;
    ProgressBar downloadPercent;
    TextView percent,resultDownloader;
    Context mContext;
    VideoView test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloader);
        Intent intent = getIntent();
        String MessagID = intent.getStringExtra("Message");
        mContext = this;
        bind();
    }

    void bind() {
        url = (EditText) findViewById(R.id.url);
        downloadPercent = (ProgressBar) findViewById(R.id.download_percent);
        percent = (TextView) findViewById(R.id.percent);
        resultDownloader = (TextView) findViewById(R.id.result_downloader);
        test = (VideoView) findViewById(R.id.test);
        download = (Button) findViewById(R.id.download);
        download.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (url.getText().toString().equals("")){
            url.setError("Please enter url");
        }else download(url.getText().toString());
    }

    private void download(final String urlValue) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(urlValue, new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);
                int percentage = (int) (bytesWritten * 100.0/totalSize + 0.5);// convert byte written to percentage.
                downloadPercent.setProgress(percentage);
                percent.setText(percentage+"%");

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                Toast.makeText(DownloaderActivity.this, "Error in downloading file", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                String fileAddress = file.getAbsolutePath(); //Get address of file
                File newFile = new File("/sdcard/myfiles/video.mp4");
                file.renameTo(newFile);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String currentDateAndTime = sdf.format(new Date());
                DownloadModel dl = new DownloadModel();
                dl.setDate(currentDateAndTime);
                dl.setDownloadedAddress(fileAddress);
                dl.setUrl(urlValue);
                dl.save();
                url.setText("");
                Toast.makeText(DownloaderActivity.this, "File has been downloaded", Toast.LENGTH_SHORT).show();
                List<DownloadModel> downloads= DownloadModel.listAll(DownloadModel.class);
                test.setVideoURI(Uri.parse(fileAddress.toString()));
                test.start();
//                for (DownloadModel thisfile:downloads) {
//                    resultDownloader.append(thisfile.getDate()+" "+thisfile.getDownloadedAddress()+"\n");
//                }
            }
        });
    }
}
