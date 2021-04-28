package com.ctseducare.ctssystem.ui.system;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ctseducare.ctssystem.R;
import com.ctseducare.ctssystem.util.SystemUtils;

public class SystemFragment extends Fragment {

    private SystemViewModel viewModel;

    public static SystemFragment newInstance() {
        return new SystemFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.system_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView lblAPIVersion = view.findViewById(R.id.lblAPILevel);
        lblAPIVersion.setText(String.format("%d (%s)", SystemUtils.getAPILevel(), SystemUtils.getAPIName()));

        TextView lblVersion = view.findViewById(R.id.lblVersion);
        lblVersion.setText(SystemUtils.getVersion());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(SystemViewModel.class);
        // TODO: Use the ViewModel
    }

}