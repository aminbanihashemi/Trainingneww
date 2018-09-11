package app.sematech.training.User;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.facebook.FacebookSdk;

import app.sematech.training.R;

public class Login2Activity extends AppCompatActivity {
    Context mContext;
    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Intent intent = getIntent();
        String MessagID = intent.getStringExtra("message");
        mContext=this;
        FacebookSdk.sdkInitialize(getApplicationContext());


        signIn = (Button) findViewById(R.id.sign_in);
//        signIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


    }
}
