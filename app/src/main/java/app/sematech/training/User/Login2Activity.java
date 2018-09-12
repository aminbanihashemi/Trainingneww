package app.sematech.training.User;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;
import app.sematech.training.R;
import es.dmoral.toasty.Toasty;

public class Login2Activity extends AppCompatActivity {
    private LoginButton loginButton;

    private CallbackManager callbackManager;
    Context mContext;
    Button signIn;
    private static final String EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login2);

        Intent intent = getIntent();
        String MessagID = intent.getStringExtra("message");
        mContext=this;
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.facebook_login_button);

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                Toasty.success(mContext,"You Logged in Successfully!");
            }

            @Override
            public void onCancel() {
                Toasty.error(mContext,"You Canceled!!!");
            }

            @Override
            public void onError(FacebookException error) {
                Toasty.warning(mContext,"Sorry,You couldn't Log in !!!");
            }
        });

        signIn = (Button) findViewById(R.id.sign_in);
//        signIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
    }
}
