package app.sematech.training;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.opengl.Visibility;
import android.provider.Settings;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.sematech.training.DataBase.DataBaseActivity;
import app.sematech.training.RecycleView.RecycleActivity;
import app.sematech.training.User.LoginActivity;
import app.sematech.training.Weather.WeatherActivity;
import app.sematech.training.map.MapssActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button calculator, downloaderRegister, login, databaseActivity, listView, map, setting, searchBtnMain;
    Button searchMovie, activityWeather, recycleView, webView, wifiCheck, bluetoothCheck, mobileDataCheck, searchBtn, cancelBtn;
    EditText valueEdittext, searchBar;
    String destinationClass;
    DrawerLayout drawer;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findViewById(R.id.calculator_activity).setOnClickListener(this);
        findViewById(R.id.downloader_activity).setOnClickListener(this);
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
        findViewById(R.id.search_btn_main).setOnClickListener(this);

//        findViewById(R.id.setting).setOnClickListener(this);
        bind();


    }

    private void bind() {
        calculator = (Button) findViewById(R.id.calculator_activity);
        downloaderRegister = (Button) findViewById(R.id.downloader_activity);
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
        searchBar = (EditText) findViewById(R.id.search_bar);
        searchBar.setVisibility(View.INVISIBLE);
        map = (Button) findViewById(R.id.map);
        searchBtn = (Button) findViewById(R.id.search_btn_dialog);
        searchBtnMain = (Button) findViewById(R.id.search_btn_main);
        cancelBtn = (Button) findViewById(R.id.cancel_btn_dialog);
        valueEdittext = (EditText) findViewById(R.id.value_edittext);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, 100, 1, "Settings");
        menu.add(0, 200, 6, "About App");
        menu.add(0, 300, 3, "Log out");
//        menu.add(0, 2, 6, getResources().getString(R.string.form_title));
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 100) {
            Toast.makeText(mContext, "Clicked on Settings", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == 200) {
            Toast.makeText(mContext, "Clicked on About App", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == 300) {
            Toast.makeText(mContext, "Clicked on ALog out", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.calculator_activity) {
            calculatorActivityMethod();
        } else if (v.getId() == R.id.downloader_activity) {
            downloaderActivityMethod();
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
            searchBtn = (Button) dialog.findViewById(R.id.search_btn_dialog);
            cancelBtn = (Button) dialog.findViewById(R.id.cancel_btn_dialog);
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
            searchBtn = (Button) dialog.findViewById(R.id.search_btn_dialog);
            cancelBtn = (Button) dialog.findViewById(R.id.cancel_btn_dialog);
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
        } else if (v.getId() == R.id.search_btn_main) {
            searchBar.setVisibility(View.VISIBLE);
            searchBtnMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!searchBar.equals("")) {
                        searchMainMethod(searchBar.getText().toString());
                    } else {
                        searchBar.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
// else if (v.getId() == R.id.setting) {
//
//        }
    }

    private void searchMainMethod(String s) {
        Toast.makeText(mContext, "Searching the entered word", Toast.LENGTH_SHORT).show();
    }

    private void downloaderActivityMethod() {
        Intent intent = new Intent(MainActivity.this, DownloaderActivity.class);
        intent.putExtra("message", "12345");
        startActivity(intent);

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
