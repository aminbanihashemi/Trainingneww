package app.sematech.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    EditText resultShow;
    Button clear, result;
    Button nine, eight, seven, six, five, four, three, two, one, zero;
    Button sub, sum, multi, division, decimal, sign, percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Intent intent = getIntent();
        String MessagID = intent.getStringExtra("Message");
        bind();

    }

    private void bind() {
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
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        decimal.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.one:
                resultShow.append("1");
                break;
            case R.id.two:
                resultShow.append("2");
                break;
            case R.id.three:
                resultShow.append("3");
                break;
            case R.id.four:
                resultShow.append("4");
                break;
            case R.id.five:
                resultShow.append("5");
                break;
            case R.id.six:
                resultShow.append("6");
                break;
            case R.id.seven:
                resultShow.append("7");
                break;
            case R.id.eight:
                resultShow.append("8");
                break;
            case R.id.nine:
                resultShow.append("9");
                break;
            case R.id.zero:
                resultShow.append("0");
                break;
            case R.id.decimal:
                resultShow.append(".");
                break;
            case R.id.clear:
                resultShow.setText("");
                break;

        }
    }
}
