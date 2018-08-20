package app.sematech.training.DataBase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import app.sematech.training.R;

public class DataBaseActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name, family;
    Button save;
    DatabaseHandler db;
    ListView list;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        Intent intent = getIntent();
        mContext = this;
        db = new DatabaseHandler(mContext, "sematech.db", null, 1);
        list = (ListView) findViewById(R.id.list);
        name = (EditText) findViewById(R.id.name);
        family = (EditText) findViewById(R.id.family);
        save = (Button) findViewById(R.id.save);
        show();
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        db.insert(name.getText().toString(), family.getText().toString());
        Toast.makeText(this, "new user has been added", Toast.LENGTH_SHORT).show();
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
