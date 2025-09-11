package com.example.appgreenflowgroup.ui.user;
import android.adservices.customaudience.ScheduleCustomAudienceUpdateRequest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends androidx.lifecycle.ViewModel {
    private final MutableLiveData<List<User>> users = new MutableLiveData<>(new ArrayList<>());

    // lấy danh sách nhân viên
    public LiveData<List<User>> getUsers() {
        return users;
    }

    // thêm nhân viên mới
    public void addUser (String name, String email, String password){
        List<User> currentList = users.getValue();
        if(currentList != null) {
            currentList.add(new User(name, email, password));
            users.setValue(currentList); //thêm LiveData
        }
    }

    // xóa hết danh sách nhân viên (nếu cần đến)!!!
    public void clearUsers() {
        users.setValue(new ArrayList<>());
    }
}
