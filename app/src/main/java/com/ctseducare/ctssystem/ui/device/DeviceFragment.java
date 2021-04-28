package com.ctseducare.ctssystem.ui.device;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.ctseducare.ctssystem.R;
import com.ctseducare.ctssystem.util.DeviceUtils;

public class DeviceFragment extends Fragment {

    private DeviceViewModel viewModel;

    public static DeviceFragment newInstance() {
        return new DeviceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.device_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView lblDevice = view.findViewById(R.id.lblDevice);
        lblDevice.setText(DeviceUtils.getDeviceType(getContext()));

        TextView lblBrand = view.findViewById(R.id.lblBrand);
        lblBrand.setText(DeviceUtils.getBrand());

        TextView lblModel = view.findViewById(R.id.lblModel);
        lblModel.setText(DeviceUtils.getModel());

        TextView lblCPU = view.findViewById(R.id.lblCPU);
        int numberCPUs = DeviceUtils.getNumberCPUs();
        String str = null;
        switch (numberCPUs) {
            case 1:
                str = "One core"; break;
            case 2:
                str = "dual-core"; break;
            case 4:
                str = "quad-core"; break;
            case 8:
                str = "octa-core"; break;
            default:
                str = "unknown"; break;
        }
        lblCPU.setText(str);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(DeviceViewModel.class);
        // TODO: Use the ViewModel
    }
}