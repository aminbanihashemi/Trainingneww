package app.sematech.training.RecycleView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.sematech.training.Carlist.CarItem;
import app.sematech.training.R;

public class RecycleActivity extends AppCompatActivity {
    RecyclerView recycler;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        Intent intent = getIntent();
        String MessagID = intent.getStringExtra("meesage");
        recycler = (RecyclerView) findViewById(R.id.recycler_view);
        CarItem c1 = new CarItem("Bmw","M4","Blue","");

        CarItem c2 = new CarItem("Benz","Gclass","Black","");


        List<CarItem> cars = new ArrayList<>();
        cars.add(c1);
        cars.add(c2);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(mContext , cars);
        recycler.setAdapter(adapter);

    }
}
