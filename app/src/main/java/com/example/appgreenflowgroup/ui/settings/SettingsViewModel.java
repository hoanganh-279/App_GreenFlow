package com.example.appgreenflowgroup.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    // Text hiển thị tiêu đề
    private final MutableLiveData<String> mText;

    // Trạng thái Dark Mode
    private final MutableLiveData<Boolean> darkModeEnabled = new MutableLiveData<>(false);

    // Trạng thái Notifications
    private final MutableLiveData<Boolean> notificationsEnabled = new MutableLiveData<>(true);

    // Ngôn ngữ được chọn (lưu theo "value" trong arrays.xml: vi, en, ja)
    private final MutableLiveData<String> selectedLanguage = new MutableLiveData<>("vi");

    public SettingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cài đặt ứng dụng");
    }

    public LiveData<String> getText() {
        return mText;
    }

    // Dark Mode
    public LiveData<Boolean> getDarkModeEnabled() {
        return darkModeEnabled;
    }
    public void setDarkModeEnabled(boolean enabled) {
        darkModeEnabled.setValue(enabled);
    }

    // Notifications
    public LiveData<Boolean> getNotificationsEnabled() {
        return notificationsEnabled;
    }
    public void setNotificationsEnabled(boolean enabled) {
        notificationsEnabled.setValue(enabled);
    }

    // Language
    public LiveData<String> getSelectedLanguage() {
        return selectedLanguage;
    }
    public void setSelectedLanguage(String language) {
        selectedLanguage.setValue(language);
    }
}
