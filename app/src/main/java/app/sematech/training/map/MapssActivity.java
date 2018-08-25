package app.sematech.training.map;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import app.sematech.training.PublicMethod;
import app.sematech.training.R;
import app.sematech.training.Weather.models.Allmodels;
import app.sematech.training.map.cityModels.CityModels;
import app.sematech.training.map.cityModels.Geometry;
import app.sematech.training.map.cityModels.Result;
import cz.msebera.android.httpclient.Header;
import es.dmoral.toasty.Toasty;

public class MapssActivity extends FragmentActivity implements OnMapReadyCallback ,View.OnClickListener{
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    ProgressDialog progressDialog;
    Button searchButtonCity;
    Button searchCity, cancel;
    EditText city;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapss);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        Intent intent = getIntent();
        String MessagID = intent.getStringExtra("meesage");
        bind();
        searchButtonCity.setOnClickListener(this);
        mapFragment.getMapAsync(this);
    }


    private void bind() {

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        searchButtonCity = (Button) findViewById(R.id.search_button_city);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        mMap.setOnCameraIdleListener(this);
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(35.750776, 51.379961);
//        mMap.getUiSettings().setZoomControlsEnabled(true);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

//    @Override
////    public void onCameraIdle() {
////        double lat = mMap.getCameraPosition().target.latitude;
////        double lng = mMap.getCameraPosition().target.longitude;
////        Toast.makeText(this, "lat :\n" + lat + "\nlong :\n" + lng, Toast.LENGTH_SHORT).show();
////
////        //https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(SELECT%20woeid%20FROM%20geo.places%20WHERE%20text%3D%22(111%2C222)%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys
////    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.search_button_city) {
            clickedDialogButton();
        }
    }


    private void clickedDialogButton() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_search);
        dialog.setTitle("Enter Your City :");
        searchCity = (Button) dialog.findViewById(R.id.search_btn);
        cancel = (Button) dialog.findViewById(R.id.cancel_btn);
        city = (EditText) dialog.findViewById(R.id.value_edittext);
        dialog.setCancelable(true);


        searchCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getLocationFromGoogleAPI(city.getText().toString());

                //getWeatherByLatLong(34.6399443,50.8759419);

                dialog.dismiss();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

            }
        });


        dialog.show();

    }

    private void getLocationFromGoogleAPI(String city) {
        try {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setTitle("Loading...");
            progressDialog.setMessage("PLS wait to find your City");
            progressDialog.show();
            String url = ("https://maps.googleapis.com/maps/api/geocode/json?address=" + city);
            AsyncHttpClient client = new AsyncHttpClient();
            client.get(url, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    Toast.makeText(getBaseContext(), throwable.toString(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    parseResponse(responseString);
                }

                @Override
                public void onFinish() {
                    super.onFinish();
                    progressDialog.dismiss();
                }
            });
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
        }


    }

    private void parseResponse(String response) {
        try {
            Gson gson = new Gson();

            CityModels cityModels = gson.fromJson(response, CityModels.class);

            Result result = cityModels.getResults().get(0);

            Geometry geometry = result.getGeometry();
            Double lat = geometry.getLocation().getLat();
            Double longi = geometry.getLocation().getLng();
            setLocationMarker(lat, longi);
            getWeatherByLatLong(lat,longi);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }


    }

    private void setLocationMarker(Double lat, Double longi) {

        mMap.clear();
        LatLng marker = new LatLng(lat, longi);
        mMap.addMarker(new MarkerOptions().position(marker).title(city.getText().toString()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(marker));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 8.0f ) );

    }

    private void getWeatherByLatLong(Double lat, Double longi) {
        String slat=lat.toString();
        String slongi=longi.toString();
        String urlcity = ("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(SELECT%20woeid%20FROM%20geo.places%20WHERE%20text%3D%22("+slat+"%2C"+slongi+")%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(urlcity, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(mContext, throwable+"", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                showDataFromYahoo(responseString);

            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
    }

    private void showDataFromYahoo(String responseString) {
        try {
            Gson gson = new Gson();
            Allmodels eAllmodels = gson.fromJson(responseString, Allmodels.class);
            String temp = eAllmodels.getQuery().getResults().getChannel().getItem().getCondition().getTemp().toString();
            Toasty.Config.getInstance().setTextColor(Color.RED).tintIcon(true).apply();
            Toasty.normal(this, "Temp : " + Math.round(PublicMethod.convertFahrenheittoCelsiusMethod(temp))+" °", R.drawable.ic_if_weather_02_809977).show();
//  Toast.makeText(getBaseContext(), "Temperature : " + Math.round(PublicMethod.convertFahrenheittoCelsiusMethod(temp))+" °", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(mContext, e.getMessage()+"", Toast.LENGTH_SHORT).show();
        }
    }
}
