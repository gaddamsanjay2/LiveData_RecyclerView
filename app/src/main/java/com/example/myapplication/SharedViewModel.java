package com.example.myapplication;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends ViewModel {

    String info[];

    List<String> dataModelList=new ArrayList<>();

    MutableLiveData<List<String>> mutableLiveData;

    public SharedViewModel() {
        mutableLiveData = new MutableLiveData<>();

    }

    public MutableLiveData<List<String>> getUserMutableLiveData(){
        return mutableLiveData;

    }




    public void setDataModelList(List<String> dataModelList) {
        info = new String[dataModelList.size()];

        for (int i = 0; i < dataModelList.size(); i++) {
            info[i] = dataModelList.get(i);
            mutableLiveData.setValue(dataModelList);
        }
    }
}