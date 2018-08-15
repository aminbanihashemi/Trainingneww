package app.sematech.training;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ArraysResourceActivity extends AppCompatActivity {
    ImageView image;
    List<Integer> images;
    int position = 0;
    boolean backClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrays_resource);
        image = (ImageView) findViewById(R.id.img);

        int imgAddress = R.drawable.car1;

        int[] icons = {
                R.drawable.car1, R.drawable.car2, R.drawable.car3
        };

        images = new ArrayList<>();
        images.add(R.drawable.car1);
        images.add(R.drawable.car2);
        images.add(R.drawable.car3);

        setImage();
    }

    void setImage() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (position<images.size()) {
                    Picasso.get().load(images.get(position)).into(image);
                    setImage();
                    position++;
                }
            }
        }, 3000);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (backClicked){
            finish();
        }else{
            backClicked = true;
            Toast.makeText(this, "Cheraa raftiiii", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    backClicked=false;
                }
            },3000);
        }


    }
}

