package rajviryadav.com.library;

import android.content.Context;

public class Toast
{
    public static void abctoast(Context context, String message)
    {
        android.widget.Toast.makeText(context, ""+message, android.widget.Toast.LENGTH_SHORT).show();
    }
}
