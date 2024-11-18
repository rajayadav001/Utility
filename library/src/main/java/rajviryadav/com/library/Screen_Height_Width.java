package rajviryadav.com.library;

import android.content.Context;
import android.util.DisplayMetrics;

public class Screen_Height_Width {

    private Screen_Height_Width() {
        throw new AssertionError();
    }

    public static int getScreenWidth(Context context)
    {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}
