package com.example.faradarsfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class FragmentStudentDetails extends DialogFragment {

    TextView tvStdId, tvStdName, tvStdScore;

    public static FragmentStudentDetails newInstance(String id, String name, int score){
        FragmentStudentDetails fragment=new FragmentStudentDetails();
        Bundle args=new Bundle();
        args.putInt("score", score);
        args.putString("name" , name);
        args.putString("id", id);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_student_details,container,false);
        tvStdId=(TextView)rootView.findViewById(R.id.tv_student_id);
        tvStdName=(TextView)rootView.findViewById(R.id.tv_student_name);
        tvStdScore=(TextView)rootView.findViewById(R.id.tv_student_score);

        tvStdId.setText(getArguments().getString("id"));
        tvStdName.setText(getArguments().getString("name"));
        tvStdScore.setText(String.valueOf(getArguments().getInt("score")));

        return rootView;
    }
}
