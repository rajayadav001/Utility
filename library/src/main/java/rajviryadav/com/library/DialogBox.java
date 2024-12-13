package rajviryadav.com.library;

import static android.app.PendingIntent.getActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;


public class DialogBox
{
    public static void dialog_without_action(Context context, String msg)
    {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.tab_message);

        TextView text = (TextView) dialog.findViewById(R.id.tab_title);
        Button btn_ok = (Button) dialog.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button) dialog.findViewById(R.id.btncancel);
        Button btn_submit = (Button) dialog.findViewById(R.id.btnsubmit);
        btn_ok.setVisibility(View.VISIBLE);
        btn_cancel.setVisibility(View.GONE);
        btn_submit.setVisibility(View.GONE);
        text.setText(msg);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static void dialog_with_action(Context context, String msg, Activity activity)
    {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.tab_message);

        TextView text = (TextView) dialog.findViewById(R.id.tab_title);
        Button btn_ok = (Button) dialog.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button) dialog.findViewById(R.id.btncancel);
        Button btn_submit = (Button) dialog.findViewById(R.id.btnsubmit);
        btn_ok.setVisibility(View.INVISIBLE);
        btn_cancel.setVisibility(View.VISIBLE);
        btn_submit.setVisibility(View.VISIBLE);

        text.setText(msg);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent ns = new Intent(context, activity.getClass());
                context.startActivity(ns);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static void dialog_with_action(Context context, String msg, Fragment fragment,FragmentManager fragmentManager)
    {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.tab_message);

        TextView text = (TextView) dialog.findViewById(R.id.tab_title);
        Button btn_ok = (Button) dialog.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button) dialog.findViewById(R.id.btncancel);
        Button btn_submit = (Button) dialog.findViewById(R.id.btnsubmit);
        btn_ok.setVisibility(View.INVISIBLE);
        btn_cancel.setVisibility(View.VISIBLE);
        btn_submit.setVisibility(View.VISIBLE);

        text.setText(msg);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Bundle args = new Bundle();
                args.putString("backtype", "");
                fragment.setArguments(args);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content, fragment);
                fragmentTransaction.commit();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    
    public static void dialog_with_action(Context context, String msg, Boolean btnOk,Boolean btnCancel,Boolean btnSubmit,String btnOkName,String btnCancelName,String btnSubmitName, DialogBoxHandler handler)
    {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.tab_message);

        TextView text = (TextView) dialog.findViewById(R.id.tab_title);
        Button btn_ok = (Button) dialog.findViewById(R.id.btn_ok);
        btn_ok.setText(btnOkName);
        Button btn_cancel = (Button) dialog.findViewById(R.id.btncancel);
        btn_cancel.setText(btnCancelName);
        Button btn_submit = (Button) dialog.findViewById(R.id.btnsubmit);
        btn_submit.setText(btnSubmitName);
        if(btnOk)
        {
            btn_ok.setVisibility(View.VISIBLE);
        }
        else
        {
            btn_ok.setVisibility(View.GONE);
        }

        if(btnCancel)
        {
            btn_cancel.setVisibility(View.VISIBLE);
        }
        else
        {
            btn_cancel.setVisibility(View.GONE);
        }

        if(btnSubmit)
        {
            btn_submit.setVisibility(View.VISIBLE);
        }
        else
        {
            btn_submit.setVisibility(View.GONE);
        }

        if(btnOk == true && btnCancel==false && btnSubmit==false)
        {
            btn_ok.setVisibility(View.VISIBLE);
            btn_cancel.setVisibility(View.INVISIBLE);
            btn_submit.setVisibility(View.INVISIBLE);
        }

        text.setText(msg);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                handler.onOk();
                dialog.dismiss();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                handler.onCancel();
                dialog.dismiss();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                handler.onConfirmation();
                dialog.dismiss();
                //check(context, message, handler);
            }
        });
        dialog.show();
    }

}
