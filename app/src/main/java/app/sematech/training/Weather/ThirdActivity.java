package app.sematech.training.Weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import app.sematech.training.Carlist.CarItem;
import app.sematech.training.R;

public class ThirdActivity extends AppCompatActivity {
    TextView name,model,color;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        name = (TextView) findViewById(R.id.third_name);
        model = (TextView)findViewById(R.id.third_model);
        color = (TextView)findViewById(R.id.third_color);
        image = (ImageView)findViewById(R.id.third_image);

        Intent i = getIntent();
        CarItem c6 = (CarItem)i.getSerializableExtra("ash");

        c6.getcName();
        c6.getcColor();
        c6.getcModel();
        c6.getcImage();
        name.setText(c6.getcName());
        model.setText(c6.getcColor());
        color.setText(c6.getcModel());


    }
}
