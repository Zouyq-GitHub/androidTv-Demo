//// - - - - - -
//package com.example.android_tv_test_4;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Activity;
//import android.media.MediaPlayer;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Environment;
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.RelativeLayout;
//import android.widget.SeekBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Formatter;
//import java.util.List;
//import java.util.Locale;
//
//import com.example.android_tv_test_4.view.MyVideoView;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class VideoActivity extends Activity {
//
//    @BindView(R.id.video_view)
//    MyVideoView videoView;
//    @BindView(R.id.tv_play_time)
//    TextView tvPlayTime;
//    @BindView(R.id.time_seekBar)
//    SeekBar timeSeekBar;
//    @BindView(R.id.tv_total_time)
//    TextView tvTotalTime;
//    @BindView(R.id.lay_finish_bg)
//    RelativeLayout layFinishBg;
//    @BindView(R.id.btn_play_or_pause)
//    ImageButton btnPlayOrPause;
//    @BindView(R.id.btn_restart_play)
//    ImageButton btnRestartPlay;
//
//    //video_name_array
//    private final String video_name_array[] = {"test", "test2", "test3"};
//    private int i = 0;
//    //RelativeLayout
//    private RelativeLayout relativeLayout;
//    //boolean progress
//    private boolean progress = false;
//
//
//    private Handler handler = new Handler();
//    private Runnable runnable = new Runnable() {
//        public void run() {
//            if (videoView.isPlaying()) {
//                int current = videoView.getCurrentPosition();
//                timeSeekBar.setProgress(current);
//                tvPlayTime.setText(time(videoView.getCurrentPosition()));
//            }
//            handler.postDelayed(runnable, 500);
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_video);
//        ButterKnife.bind(this);
//
//        timeSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
//        initVideo();
//        //播放完毕回调
//        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                //播放下一组视频
//                initVideo();
//                //进度条清空
//                btnRestartPlay.setVisibility(View.GONE);
//                layFinishBg.setVisibility(View.GONE);
//            }
//        });
//
//        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//
//            @Override
//            public boolean onError(MediaPlayer mp, int what, int extra) {
//                Toast.makeText(VideoActivity.this, "播放出错", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//
//        //进度条消失
//        relativeLayout = findViewById(R.id.progress_bar);
//        relativeLayout.setVisibility(View.INVISIBLE);
//    }
//
//
//    /**
//     * 时间转换方法
//     *
//     * @param millionSeconds
//     * @return
//     */
//    protected String time(long millionSeconds) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
//        Calendar c = Calendar.getInstance();
//        c.setTimeInMillis(millionSeconds);
//        return simpleDateFormat.format(c.getTime());
//    }
//
//    //test
//
//    /**
//     * 获取指定文件大小(单位：字节)
//     *
//     * @param file
//     * @return
//     * @throws Exception
//     */
//    public static long getFileSize(File file) throws Exception {
//        if (file == null) {
//            return 0;
//        }
//        long size = 0;
//        if (file.exists()) {
//            FileInputStream fis = null;
//            fis = new FileInputStream(file);
//            size = fis.available();
//        }
//        return size;
//    }
//
//
//    /**
//     * 初始化VideoView
//     */
//    private void initVideo() {
//        //本地视频
//        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/" + video_name_array[i]));
////        System.out.println(getFilesAllName("D:/java/"));
//
////
////        File file = new File("D:\\java");
////        String[] files = file.list();
////        for (String f : files) {
////            System.out.println(f);
////        }
//
//
//        if (i < video_name_array.length - 1) {
//            i = i + 1;
//        } else {
//            i = 0;
//        }
//        //网络视频 2
////        final Uri uri = Uri.parse("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4");
////        videoView.setVideoURI(uri);
//        videoView.requestFocus();
//
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                int totalTime = videoView.getDuration();//获取视频的总时长
//                tvTotalTime.setText(stringForTime(totalTime));
//
//                // 开始线程，更新进度条的刻度
//                handler.postDelayed(runnable, 0);
//                timeSeekBar.setMax(videoView.getDuration());
//                //视频加载完成,准备好播放视频的回调
//                videoView.start();
//            }
//        });
//
//    }
//
//    /**
//     * 控制视频是  播放还是暂停  或者是重播
//     *
//     * @param isPlay
//     */
//    private void isVideoPlay(boolean isPlay) {
//        if (isPlay) {//暂停
//            btnPlayOrPause.setBackground(getResources().getDrawable(R.mipmap.icon_player));
//            btnPlayOrPause.setVisibility(View.VISIBLE);
//            videoView.pause();
//        } else {//继续播放
//            btnPlayOrPause.setBackground(getResources().getDrawable(R.mipmap.icon_pause));
//            btnPlayOrPause.setVisibility(View.VISIBLE);
//            // 开始线程，更新进度条的刻度
//            handler.postDelayed(runnable, 0);
//            videoView.start();
//            timeSeekBar.setMax(videoView.getDuration());
//            timeGone();
//        }
//
//    }
//
//    /**
//     * 延时隐藏
//     */
//    private void timeGone() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                btnPlayOrPause.setVisibility(View.INVISIBLE);
//            }
//        }, 1500);
//
//    }
//
//    /**
//     * 进度条监听
//     */
//    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
//        // 当进度条停止修改的时候触发
//        @Override
//        public void onStopTrackingTouch(SeekBar seekBar) {
//            // 取得当前进度条的刻度
//            int progress = seekBar.getProgress();
//            if (videoView.isPlaying()) {
//                // 设置当前播放的位置
//                videoView.seekTo(progress);
//            }
//        }
//
//        @Override
//        public void onStartTrackingTouch(SeekBar seekBar) {
//
//        }
//
//        @Override
//        public void onProgressChanged(SeekBar seekBar, int progress,
//                                      boolean fromUser) {
//
//        }
//    };
//
//    //将长度转换为时间
//    StringBuilder mFormatBuilder = new StringBuilder();
//    Formatter mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
//
//    private String stringForTime(int timeMs) {
//        int totalSeconds = timeMs / 1000;
//
//        int seconds = totalSeconds % 60;
//        int minutes = (totalSeconds / 60) % 60;
//        int hours = totalSeconds / 3600;
//
//        mFormatBuilder.setLength(0);
//        if (hours > 0) {
//            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
//        } else {
//            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
//        }
//    }
//
//
//    private String TAG = "key";
//
//    Handler TimerHandler = new Handler();
//
//    Runnable myTimerRun = new Runnable() {
//        @Override
//        public void run() {
//            TimerHandler.postDelayed(this, 2000);
//            //VISIBLE
//            relativeLayout.setVisibility(View.GONE);
//            System.out.println("115415441");
//            TimerHandler.removeCallbacks(myTimerRun);
//        }
//    };
//
//
//    /**
//     * 遥控器按键监听
//     *
//     * @param keyCode
//     * @param event
//     * @return
//     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_ENTER:     //确定键enter
//            case KeyEvent.KEYCODE_DPAD_CENTER:
//                Log.d(TAG, "enter--->");
//                //如果是播放中则暂停、如果是暂停则继续播放
//                isVideoPlay(videoView.isPlaying());
//
//                //VISIBLE
//                TimerHandler.removeCallbacks(myTimerRun);
//                relativeLayout.setVisibility(View.VISIBLE);
//                TimerHandler.postDelayed(myTimerRun, 4000);
//                break;
//
//            case KeyEvent.KEYCODE_BACK:    //返回键
//                Log.d(TAG, "back--->");
//
////                return true;   //这里由于break会退出，所以我们自己要处理掉 不返回上一层
//                break;
//
//            case KeyEvent.KEYCODE_SETTINGS: //设置键
//                Log.d(TAG, "setting--->");
//
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_DOWN:   //向下键
//
//                /*    实际开发中有时候会触发两次，所以要判断一下按下时触发 ，松开按键时不触发
//                 *    exp:KeyEvent.ACTION_UP
//                 */
//                if (event.getAction() == KeyEvent.ACTION_DOWN) {
//                    Log.d(TAG, "down--->");
//                }
//
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_UP:   //向上键
//                Log.d(TAG, "up--->");
//
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键
//                Log.d(TAG, "left--->");
//                if (videoView.getCurrentPosition() > 4) {
//                    videoView.seekTo(videoView.getCurrentPosition() - 5 * 1000);
//                }
//
//                //VISIBLE
//                TimerHandler.removeCallbacks(myTimerRun);
//                relativeLayout.setVisibility(View.VISIBLE);
//                TimerHandler.postDelayed(myTimerRun, 4000);
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
//                Log.d(TAG, "right--->");
//                videoView.seekTo(videoView.getCurrentPosition() + 5 * 1000);
//
//                //VISIBLE
//                TimerHandler.removeCallbacks(myTimerRun);
//                relativeLayout.setVisibility(View.VISIBLE);
//                TimerHandler.postDelayed(myTimerRun, 4000);
//                break;
//
//            case KeyEvent.KEYCODE_VOLUME_UP:   //调大声音键
//                Log.d(TAG, "voice up--->");
//                break;
//
//            case KeyEvent.KEYCODE_VOLUME_DOWN: //降低声音键
//                Log.d(TAG, "voice down--->");
//
//                break;
//            case KeyEvent.KEYCODE_VOLUME_MUTE: //禁用声音
//                Log.d(TAG, "voice mute--->");
//                break;
//            default:
//                break;
//        }
//
//        return super.onKeyDown(keyCode, event);
//
//    }
//}


