package app.sematech.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity {
    EditText resultShow;
    Button clear,result;
    Button nine,eight,seven,six,five,four,three,two,one,zero;
    Button sub,sum,multi,division,decimal,sign,percent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Intent intent = getIntent();
        String MessagID = intent.getStringExtra("Message");
        resultShow = (EditText) findViewById(R.id.result_show);
        sum = (Button) findViewById(R.id.sum);
        clear = (Button) findViewById(R.id.clear);
        result = (Button) findViewById(R.id.result);
        nine = (Button) findViewById(R.id.nine);
        eight = (Button) findViewById(R.id.eight);
        seven = (Button) findViewById(R.id.seven);
        six = (Button) findViewById(R.id.six);
        five = (Button) findViewById(R.id.five);
        four = (Button) findViewById(R.id.four);
        three = (Button) findViewById(R.id.three);
        two = (Button) findViewById(R.id.two);
        one = (Button) findViewById(R.id.one);
        zero = (Button) findViewById(R.id.zero);
        sub = (Button) findViewById(R.id.sub);
        multi = (Button) findViewById(R.id.multi);
        division = (Button) findViewById(R.id.division);
        decimal = (Button) findViewById(R.id.decimal);
        sign = (Button) findViewById(R.id.sign);
        percent = (Button) findViewById(R.id.percent);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = "1";
                resultShow.setText((x));
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = "2";
                resultShow.setText((x));
            }
        });
    }
}
