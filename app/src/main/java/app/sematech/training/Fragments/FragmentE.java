package app.sematech.training.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.sematech.training.R;
import app.sematech.training.customView.MyTextView;

public class FragmentE extends Fragment {
    public static FragmentE instance;
    public static FragmentE getInstance(){
        if (instance==null)
            instance = new FragmentE();
        return instance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_e,container,false);
        MyTextView txt = (MyTextView) v.findViewById(R.id.txt);
        txt.append("\n"+System.currentTimeMillis());
        return v;
    }
}
