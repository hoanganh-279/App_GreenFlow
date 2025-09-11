package com.example.appgreenflowgroup.ui.trash_bins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.appgreenflowgroup.databinding.FragmentTrashBinsBinding;

public class TrashBinsFragment extends Fragment {

    private FragmentTrashBinsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TrashBinsViewModel trashBinsViewModel =
                new ViewModelProvider(this).get(TrashBinsViewModel.class);

        binding = FragmentTrashBinsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTrashBins;
        trashBinsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}