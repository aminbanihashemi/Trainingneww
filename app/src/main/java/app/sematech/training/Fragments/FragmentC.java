package app.sematech.training.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.sematech.training.R;
import app.sematech.training.customView.MyTextView;

public class FragmentC extends Fragment {
    public static FragmentC instance;
    public static FragmentC getInstance(){
        if (instance==null)
            instance = new FragmentC();
        return instance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_c,container,false);
        MyTextView txt = (MyTextView) v.findViewById(R.id.txt);
        txt.append("\n"+System.currentTimeMillis());
        return v;
    }
}
