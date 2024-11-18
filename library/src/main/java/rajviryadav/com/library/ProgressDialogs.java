package rajviryadav.com.library;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogs
{
    static ProgressDialog mProgressDialog;

    public static void show(Context context, String title, String message,Boolean cancelable)
    {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(message);
        mProgressDialog.setCancelable(cancelable);
        if (mProgressDialog != null && !mProgressDialog.isShowing())
        {
            mProgressDialog.show();
        }
    }

    public static void dismiss()
    {
        if (mProgressDialog != null && mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}