// - - -
// - - - - - -
package com.example.android_tv_test_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import com.example.android_tv_test_4.util.PermissionUtils;
import com.example.android_tv_test_4.view.MyVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends Activity {

    @BindView(R.id.video_view)
    MyVideoView videoView;
    @BindView(R.id.tv_play_time)
    TextView tvPlayTime;
    @BindView(R.id.time_seekBar)
    SeekBar timeSeekBar;
    @BindView(R.id.tv_total_time)
    TextView tvTotalTime;
    @BindView(R.id.lay_finish_bg)
    RelativeLayout layFinishBg;
    @BindView(R.id.btn_play_or_pause)
    ImageButton btnPlayOrPause;
    @BindView(R.id.btn_restart_play)
    ImageButton btnRestartPlay;

    //video_name_array
    private int video_name_array[];
    private int i = 0;
    //RelativeLayout
    private RelativeLayout relativeLayout;
    //boolean progress
    private boolean progress = false;


    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
            if (videoView.isPlaying()) {
                int current = videoView.getCurrentPosition();
                timeSeekBar.setProgress(current);
                tvPlayTime.setText(time(videoView.getCurrentPosition()));
            }
            handler.postDelayed(runnable, 500);
        }
    };
    //权限方法重写


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initVideo();
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("权限调用失败");
                        }
                    });
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        //权限调用
        if (PermissionUtils.isGrantExternalRW(VideoActivity.this, 1)) {
            initVideo();
        }


        timeSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
