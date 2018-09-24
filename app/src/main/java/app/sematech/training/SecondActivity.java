package app.sematech.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import app.sematech.training.Carlist.CarItem;
import app.sematech.training.Weather.ThirdActivity;

public class SecondActivity extends AppCompatActivity {
    List<CarItem> Cars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        CarItem c1 = new CarItem("Bmw","M4","Blue","");
//
//        Intent i = new Intent(this, ThirdActivity.class);
//        i.putExtra("ash", c1);
//        startActivity(i);
//
//        CarItem c2 = new CarItem("Benz","Gclass","Black","");




    }
}
