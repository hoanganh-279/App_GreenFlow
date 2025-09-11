package com.example.appgreenflowgroup.ui.settings;

import com.example.appgreenflowgroup.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appgreenflowgroup.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;
    private SettingsViewModel settingsViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Lấy ViewModel
        settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);

        // Hiển thị tiêu đề Settings
        binding.textSettings.setText(settingsViewModel.getText().getValue());
        settingsViewModel.getText().observe(getViewLifecycleOwner(), binding.textSettings::setText);

        // ---------------- Dark Mode ----------------
        binding.switchDarkMode.setChecked(settingsViewModel.getDarkModeEnabled().getValue());
        binding.switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsViewModel.setDarkModeEnabled(isChecked);
            AppCompatDelegate.setDefaultNightMode(
                    isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
            );
        });

        // ---------------- Notifications ----------------
        binding.switchNotifications.setChecked(settingsViewModel.getNotificationsEnabled().getValue());
        binding.switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsViewModel.setNotificationsEnabled(isChecked);
            Toast.makeText(requireContext(),
                    isChecked ? "Bật thông báo" : "Tắt thông báo",
                    Toast.LENGTH_SHORT).show();
        });

        // ---------------- Language Spinner ----------------
        String[] languageOptions = getResources().getStringArray(R.array.language_options);
        String[] languageValues = getResources().getStringArray(R.array.language_values);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_item, languageOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerLanguage.setAdapter(adapter);

        // Thiết lập vị trí Spinner theo giá trị đã lưu
        String currentLang = settingsViewModel.getSelectedLanguage().getValue();
        int selectedIndex = 0;
        for (int i = 0; i < languageValues.length; i++) {
            if (languageValues[i].equals(currentLang)) {
                selectedIndex = i;
                break;
            }
        }
        binding.spinnerLanguage.setSelection(selectedIndex);

        // Lắng nghe thay đổi Spinner
        binding.spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String langValue = languageValues[position];
                settingsViewModel.setSelectedLanguage(langValue);
                Toast.makeText(requireContext(), "Đã chọn ngôn ngữ: " + languageOptions[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // ---------------- Account Info Click ----------------
        binding.layoutAccountInfo.setOnClickListener(v ->
                Toast.makeText(requireContext(), "Mở màn hình thông tin tài khoản", Toast.LENGTH_SHORT).show()
        );

        // ---------------- About Click ----------------
        binding.layoutAbout.setOnClickListener(v ->
                Toast.makeText(requireContext(), "App GreenFlow v1.0.0\n© 2025", Toast.LENGTH_LONG).show()
        );

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