//        initVideo();
        //播放完毕回调
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //播放下一组视频
                initVideo();
                //进度条清空
                btnRestartPlay.setVisibility(View.GONE);
                layFinishBg.setVisibility(View.GONE);
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(VideoActivity.this, "播放出错", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //进度条消失
        relativeLayout = findViewById(R.id.progress_bar);
        relativeLayout.setVisibility(View.INVISIBLE);

        //创建File对象 路径
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/z_g_r_b/videos");
        //获取该目录下的所有文件
        String[] files = file.list();
        //长度定义
        video_name_array = new int[files.length];

        int z = 0;
        for (String f : files) {
            System.out.println(f);
            video_name_array[z] = Integer.parseInt(f.substring(0, 1));
            z++;
        }
        //对数组进行排序决定播放顺序  冒泡
        int video_int_name = 0;
        for (int j = 0; j < video_name_array.length; j++) {
            for (int k = 0; k < video_name_array.length - 1; k++) {
                if (video_name_array[k] > video_name_array[k + 1]) {
                    video_int_name = video_name_array[k];
                    video_name_array[k] = video_name_array[k + 1];
                    video_name_array[k + 1] = video_int_name;
                }
            }
        }
    }


    /**
     * 时间转换方法
     *
     * @param millionSeconds
     * @return
     */
    protected String time(long millionSeconds) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millionSeconds);
        return simpleDateFormat.format(c.getTime());
    }

    //test
