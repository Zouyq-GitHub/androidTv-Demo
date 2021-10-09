package com.example.android_tv_test_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class HtmlActivity extends Activity {
//    WebView webView = findViewById(R.id.web_view);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);

//        webView.loadUrl("https://www.baidu.com/");

        WebView wView = (WebView) findViewById(R.id.web_view);
        WebSettings wSet = wView.getSettings();
        wSet.setJavaScriptEnabled(true);
// 打开本包内asset目录下的index.html文件
//        wView.loadUrl("file:///android_asset/index.html");
// 打开本地sd卡内的index.html文件
//        wView.loadUrl(String.valueOf(Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/z_g_r_b/html/" + "index.html")));
//        wView.loadUrl("content://com.android.htmlfileprovider"+Environment.getExternalStorageDirectory()+ "/z_g_r_b/html/index.html");
        wView.loadUrl("file:///mnt/sdcard/z_g_r_b/html/index.html");
// 打开指定URL的html文件
//        wView.loadUrl("http://weathernew.pae.baidu.com/weathernew/pc?query=%E5%9B%9B%E5%B7%9D%E8%87%AA%E8%B4%A1%E5%A4%A9%E6%B0%94&srcid=4982&city_name=%E8%87%AA%E8%B4%A1&province_name=%E5%9B%9B%E5%B7%9D");
    }


}