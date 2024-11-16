package com.rajviryadav.utility;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rajviryadav.com.library.Internet;
import rajviryadav.com.library.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment
{

    public Dashboard() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View main = inflater.inflate(R.layout.fragment_dashboard, container, false);

        if(Internet.isConnected(getActivity()))
        {
            Toast.abctoast(getActivity(),"Hello....");
        }
        else
        {
            Toast.abctoast(getActivity(),"Internet Connection is required....");
        }
        return main;
    }

}
