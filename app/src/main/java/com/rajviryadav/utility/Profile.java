package com.rajviryadav.utility;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import rajviryadav.com.library.DialogBox;
import rajviryadav.com.library.Internet;
import rajviryadav.com.library.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment
{

    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View main = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Toolbar toolbar =(Toolbar) ((MainActivity) this.getActivity()).findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome to Profile");
        if(Internet.isConnected(getActivity()))
        {
            Toast.abctoast(getActivity(),"Profile....");
        }
        else
        {
            Toast.abctoast(getActivity(),"Internet Connection is required....");
        }

        //DialogBox.dialog_with_action(getActivity(),"Hello");
        return main;
    }
}
