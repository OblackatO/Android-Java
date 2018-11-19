package com.example.a017066611b.intenthandle;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webview = new WebView(this);
        webview.setWebViewClient(new WebViewClient());
        setContentView(webview);

        Uri data = getIntent().getData();
        try
        {
            URL url = new URL(data.getScheme(), data.getHost(), data.getPath());
            webview.loadUrl(url.toExternalForm());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}