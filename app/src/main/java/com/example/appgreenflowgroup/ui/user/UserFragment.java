package com.example.appgreenflowgroup.ui.user;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appgreenflowgroup.R;
public class UserFragment extends Fragment {

    private UserViewModel userViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceStare) {
        View root = inflater.inflate(R.layout.fragment_user, container, false);
        LinearLayout containerLayout = root.findViewById(R.id.userContainer);

        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        userViewModel.addUser("Nguyễn Văn A", "nguyenvana@gmail.com", "12345");
        userViewModel.addUser("Nguyen Thi B", "nguyenthib@gmail.com", "12345");
        userViewModel.addUser("Nguyễn Hoàng C", "nguyenhoangc@gmail.com", "12345");

        userViewModel.getUsers().observe(getViewLifecycleOwner(), userList -> {
            containerLayout.removeAllViews();
            for(User user : userList) {
                TextView tv = new TextView(getContext());
                tv.setText(user.getName() + " - " + user.getEmail() );
                containerLayout.addView(tv);
            }
        });
        return root;
    }
}
