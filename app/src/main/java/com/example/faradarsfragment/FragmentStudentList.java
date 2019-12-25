package com.example.faradarsfragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import java.util.List;

public class FragmentStudentList extends ListFragment {
    List<Student> students;
    private CallBacks activity;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=(CallBacks)getActivity();

        students=Student.sampleStudent();
        ArrayAdapter<Student> adapter=new ArrayAdapter(
                getContext(), android.R.layout.simple_list_item_1,students);
        setListAdapter(adapter);
    }
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_student_list,container,false);
    }

    @Override
    public void onListItemClick( ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Student student=students.get(position);
        activity.onItemSelected(student);
    }

    public interface CallBacks{
        public void onItemSelected(Student student);
    }


}
