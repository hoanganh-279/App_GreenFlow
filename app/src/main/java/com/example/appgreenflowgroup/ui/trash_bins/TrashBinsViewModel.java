package com.example.appgreenflowgroup.ui.trash_bins;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrashBinsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TrashBinsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is trush_bins fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
