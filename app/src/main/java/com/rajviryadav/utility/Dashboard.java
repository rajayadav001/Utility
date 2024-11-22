package com.rajviryadav.utility;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

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
        Toolbar toolbar =(Toolbar) ((MainActivity) this.getActivity()).findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome to Dashboard");
        TextView text = main.findViewById(R.id.text);
        WebView webView = main.findViewById(R.id.webView);
        /*if(Internet.isConnected(getActivity()))
        {
            Toast.abctoast(getActivity(),"Hello....");
        }
        else
        {
            Toast.abctoast(getActivity(),"Internet Connection is required....");
        }

        SessionManager.putString(getActivity(),"data","realdata");

        DialogBox.dialog_with_action(getActivity(), "Hello", new DialogBoxHandler()
        {
            @Override
            public void onConfirmation()
            {
                final String abc = "";
                TextView textView = new TextView(getActivity());
                //Toast.abctoast(getActivity(),"Confirmation Button Click"+SessionManager.getString(getActivity(),"data",""));
                Date_Time.select_datetime(getActivity(),text);
                Toast.abctoast(getActivity(),Date_Time.current_time());
            }

            @Override
            public void onDecline()
            {
                Toast.abctoast(getActivity(),"Decline Button Click");
            }
        });


        Permissions.check(getActivity(), Manifest.permission.INTERNET, null, new PermissionHandler() {
            @Override
            public void onGranted()
            {

            }
        });*/

        //WebPage.startWebView(getActivity(),"https://www.google.com/",webView,"Please wait","Loading report.....");

        //text.setText(""+RandomNumber.generate_random(10,20));
        //ProgressDialogs.show(getActivity(),"","Message",true);
        //text.setText(Convert.change_date_format("10/12/2024","dd/MM/yyyy","yyyy-MM-dd'T'HH:mm:ss"));
        //ProgressDialogs.dismiss();

//        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
//        DialogBox.dialog_with_action(getActivity(),"Hello", new Profile(),fragmentManager);



        return main;
    }
}
