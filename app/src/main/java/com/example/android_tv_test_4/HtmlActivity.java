package com.example.android_tv_test_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class HtmlActivity extends Activity {
    WebView wView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        wView = (WebView) findViewById(R.id.web_view);
//        webView.loadUrl("https://www.baidu.com/");

        WebSettings wSet = wView.getSettings();
        wSet.setJavaScriptEnabled(true);
// 打开本包内asset目录下的index.html文件
        wView.loadUrl("https://app.zgm.cn/");
// 打开本地sd卡内的index.html文件
//        wView.loadUrl(String.valueOf(Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/z_g_r_b/html/" + "index.html")));
//        wView.loadUrl("content://com.android.htmlfileprovider"+Environment.getExternalStorageDirectory()+ "/z_g_r_b/html/index.html");
//        wView.loadUrl("file:///mnt/sdcard/z_g_r_b/html/index.html");
// 打开指定URL的html文件
//        wView.loadUrl("http://weathernew.pae.baidu.com/weathernew/pc?query=%E5%9B%9B%E5%B7%9D%E8%87%AA%E8%B4%A1%E5%A4%A9%E6%B0%94&srcid=4982&city_name=%E8%87%AA%E8%B4%A1&province_name=%E5%9B%9B%E5%B7%9D");
    }

    /**
     * 遥控器按键监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:     //确定键enter
            case KeyEvent.KEYCODE_DPAD_CENTER:
                break;
            case KeyEvent.KEYCODE_BACK:    //返回键
                wView = (WebView) findViewById(R.id.web_view);
                if (event.getRepeatCount() > 5) {
                    //是在连续点
                    System.out.println("点击次数>5次了" + event.getRepeatCount());
                    finish();
                } else {
                    wView.goBack();
                    return true;
                }
                //提示
                System.out.println("长按回退主页面");
                break;
            case KeyEvent.KEYCODE_SETTINGS: //设置键
                break;

            case KeyEvent.KEYCODE_DPAD_DOWN:   //向下键

                /*    实际开发中有时候会触发两次，所以要判断一下按下时触发 ，松开按键时不触发
                 *    exp:KeyEvent.ACTION_UP
                 */
                if (event.getAction() == KeyEvent.ACTION_DOWN) {

                }

                break;

            case KeyEvent.KEYCODE_DPAD_UP:   //向上键
                break;

            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键
                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
                break;

            default:
                break;
        }

        return super.onKeyDown(keyCode, event);
    }
}