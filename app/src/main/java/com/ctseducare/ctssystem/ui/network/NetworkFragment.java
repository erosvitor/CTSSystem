package com.ctseducare.ctssystem.ui.network;

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
import com.ctseducare.ctssystem.util.NetworkUtils;

public class NetworkFragment extends Fragment {

    private NetworkViewModel viewModel;

    public static NetworkFragment newInstance() {
        return new NetworkFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.network_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView lblBluetooth = view.findViewById(R.id.lblBluetooth);
        lblBluetooth.setText(NetworkUtils.bluetoothActive() ? "Active" : "Inactive");

        TextView lblNetworkType = view.findViewById(R.id.lblNetworkType);
        lblNetworkType.setText(NetworkUtils.getNetworkType(getContext()));

        TextView lblWiFi = view.findViewById(R.id.lblWiFi);
        lblWiFi.setText(NetworkUtils.wifiOnAndConnected(getContext()) ? "Active" : "Inactive");

        TextView lblIPv4 = view.findViewById(R.id.lblIPv4);
        if (NetworkUtils.wifiOnAndConnected(getContext())) {
            lblIPv4.setText(NetworkUtils.getIPAddressIPv4());
        } else {
            lblIPv4.setText("No available");
        }

        TextView lblIPv6 = view.findViewById(R.id.lblIPv6);
        if (NetworkUtils.wifiOnAndConnected(getContext())) {
            lblIPv6.setText(NetworkUtils.getIPAddressIPv6());
        } else {
            lblIPv6.setText("No available");
        }

        TextView lblMACAddress = view.findViewById(R.id.lblMAC);
        lblMACAddress.setText(NetworkUtils.getMACAddress("wlan0"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(NetworkViewModel.class);
    }

}