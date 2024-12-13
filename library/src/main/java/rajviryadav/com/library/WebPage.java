package rajviryadav.com.library;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebPage
{
    static ProgressDialog progressDialog;
    public static void startWebView(Context context, String url, WebView webView, String title, String message)
    {
        webView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon)
            {
                progressDialog = new ProgressDialog(context);
                progressDialog = ProgressDialog.show(context, title, message);
            }

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource(WebView view, String url) {

            }

            public void onPageFinished(WebView view, String url)
            {
                progressDialog.dismiss();
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage(description);
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alertDialog.show();
            }
        });
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setInitialScale(-50);
    }
}
