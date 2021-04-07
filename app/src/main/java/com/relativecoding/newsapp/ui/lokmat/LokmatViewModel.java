package com.relativecoding.newsapp.ui.lokmat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LokmatViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LokmatViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}