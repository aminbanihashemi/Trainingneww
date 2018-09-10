package app.sematech.training.DataBase;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import app.sematech.training.R;
import es.dmoral.toasty.Toasty;

public class DataBaseActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name, family;
    Button save,clearData;
    DatabaseHandler db;
    ListView list;
    Context mContext;
    AlertDialog.Builder dialogClearData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        Intent intent = getIntent();
        mContext = this;
        db = new DatabaseHandler(mContext, "sematech.db", null, 1);
        list = (ListView) findViewById(R.id.list);
        name = (EditText) findViewById(R.id.name);
        clearData = (Button) findViewById(R.id.clear_data);
        clearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogClearData = new AlertDialog.Builder(mContext);
                dialogClearData.setTitle("Confirm");
                dialogClearData.setMessage("Are you sure to remove all of your data?");
                dialogClearData.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clearDataBaseMethod();
                        show();
                        dialog.dismiss();
                    }
                });
                dialogClearData.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialogClearData.show();
            }
        });

        family = (EditText) findViewById(R.id.family);
        save = (Button) findViewById(R.id.save);
        show();
        save.setOnClickListener(this);
    }

    private void clearDataBaseMethod() {

        try {
            db.delete();

        } catch (NullPointerException e) {
            // TODO Auto-generated catch block
            Log.d("DATABASE", "ERROR!");
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        if(!name.getText().toString().equals("") && !family.getText().toString().equals("")){
            db.insert(name.getText().toString(), family.getText().toString());
            Toast.makeText(this, "new user has been added", Toast.LENGTH_SHORT).show();
        }else {
            Toasty.error(mContext, "Please Fill all Fields !", Toast.LENGTH_SHORT, true).show();
        }

        name.setText("");
        family.setText("");
        show();
    }

    void show() {

        List<StudentModel> students = db.getStudents();
        StudentsDatabaseAdapter adapter = new StudentsDatabaseAdapter(mContext,students);
        list.setAdapter(adapter);

    }
}
