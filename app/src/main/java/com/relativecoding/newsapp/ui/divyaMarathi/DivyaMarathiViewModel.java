package com.relativecoding.newsapp.ui.divyaMarathi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DivyaMarathiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DivyaMarathiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}