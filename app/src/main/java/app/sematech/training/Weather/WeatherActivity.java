package app.sematech.training.Weather;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.List;

import app.sematech.training.PublicMethod;
import app.sematech.training.R;
import app.sematech.training.Weather.models.Allmodels;
import app.sematech.training.Weather.models.Forecast;
import cz.msebera.android.httpclient.Header;

public class WeatherActivity extends AppCompatActivity implements View.OnClickListener {
    EditText city;
    ImageButton search;
    TextView cityToday,tempToday,dateToday,highToday,lowToday,textToday;
    Context mContext;
    ListView list_days;
    ImageView imageToday,arrowUp,arrowDown;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Intent intent = getIntent();
        String MessagID = intent.getStringExtra("meesage");
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("PLS wait to load data from Weather Source");
        mContext = this;
        bind();
    }

    private void bind() {
        city = (EditText) findViewById(R.id.city);
        search = (ImageButton) findViewById(R.id.search);
        cityToday = (TextView)findViewById(R.id.city_today);
        tempToday = (TextView)findViewById(R.id.temp_today);

        textToday = (TextView)findViewById(R.id.text_today);
        highToday = (TextView)findViewById(R.id.high_today);
        lowToday = (TextView)findViewById(R.id.low_today);
        imageToday = (ImageView) findViewById(R.id.image_today);
        arrowUp = (ImageView) findViewById(R.id.arrow_up);
        arrowDown = (ImageView) findViewById(R.id.arrow_down);

        search.setOnClickListener(this);
        list_days=(ListView)findViewById(R.id.list_days);
    }

    @Override
    public void onClick(View v) {

        getDataFromYahoo(city.getText().toString());
    }

    private void getDataFromYahoo(String cityName) {
        progressDialog.show();
        String url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22"+cityName+"%2C%20ir%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(mContext, throwable+"", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                showData(responseString);

            }

            @Override
            public void onFinish() {
                super.onFinish();
                progressDialog.dismiss();
            }
        });
    }
    void showData(String response){

        String code;
        Gson gson = new Gson();
        Allmodels eAllmodels = gson.fromJson(response,Allmodels.class);
        String temp = eAllmodels.getQuery().getResults().getChannel().getItem().getCondition().getTemp();
        String city = eAllmodels.getQuery().getResults().getChannel().getLocation().getCity();
        String country = eAllmodels.getQuery().getResults().getChannel().getLocation().getCountry();
        List<Forecast>  forecastsList = eAllmodels.getQuery().getResults().getChannel().getItem().getForecast();

        Forecast today = forecastsList.get(0);
        Picasso.get().load(R.drawable.arrows_up).into(arrowUp);
        highToday.setText(Math.round(PublicMethod.convertFahrenheittoCelsiusMethod(today.getHigh()))+""+" °");
        Picasso.get().load(R.drawable.arrows_down).into(arrowDown);
        lowToday.setText(Math.round(PublicMethod.convertFahrenheittoCelsiusMethod(today.getLow()))+""+" °");
        tempToday.setText(Math.round((PublicMethod.convertFahrenheittoCelsiusMethod(temp)))+""+"°");
        cityToday.setText(city+", "+country);
        textToday.setText(today.getText());

        code = today.getCode();
        PublicMethod.switchClassMethod(code,imageToday);



        ForecastsListAdapter adapter = new ForecastsListAdapter(mContext,forecastsList);
        list_days.setAdapter(adapter);

// try{
//            JSONObject Allobject=new JSONObject(response);
//
//        }catch (Exception e){
//
//        }
    }



}