//    public static List<String> getFilesAllName(String path) {
//        File file = new File(path);
//        File[] files = file.listFiles();
//        if (files == null) {
//            Log.e("error", "空目录");
//            return null;
//        }
//        List<String> s = new ArrayList<>();
//        for (int i = 0; i < files.length; i++) {
//            s.add(files[i].getAbsolutePath());
//        }
//        return s;
//    }

    /**
     * 初始化VideoView
     */
    private void initVideo() {
        //本地视频
//        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/" + video_name_array[i]));
        videoView.setVideoURI(Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/z_g_r_b/videos/" + video_name_array[i] + ".mp4"));
//  √      System.out.println(getFilesAllName(Environment.getExternalStorageDirectory().getAbsolutePath() + "/z_g_r_b/videos/"));

        if (i < video_name_array.length - 1) {
            i = i + 1;
        } else {
            i = 0;
        }
        //获取路径
//        System.out.println("获取外部存储根路径" + Environment.getExternalStorageDirectory().getAbsolutePath());
//        System.out.println("获取外部存储根路径" + Environment.getExternalStoragePublicDirectory("").getAbsolutePath());
//        System.out.println("这个方法是获取某个应用在外部存储中的files路径 " + getExternalFilesDir("").getAbsolutePath());
//        System.out.println("这个方法是获取某个应用在外部存储中的cache路径 " + getExternalCacheDir().getAbsolutePath());

        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                int totalTime = videoView.getDuration();//获取视频的总时长
                tvTotalTime.setText(stringForTime(totalTime));

                // 开始线程，更新进度条的刻度
                handler.postDelayed(runnable, 0);
                timeSeekBar.setMax(videoView.getDuration());
                //视频加载完成,准备好播放视频的回调
                videoView.start();
            }
        });

    }

    /**
     * 控制视频是  播放还是暂停  或者是重播
     *
     * @param isPlay
     */
    private void isVideoPlay(boolean isPlay) {
        if (isPlay) {//暂停
            btnPlayOrPause.setBackground(getResources().getDrawable(R.mipmap.icon_player));
            btnPlayOrPause.setVisibility(View.VISIBLE);
            videoView.pause();
        } else {//继续播放
            btnPlayOrPause.setBackground(getResources().getDrawable(R.mipmap.icon_pause));
            btnPlayOrPause.setVisibility(View.VISIBLE);
            // 开始线程，更新进度条的刻度
            handler.postDelayed(runnable, 0);
            videoView.start();
            timeSeekBar.setMax(videoView.getDuration());
            timeGone();
        }

    }

    /**
     * 延时隐藏
     */
    private void timeGone() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btnPlayOrPause.setVisibility(View.INVISIBLE);
            }
        }, 1500);

    }

    /**
     * 进度条监听
     */
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        // 当进度条停止修改的时候触发
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // 取得当前进度条的刻度
            int progress = seekBar.getProgress();
            if (videoView.isPlaying()) {
                // 设置当前播放的位置
                videoView.seekTo(progress);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {

        }
    };

    //将长度转换为时间
    StringBuilder mFormatBuilder = new StringBuilder();
    Formatter mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());

    private String stringForTime(int timeMs) {
        int totalSeconds = timeMs / 1000;

        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;

        mFormatBuilder.setLength(0);
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }


    private String TAG = "key";

    Handler TimerHandler = new Handler();

    Runnable myTimerRun = new Runnable() {
        @Override
        public void run() {
            TimerHandler.postDelayed(this, 2000);
            //VISIBLE
            relativeLayout.setVisibility(View.GONE);
            System.out.println("115415441");
            TimerHandler.removeCallbacks(myTimerRun);
        }
    };


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
                Log.d(TAG, "enter--->");
                //如果是播放中则暂停、如果是暂停则继续播放
                isVideoPlay(videoView.isPlaying());

                //VISIBLE
                TimerHandler.removeCallbacks(myTimerRun);
                relativeLayout.setVisibility(View.VISIBLE);
                TimerHandler.postDelayed(myTimerRun, 4000);
                break;

            case KeyEvent.KEYCODE_BACK:    //返回键
                Log.d(TAG, "back--->");

//                return true;   //这里由于break会退出，所以我们自己要处理掉 不返回上一层
                break;

            case KeyEvent.KEYCODE_SETTINGS: //设置键
                Log.d(TAG, "setting--->");

                break;

            case KeyEvent.KEYCODE_DPAD_DOWN:   //向下键

                /*    实际开发中有时候会触发两次，所以要判断一下按下时触发 ，松开按键时不触发
                 *    exp:KeyEvent.ACTION_UP
                 */
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    Log.d(TAG, "down--->");
                }

                break;

            case KeyEvent.KEYCODE_DPAD_UP:   //向上键
                Log.d(TAG, "up--->");

                break;

            case KeyEvent.KEYCODE_DPAD_LEFT: //向左键
                Log.d(TAG, "left--->");
                if (videoView.getCurrentPosition() > 4) {
                    videoView.seekTo(videoView.getCurrentPosition() - 5 * 1000);
                }

                //VISIBLE
                TimerHandler.removeCallbacks(myTimerRun);
                relativeLayout.setVisibility(View.VISIBLE);
                TimerHandler.postDelayed(myTimerRun, 4000);
                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:  //向右键
                Log.d(TAG, "right--->");
                videoView.seekTo(videoView.getCurrentPosition() + 5 * 1000);

                //VISIBLE
                TimerHandler.removeCallbacks(myTimerRun);
                relativeLayout.setVisibility(View.VISIBLE);
                TimerHandler.postDelayed(myTimerRun, 4000);
                break;

            case KeyEvent.KEYCODE_VOLUME_UP:   //调大声音键
                Log.d(TAG, "voice up--->");
                break;

            case KeyEvent.KEYCODE_VOLUME_DOWN: //降低声音键
                Log.d(TAG, "voice down--->");

                break;
            case KeyEvent.KEYCODE_VOLUME_MUTE: //禁用声音
                Log.d(TAG, "voice mute--->");
                break;
            default:
                break;
        }

        return super.onKeyDown(keyCode, event);

    }
}



