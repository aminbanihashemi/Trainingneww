package app.sematech.training.VideoBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by abanihashemi on 7/24/2018.
 */

public class IncomingCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "incomming caalllll", Toast.LENGTH_LONG).show();
    }
}
