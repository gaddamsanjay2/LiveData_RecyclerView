package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;



import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SenderFragment extends Fragment {

    private SharedViewModel viewModel;
    EditText ename;



    List<String> dataModelList=new ArrayList<String>();

    public SenderFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_sender, container, false);




        ename=view.findViewById(R.id.edt_send);

        viewModel= ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);



        Button send=view.findViewById(R.id.btn_sender);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enameStr=ename.getText().toString();


                if(TextUtils.isEmpty(enameStr))
                {
                    ename.setError("enter details");
                }

                else
                {
                    dataModelList.add(enameStr);
                    viewModel.setDataModelList(dataModelList);

                    Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();

                }


            }
        });
        return view;

    }



}