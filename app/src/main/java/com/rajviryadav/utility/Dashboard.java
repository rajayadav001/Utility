package com.rajviryadav.utility;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.NOTIFICATION_SERVICE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment
{
    ImageView imageView;
    public Dashboard() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View main = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Toolbar toolbar =(Toolbar) ((MainActivity) this.getActivity()).findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome to Dashboard");
        imageView = main.findViewById(R.id.img);
        TextView text = main.findViewById(R.id.text);
        WebView webView = main.findViewById(R.id.webView);
        text.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View view) {
                //Date_Time.select_datetime(getActivity(),text);
                /*DialogBox.dialog_with_action(getActivity(), "hello",true,false,false,"Ok","Cancel","Update", new DialogBoxHandler() {
                    @Override
                    public void onConfirmation() {

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onOk() {

                    }
                });*/

              Intent intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
              startActivityForResult(intent,100);

            }
        });

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


        //Toast.toast_custom(getActivity(),"Hello India India India",R.drawable.ic_menu_camera,R.color.green,R.color.yellow);
        //Toast.toast_custom(getActivity(),"India ininini ininiiinni",R.drawable.ic_menu_gallery,R.color.yellow,1,R.color.green,R.color.blue);
        //Toast.toast_custom(getActivity(),"Hello",1,R.drawable.ic_menu_manage,R.color.black,R.color.white,R.color.white,20);


        return main;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            if(requestCode==100)
            {
//                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//                imageView.setImageBitmap(bitmap);

                imageView.setImageURI(data.getData());
            }
        }
    }
}
