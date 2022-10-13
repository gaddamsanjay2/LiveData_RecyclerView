package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.gesture.GestureOverlayView;
import android.hardware.lights.LightState;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class RecieverFragment extends Fragment {

    RecyclerView recyclerView;

    UserAdapter userAdapter;
    List<String> dataModelList = new ArrayList<>();


    public RecieverFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reciever, container, false);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


        final SharedViewModel viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);



        viewModel.getUserMutableLiveData().observe(getActivity(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {

                userAdapter = new UserAdapter(getActivity(), strings);
                recyclerView.setAdapter(userAdapter);


            }
        });


        viewModel.getUserMutableLiveData().observe(getActivity(), new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                viewModel.getUserMutableLiveData();



            }
        });


        return view;

    }

}

