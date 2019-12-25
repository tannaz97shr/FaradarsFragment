package com.example.faradarsfragment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentStudentList.CallBacks {


    FragmentStudentList fragmentStudentList;
    boolean isTwoPane=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentStudentList=new FragmentStudentList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.listfragment_container,fragmentStudentList)
                .commit();
        isTwoPane=(findViewById(R.id.detailsfragment_container)!=null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("dimensions").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                showDimensions();
                return false;
            }
        });
        menu.add("Settings").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent=new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void showDimensions(){
        ScreenUtility utility=new ScreenUtility(this);
        String msg="width = "+utility.getDpWidth()+", \n height = "+utility.getDpHeight();
        new AlertDialog.Builder(this)
                .setTitle("Dimensions")
                .setMessage(msg)
                .show();
    }

    @Override
    public void onItemSelected(Student student) {
       // Toast.makeText(this, "is two dorost mibashad", Toast.LENGTH_LONG).show();
        FragmentStudentDetails detailsFragment = FragmentStudentDetails.newInstance(
                student.id, student.name, student.score);

        if (isTwoPane){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detailsfragment_container,detailsFragment)
                .commit();
        }else {
            /*Intent intent= new Intent(this,StudentDetailActivity.class)
                    .putExtra("student", student);
            startActivity(intent);*/
            detailsFragment.show(getSupportFragmentManager(),"student_details");
        }
    }
}
