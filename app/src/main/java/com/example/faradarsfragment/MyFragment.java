package com.example.faradarsfragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment  extends Fragment {

    EditText inputEmail;
    Button btnSubmit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_my, container, false);
        inputEmail=(EditText)rootView.findViewById(R.id.input_email);
        btnSubmit=(Button)rootView.findViewById(R.id.btn_submit);
        btnSubmit.setEnabled(false);
        inputEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email= s.toString().trim();
                if(email.isEmpty() || !email.contains("@") || !email.contains(".") ||
                        email.lastIndexOf('@')>email.lastIndexOf('.') ||
                        email.lastIndexOf('.')==email.length()-1 ||
                        email.split("@").length!=2 || email.indexOf('@')==0){

                     btnSubmit.setEnabled(false);
                }else {
                    btnSubmit.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                Toast.makeText(getContext(), "email \n"+email,Toast.LENGTH_SHORT).show();
                //your code

            }
        });

        return rootView;
    }
}
