package app.sematech.training;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class IMDBActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    Button search,moreData;
    TextView title, imdbRating, year, genre, plot;

    ImageView image;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imdb);
        Intent intent = getIntent();
        String MessagID = intent.getStringExtra("meesage");
        bind();
    }

    private void bind() {
        name = (EditText) findViewById(R.id.name);
        title = (TextView) findViewById(R.id.title);
        imdbRating = (TextView) findViewById(R.id.imdbRating);
        year = (TextView) findViewById(R.id.year);
        genre = (TextView) findViewById(R.id.genre);
        plot = (TextView) findViewById(R.id.plot);
        moreData = (Button) findViewById(R.id.more_data);
        moreData.setVisibility(View.INVISIBLE);
        image = (ImageView) findViewById(R.id.image);
        search = (Button) findViewById(R.id.search);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("PLS wait to load data from IMDB");
        search.setOnClickListener(this);
        moreData.setOnClickListener(this);
        image.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

            if (v.getId() == R.id.search) {
                getDataFromIMDB(name.getText().toString());
            } else if (v.getId() == R.id.more_data) {
                linkMethod(name.getText().toString());
            }
    }

    private void linkMethod(String s) {
        for (int i=0;i<s.length();i++){
            s = s.replace(" ", "+");
        }
        String url = "https://www.imdb.com/find?ref_=nv_sr_fn&q="+s+"&s=all";
        Intent intent = new Intent(this,WebpageActivity.class);
        intent.putExtra("message",url);
        startActivity(intent);
    }



    private void getDataFromIMDB(String s) {
        progressDialog.show();
        String url = "http://www.omdbapi.com/?t=" + s + "&apikey=70ad462a";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getBaseContext(), throwable.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                parseResponse(responseString);
                moreData.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                progressDialog.dismiss();
            }
        });


    }

    void parseResponse(String serverResponse) {
        try {
            JSONObject allObject = new JSONObject(serverResponse);
            String SRtitle = allObject.getString("Title");
            String SRimdbRating = allObject.getString("imdbRating");
            String SRyear = allObject.getString("Year");
            String SRgenre = allObject.getString("Genre");
            String SRplot = allObject.getString("Plot");
            String SRimage = allObject.getString("Poster");
            //String link =



            Glide.with(this).load(SRimage).into(image);
            title.setText(SRtitle);
            imdbRating.setText("Rate: "+SRimdbRating);
            year.setText("Year: "+SRyear);
            genre.setText("Genre: "+SRgenre);
            plot.setText("Plot: "+SRplot);


        } catch (Exception e) {
            Toast.makeText(this, "The movie not found!", Toast.LENGTH_SHORT).show();
        }
    }
}
