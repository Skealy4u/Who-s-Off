package com.skealy.staffhelper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Skealy on 07-02-2017.
 */
public class Studview extends Activity {

    private WebView m4WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studview);

        m4WebView=(WebView)findViewById(R.id.mWebView);
        WebSettings webSettings=m4WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        m4WebView.setWebViewClient(new myWebViewClient() {
            ProgressDialog progressDialog;

            public void onLoadResource(WebView view, String url) {
                if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog(Studview.this);
                    progressDialog.setTitle("Kindly fill in the details");
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                    long delayInMillis = 5000;
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                        }
                    }, delayInMillis);
                }
            }
        });
        m4WebView.loadUrl("http://220.226.170.10:8090/ParentsLogin.aspx");
    }

    public class myWebViewClient extends WebViewClient
    {
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }

    }
}