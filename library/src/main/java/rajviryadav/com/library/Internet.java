package rajviryadav.com.library;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by Rajvir Yadav on 6/30/2017.
 */
public class Internet
{
    static ConnectivityManager connectivityManager;
    NetworkInfo wifiInfo, mobileInfo;
    static boolean connected = false;

    public static boolean isConnected(Context context)
    {
        try
        {
            connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
            return connected;
        }
        catch (Exception e)
        {
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
        }
        return connected;
    }
}
