package com.abhipanel.demo;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);
        layout.setGravity(Gravity.CENTER);
        layout.setBackgroundColor(Color.rgb(5, 12, 8));

        TextView title = new TextView(this);
        title.setText("ABH PANEL");
        title.setTextColor(Color.GREEN);
        title.setTextSize(25);
        title.setGravity(Gravity.CENTER);

        Button activate = new Button(this);
        activate.setText("ACTIVATE FLOATING DEMO");

        TextView status = new TextView(this);
        status.setText("Status: INACTIVE");
        status.setTextColor(Color.WHITE);
        status.setGravity(Gravity.CENTER);
        status.setPadding(10, 20, 10, 20);

        Button openPanel = new Button(this);
        openPanel.setText("OPEN PANEL");

        layout.addView(title);
        layout.addView(activate);
        layout.addView(status);
        layout.addView(openPanel);

        setContentView(layout);

        activate.setOnClickListener(v -> {
            status.setText("Status: ACTIVATED (DEMO)");
        });

        openPanel.setOnClickListener(v -> {
            webView = new WebView(this);
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("file:///android_asset/index.html");
            setContentView(webView);
        });
    }
}
