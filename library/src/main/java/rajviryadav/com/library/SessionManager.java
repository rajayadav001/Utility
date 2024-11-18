package rajviryadav.com.library;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Context;

public class SessionManager
{
    private static SharedPreferences mSharedPref;

    public static String getString(Context context,String key, String defValue)
    {
        if(mSharedPref == null)
        {
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        }
        return mSharedPref.getString(key, defValue);
    }

    public static void putString(Context context,String key, String value)
    {
        if(mSharedPref == null)
        {
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        }
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    /*public static Integer getInteger(String key, int defValue)
    {
        return mSharedPref.getInt(key, defValue);
    }

    public static void putInteger(String key, Integer value)
    {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.apply();
    }


    public static boolean getBoolean(String key, boolean defValue)
    {
        return mSharedPref.getBoolean(key, defValue);
    }

    public static void putBoolean(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public static long getLong(String key, long defValue) {
        return mSharedPref.getLong(key, defValue);
    }

    public static void putLong(String key, long value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putLong(key, value);
        prefsEditor.apply();
    }


    public static float getFloat(String key, float defValue) {
        return mSharedPref.getFloat(key, defValue);
    }

    public static void putFloat(String key, float value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putFloat(key, value);
        prefsEditor.apply();
    }*/

    //// Clear Preference ////
    public static void clear_session(Context context)
    {
        if(mSharedPref == null)
        {
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        }
        mSharedPref.edit().clear().apply();
    }

    //// Remove ////
    public static void remove_session_key(Context context,String Key)
    {
        if(mSharedPref == null)
        {
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        }
        mSharedPref.edit().remove(Key).apply();
    }
}
