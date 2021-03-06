package app.sematech.training.servicePKG;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.sematech.training.R;

public class ServiceStarterActivity extends AppCompatActivity {
    Context mContext;
    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_starter);
        mContext = this;
        txt = (EditText) findViewById(R.id.txt);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(mContext,MyService.class);
                serviceIntent.putExtra("txt",txt.getText().toString());
                startService(serviceIntent);
            }
        });
    }
}
