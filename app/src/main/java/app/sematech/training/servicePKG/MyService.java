package app.sematech.training.servicePKG;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    String TAG="my_service";
    @Override
    public void onCreate() {

        super.onCreate();
//        Toast.makeText(this, "Creaaaaaaate", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        String url = "http://android.programmerguru.com/wp-content/uploads/2013/04/hosannatelugu.mp3";

        MediaPlayer mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try{
            mPlayer.setDataSource(url);
        }catch (Exception e){

        }
        try{

            mPlayer.prepare();
        }catch (Exception e){

        }

        mPlayer.start();





//        Toast.makeText(this, "StartCommaaaand", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, intent.getStringExtra("txt"), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStartCommand: ");
//        stopSelf(); kill the Service
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
