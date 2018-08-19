package app.sematech.training;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.sematech.training.DataBase.DataBaseActivity;
import app.sematech.training.RecycleView.RecycleActivity;
import app.sematech.training.Weather.WeatherActivity;
import app.sematech.training.map.MapssActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button calculator, formRegister, login, databaseActivity, listView, map;
    Button searchMovie, activityWeather, recycleView, webView, wifiCheck, bluetoothCheck, mobileDataCheck, searchBtn, cancelBtn;
    EditText valueEdittext;
    String destinationClass;
    DrawerLayout drawer;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findViewById(R.id.calculator_activity).setOnClickListener(this);
        findViewById(R.id.form_register_activity).setOnClickListener(this);
        findViewById(R.id.shared_preferences).setOnClickListener(this);
        findViewById(R.id.database_activity).setOnClickListener(this);
        findViewById(R.id.list_view).setOnClickListener(this);
        findViewById(R.id.search_movie).setOnClickListener(this);
        findViewById(R.id.activity_weather).setOnClickListener(this);
        findViewById(R.id.toggle).setOnClickListener(this);
        findViewById(R.id.recycle_view_button).setOnClickListener(this);
        findViewById(R.id.web_view).setOnClickListener(this);
        findViewById(R.id.wifi_check).setOnClickListener(this);
        findViewById(R.id.bluetooth_check).setOnClickListener(this);
        findViewById(R.id.mobile_data_check).setOnClickListener(this);
        findViewById(R.id.map).setOnClickListener(this);


        bind();


    }

    private void bind() {
        calculator = (Button) findViewById(R.id.calculator_activity);
        formRegister = (Button) findViewById(R.id.form_register_activity);
        login = (Button) findViewById(R.id.shared_preferences);
        databaseActivity = (Button) findViewById(R.id.database_activity);
        listView = (Button) findViewById(R.id.list_view);
        searchMovie = (Button) findViewById(R.id.search_movie);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        recycleView = (Button) findViewById(R.id.recycle_view_button);
        activityWeather = (Button) findViewById(R.id.activity_weather);
        webView = (Button) findViewById(R.id.web_view);
        wifiCheck = (Button) findViewById(R.id.wifi_check);
        bluetoothCheck = (Button) findViewById(R.id.bluetooth_check);
        mobileDataCheck = (Button) findViewById(R.id.mobile_data_check);
        map = (Button) findViewById(R.id.map);
        searchBtn = (Button) findViewById(R.id.search_btn);
        cancelBtn = (Button) findViewById(R.id.cancel_btn);
        valueEdittext = (EditText) findViewById(R.id.value_edittext);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.calculator_activity) {
            calculatorActivityMethod();
        } else if (v.getId() == R.id.form_register_activity) {
            formRegisterMethod();
        } else if (v.getId() == R.id.shared_preferences) {
            sharedPreferencesMethod();
        } else if (v.getId() == R.id.database_activity) {
            dataBaseActivityMethod();
        } else if (v.getId() == R.id.list_view) {
            listViewMethod();
        } else if (v.getId() == R.id.search_movie) {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_search);
            dialog.setTitle("Enter Movie :");
            searchBtn = (Button) dialog.findViewById(R.id.search_btn);
            cancelBtn = (Button) dialog.findViewById(R.id.cancel_btn);
            valueEdittext = (EditText) dialog.findViewById(R.id.value_edittext);
            valueEdittext.setHint("E.g. The Godfather, The Dark knight,  Interstellar .... ");
            dialog.setCancelable(true);
            searchBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iMDBMethod(valueEdittext.getText().toString());
                    dialog.dismiss();
                }
            });
            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();

                }
            });


            dialog.show();

        } else if (v.getId() == R.id.toggle) {
            toggleMethod();
        } else if (v.getId() == R.id.activity_weather) {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_search);
            dialog.setTitle("Enter City :");






            searchBtn = (Button) dialog.findViewById(R.id.search_btn);
            cancelBtn = (Button) dialog.findViewById(R.id.cancel_btn);
            valueEdittext = (EditText) dialog.findViewById(R.id.value_edittext);
            valueEdittext.setHint("E.g. New York, London,  Tehran .... ");
            dialog.setCancelable(true);
            searchBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    weatherActivityMethod(valueEdittext.getText().toString());
                    dialog.dismiss();
                }
            });
            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();

                }
            });
            dialog.show();

        } else if (v.getId() == R.id.recycle_view_button) {
            RecycleListActivityMethod();
        } else if (v.getId() == R.id.web_view) {
            WebViewActivityMethod();
        } else if (v.getId() == R.id.wifi_check) {
            wifiIntentMethod();
        } else if (v.getId() == R.id.bluetooth_check) {
            bluetoothIntentMethod();
        } else if (v.getId() == R.id.mobile_data_check) {
            mobileDataIntentMethod();
        } else if (v.getId() == R.id.map) {
            mapMethod();
        }
    }

    private void mapMethod() {
        Intent intent = new Intent(MainActivity.this, MapssActivity.class);
        intent.putExtra("message", "12345");
        startActivity(intent);

    }

    private void mobileDataIntentMethod() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
        startActivity(intent);

    }

    private void bluetoothIntentMethod() {
        startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS));
    }

    private void wifiIntentMethod() {
        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
    }

    private void WebViewActivityMethod() {
        Intent intent = new Intent(MainActivity.this, WebpageActivity.class);
        intent.putExtra("message", "12345");
        startActivity(intent);
    }

    private void RecycleListActivityMethod() {
        Intent intent = new Intent(MainActivity.this, RecycleActivity.class);
        intent.putExtra("message", "12345");
        startActivity(intent);
    }


    private void weatherActivityMethod(String valueIntent) {
        Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
        intent.putExtra("ValueIntent", valueIntent);
        startActivity(intent);
    }

    private void toggleMethod() {
        if (!drawer.isDrawerOpen(Gravity.LEFT))
            drawer.openDrawer(Gravity.LEFT);
    }

    private void calculatorActivityMethod() {
        Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
        intent.putExtra("message", "12345");
        startActivity(intent);
    }

    private void iMDBMethod(String valueIntent) {
        Intent intent = new Intent(MainActivity.this, IMDBActivity.class);
        intent.putExtra("ValueIntent", valueIntent);
        startActivity(intent);
    }


    private void formRegisterMethod() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.putExtra("message", "12346");
        startActivity(intent);
    }

    private void sharedPreferencesMethod() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.putExtra("message", "12346");
        startActivity(intent);
    }

    private void dataBaseActivityMethod() {
        Intent intent = new Intent(MainActivity.this, DataBaseActivity.class);
        intent.putExtra("message", "12345");
        startActivity(intent);
    }

    private void listViewMethod() {
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        intent.putExtra("message", "12346");
        startActivity(intent);
    }

}
