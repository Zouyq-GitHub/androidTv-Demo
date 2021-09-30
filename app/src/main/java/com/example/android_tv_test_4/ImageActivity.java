////package com.example.android_tv_test_4;
////
////import androidx.annotation.NonNull;
////import androidx.appcompat.app.AppCompatActivity;
////
////import android.app.Activity;
////import android.os.Bundle;
////import android.os.Handler;
////import android.os.Message;
////import android.util.Log;
////import android.view.KeyEvent;
////import android.widget.ImageView;
////
////import java.util.Timer;
////import java.util.TimerTask;
////
////public class ImageActivity extends Activity {
////
////    //变量   图片控件对象  图片ID数组  计数器
////    private Timer timer;
////    private ImageView imageView;
////    private int image_name_array[] = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7};
////    private int i = 0;
////    //switch_image_num
////    private int num = 0;
////    //switch_pic
////    private boolean switch_pic = true;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_image);
////        imageView = findViewById(R.id.pic);
////        //run
////        timer = new Timer();
////        timer.schedule(timerTask, 0, 3000);
////    }
////
////    //TimerTask
////    TimerTask timerTask = new TimerTask() {
////        @Override
////        public void run() {
////            //UI
////            handler.sendEmptyMessage(0);
////        }
////    };
////
////    Handler handler = new Handler() {
////        @Override
////        public void handleMessage(@NonNull Message msg) {
////            super.handleMessage(msg);
////            if (msg.what == 0) {
////                Log.e("photo", "true");
////                imageView.setImageResource(image_name_array[i]);
////                if (i < image_name_array.length - 1) {
////                    i++;
////                } else {
////                    i = 0;
////                }
////            }
////        }
////    };
////
////
////    /**
////     * Listening to the
////     *
////     * @param keyCode type
////     * @param event   not
////     * @return true
////     */
////    @Override
////    public boolean onKeyDown(int keyCode, KeyEvent event) {
////        switch (keyCode) {
////            case KeyEvent.KEYCODE_DPAD_CENTER:     //确定键enter
////                if (switch_pic) {
////                    //stop-switch
////                    timer.cancel();
////                    timer = null;
////                    switch_pic = false;
////                } else {
////                    switch_pic = true;
////                }
////                break;
////            case KeyEvent.KEYCODE_BACK:    //返回键
////                //clear
////                timer.cancel();
////                break;
////            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键
////                if (num == 0) {
////                    //stop
////                    timer.cancel();
////                    i = i - 1;
////                    num++;
////                }
////                //switch_pic
////                if (i <= image_name_array.length - 1 && i != 0) {
////                    i--;
////                    imageView.setImageResource(image_name_array[i]);
////                } else if (i == 0) {
////                    i = image_name_array.length - 1;
////                    imageView.setImageResource(image_name_array[i]);
////                }
////                System.out.println("i:  " + i);
////                break;
////            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
////                if (num == 0) {
////                    //stop
////                    num++;
////                    i--;
////                    timer.cancel();
////                }
////                //switch_pic
////                if (i <= image_name_array.length - 1 && i != image_name_array.length - 1) {
////                    i++;
////                    imageView.setImageResource(image_name_array[i]);
////                } else if (i == image_name_array.length - 1) {
////                    i = 0;
////                    imageView.setImageResource(image_name_array[i]);
////                }
////                System.out.println("i:  " + i);
////                break;
////        }
////        return super.onKeyDown(keyCode, event);
////    }
////}
//
////. . . . .
//
//package com.example.android_tv_test_4;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.widget.ImageView;
//
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class ImageActivity extends Activity {
//
//    //变量   图片控件对象  图片ID数组  计数器
//    private ImageView imageView;
//    private int image_name_array[] = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7};
//    private int i = 0;
//    //first_switch
//    private int first_switch = 0;
//    //switch_pic
//    private boolean switch_pic = true;
//    Handler TimerHandler = new Handler();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_image);
//        imageView = findViewById(R.id.pic);
//        //run
//        TimerHandler.postDelayed(myTimerRun, 0);        //使用postDelayed方法，两秒后再调用此myTimerRun对象
//    }
//
//    Runnable myTimerRun = new Runnable() {
//        @Override
//        public void run() {
//            TimerHandler.postDelayed(this, 3000);
//            //UI
//            handler.sendEmptyMessage(0);
//        }
//    };
//
//
//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 0) {
//                if (first_switch != 0) {
//                    Log.e("photo", "true");
//                    if (i < image_name_array.length - 1) {
//                        i++;
//                    } else {
//                        i = 0;
//                    }
//                    imageView.setImageResource(image_name_array[i]);
//                } else {
//                    first_switch++;
//                }
//            }
//        }
//    };
//
//    /**
//     * Listening to the
//     *
//     * @param keyCode type
//     * @param event   not
//     * @return true
//     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_DPAD_CENTER:     //确定键enter
//                if (switch_pic) {
//                    //stop-switch
//                    TimerHandler.removeCallbacks(myTimerRun);
//                    switch_pic = false;
//                } else {
//                    switch_pic = true;
//                    TimerHandler.postDelayed(myTimerRun, 3000);
//                }
//                break;
//            case KeyEvent.KEYCODE_BACK:    //返回键
//                //clear
//                TimerHandler.removeCallbacks(myTimerRun);
//                break;
//            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键
//                //stop_switch
//                TimerHandler.removeCallbacks(myTimerRun);
//                //switch_pic
//                if (i <= image_name_array.length - 1 && i != 0) {
//                    i--;
//                    imageView.setImageResource(image_name_array[i]);
//                } else if (i == 0) {
//                    i = image_name_array.length - 1;
//                    imageView.setImageResource(image_name_array[i]);
//                }
//                System.out.println("i:  " + i);
//                TimerHandler.postDelayed(myTimerRun, 3000);
//                break;
//            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
//                //stop_switch
//                TimerHandler.removeCallbacks(myTimerRun);
//                //switch_pic
//                if (i < image_name_array.length - 1) {
//                    i++;
//                    imageView.setImageResource(image_name_array[i]);
//                } else if (i == image_name_array.length - 1) {
//                    i = 0;
//                    imageView.setImageResource(image_name_array[i]);
//                } else {
//                    i = 0;
//                    imageView.setImageResource(image_name_array[i]);
//                }
//                System.out.println("i:  " + i);
//                TimerHandler.postDelayed(myTimerRun, 3000);
//                break;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//}

//package com.example.android_tv_test_4;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.widget.ImageView;
//
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class ImageActivity extends Activity {
//
//    //变量   图片控件对象  图片ID数组  计数器
//    private Timer timer;
//    private ImageView imageView;
//    private int image_name_array[] = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7};
//    private int i = 0;
//    //switch_image_num
//    private int num = 0;
//    //switch_pic
//    private boolean switch_pic = true;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_image);
//        imageView = findViewById(R.id.pic);
//        //run
//        timer = new Timer();
//        timer.schedule(timerTask, 0, 3000);
//    }
//
//    //TimerTask
//    TimerTask timerTask = new TimerTask() {
//        @Override
//        public void run() {
//            //UI
//            handler.sendEmptyMessage(0);
//        }
//    };
//
//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 0) {
//                Log.e("photo", "true");
//                imageView.setImageResource(image_name_array[i]);
//                if (i < image_name_array.length - 1) {
//                    i++;
//                } else {
//                    i = 0;
//                }
//            }
//        }
//    };
//
//
//    /**
//     * Listening to the
//     *
//     * @param keyCode type
//     * @param event   not
//     * @return true
//     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_DPAD_CENTER:     //确定键enter
//                if (switch_pic) {
//                    //stop-switch
//                    timer.cancel();
//                    timer = null;
//                    switch_pic = false;
//                } else {
//                    switch_pic = true;
//                }
//                break;
//            case KeyEvent.KEYCODE_BACK:    //返回键
//                //clear
//                timer.cancel();
//                break;
//            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键
//                if (num == 0) {
//                    //stop
//                    timer.cancel();
//                    i = i - 1;
//                    num++;
//                }
//                //switch_pic
//                if (i <= image_name_array.length - 1 && i != 0) {
//                    i--;
//                    imageView.setImageResource(image_name_array[i]);
//                } else if (i == 0) {
//                    i = image_name_array.length - 1;
//                    imageView.setImageResource(image_name_array[i]);
//                }
//                System.out.println("i:  " + i);
//                break;
//            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
//                if (num == 0) {
//                    //stop
//                    num++;
//                    i--;
//                    timer.cancel();
//                }
//                //switch_pic
//                if (i <= image_name_array.length - 1 && i != image_name_array.length - 1) {
//                    i++;
//                    imageView.setImageResource(image_name_array[i]);
//                } else if (i == image_name_array.length - 1) {
//                    i = 0;
//                    imageView.setImageResource(image_name_array[i]);
//                }
//                System.out.println("i:  " + i);
//                break;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//}

//. . . . .

package com.example.android_tv_test_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class ImageActivity extends Activity {

    //变量   图片控件对象  图片ID数组  计数器
    private ImageView imageView;
    private int image_name_array[];
    private int i = 0;
    //first_switch
    private int first_switch = 0;
    //switch_pic
    private boolean switch_pic = true;
    Handler TimerHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        imageView = findViewById(R.id.pic);

        //创建File对象 路径
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/z_g_r_b/images");
        //获取该目录下的所有文件
        String[] files = file.list();
        //长度定义
        image_name_array = new int[files.length];
        int z = 0;
        //遍历并赋值
        for (String f : files) {
            System.out.println(f);
            image_name_array[z] = Integer.parseInt(f.substring(0, 1));
            z++;
        }
        //对数组进行排序决定播放顺序  冒泡
        int video_int_name = 0;
        for (int j = 0; j < image_name_array.length; j++) {
            for (int k = 0; k < image_name_array.length - 1; k++) {
                if (image_name_array[k] > image_name_array[k + 1]) {
                    video_int_name = image_name_array[k];
                    image_name_array[k] = image_name_array[k + 1];
                    image_name_array[k + 1] = video_int_name;
                }
            }
        }
        //run
        TimerHandler.postDelayed(myTimerRun, 0);        //使用postDelayed方法，两秒后再调用此myTimerRun对象
    }

    Runnable myTimerRun = new Runnable() {
        @Override
        public void run() {
            TimerHandler.postDelayed(this, 3000);
            //UI
            handler.sendEmptyMessage(0);
        }
    };


    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (first_switch != 0) {
                    Log.e("photo", "true");
                    if (i < image_name_array.length - 1) {
                        i++;
                    } else {
                        i = 0;
                    }
//                    imageView.setImageResource(image_name_array[i]);
                    imageView.setImageURI(Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/z_g_r_b/images/" + image_name_array[i] + ".png"));
                } else {
                    first_switch++;
                }
            }
        }
    };

    /**
     * Listening to the
     *
     * @param keyCode type
     * @param event   not
     * @return true
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:     //确定键enter
                if (switch_pic) {
                    //stop-switch
                    TimerHandler.removeCallbacks(myTimerRun);
                    switch_pic = false;
                } else {
                    switch_pic = true;
                    TimerHandler.postDelayed(myTimerRun, 3000);
                }
                break;
            case KeyEvent.KEYCODE_BACK:    //返回键
                //clear
                TimerHandler.removeCallbacks(myTimerRun);
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键
                //stop_switch
                TimerHandler.removeCallbacks(myTimerRun);
                //switch_pic
                if (i <= image_name_array.length - 1 && i != 0) {
                    i--;
                    imageView.setImageResource(image_name_array[i]);
                } else if (i == 0) {
                    i = image_name_array.length - 1;
                    imageView.setImageResource(image_name_array[i]);
                }
                System.out.println("i:  " + i);
                TimerHandler.postDelayed(myTimerRun, 3000);
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
                //stop_switch
                TimerHandler.removeCallbacks(myTimerRun);
                //switch_pic
                if (i < image_name_array.length - 1) {
                    i++;
                    imageView.setImageResource(image_name_array[i]);
                } else if (i == image_name_array.length - 1) {
                    i = 0;
                    imageView.setImageResource(image_name_array[i]);
                } else {
                    i = 0;
                    imageView.setImageResource(image_name_array[i]);
                }
                System.out.println("i:  " + i);
                TimerHandler.postDelayed(myTimerRun, 3000);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}