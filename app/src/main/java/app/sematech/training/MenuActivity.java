package app.sematech.training;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mContext = this;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 100, 1, "Settings");
        menu.add(0, 200, 6, "About App");
        menu.add(0, 300, 3, "Log out");
//        menu.add(0, 2, 6, getResources().getString(R.string.form_title));

        getMenuInflater().inflate(R.menu.my_menu, menu);
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 100) {
            Toast.makeText(mContext, "Clicked on Settings", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == 200) {
            Toast.makeText(mContext, "Clicked on About App", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == 300) {
            Toast.makeText(mContext, "Clicked on ALog out", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.home) {
            Toast.makeText(mContext, "Clicked on Home", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.log_off) {
            Toast.makeText(mContext, "Clicked on Log off", Toast.LENGTH_SHORT).show();
        }
            return super.onOptionsItemSelected(item);

    }
}
