package app.sematech.training.DataBase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.sematech.training.R;

public class StudentsDatabaseAdapter extends BaseAdapter {
    Context mContext;
    List<StudentModel> students;

    public StudentsDatabaseAdapter(Context mContext, List<StudentModel> students) {
        this.mContext = mContext;
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.students_database_item,viewGroup,false);
        TextView name = (TextView)v.findViewById(R.id.name);
        TextView family = (TextView)v.findViewById(R.id.family);

        name.setText(students.get(i).getName());
        family.setText(students.get(i).getFamily());

        return v;
    }
}
