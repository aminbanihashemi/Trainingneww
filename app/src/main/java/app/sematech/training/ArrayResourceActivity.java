package app.sematech.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ArrayResourceActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_resource);
        img = (ImageView) findViewById(R.id.img);
        // روش اول ساخت ارایه
        int[] icons ={
                R.drawable.car1,
                R.drawable.car2,
                R.drawable.car3
        };
        // روش دوم ساخت ارایه
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.car1);
        images.add(R.drawable.car2);
        images.add(R.drawable.car3);

    }
}
