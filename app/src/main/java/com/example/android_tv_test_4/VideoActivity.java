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
//        //??????????????????
//        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                //?????????????????????
//                initVideo();
//                //???????????????
//                btnRestartPlay.setVisibility(View.GONE);
//                layFinishBg.setVisibility(View.GONE);
//            }
//        });
//
//        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//
//            @Override
//            public boolean onError(MediaPlayer mp, int what, int extra) {
//                Toast.makeText(VideoActivity.this, "????????????", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//
//        //???????????????
//        relativeLayout = findViewById(R.id.progress_bar);
//        relativeLayout.setVisibility(View.INVISIBLE);
//    }
//
//
//    /**
//     * ??????????????????
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
//     * ????????????????????????(???????????????)
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
//     * ?????????VideoView
//     */
//    private void initVideo() {
//        //????????????
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
//        //???????????? 2
////        final Uri uri = Uri.parse("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4");
////        videoView.setVideoURI(uri);
//        videoView.requestFocus();
//
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                int totalTime = videoView.getDuration();//????????????????????????
//                tvTotalTime.setText(stringForTime(totalTime));
//
//                // ???????????????????????????????????????
//                handler.postDelayed(runnable, 0);
//                timeSeekBar.setMax(videoView.getDuration());
//                //??????????????????,??????????????????????????????
//                videoView.start();
//            }
//        });
//
//    }
//
//    /**
//     * ???????????????  ??????????????????  ???????????????
//     *
//     * @param isPlay
//     */
//    private void isVideoPlay(boolean isPlay) {
//        if (isPlay) {//??????
//            btnPlayOrPause.setBackground(getResources().getDrawable(R.mipmap.icon_player));
//            btnPlayOrPause.setVisibility(View.VISIBLE);
//            videoView.pause();
//        } else {//????????????
//            btnPlayOrPause.setBackground(getResources().getDrawable(R.mipmap.icon_pause));
//            btnPlayOrPause.setVisibility(View.VISIBLE);
//            // ???????????????????????????????????????
//            handler.postDelayed(runnable, 0);
//            videoView.start();
//            timeSeekBar.setMax(videoView.getDuration());
//            timeGone();
//        }
//
//    }
//
//    /**
//     * ????????????
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
//     * ???????????????
//     */
//    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
//        // ???????????????????????????????????????
//        @Override
//        public void onStopTrackingTouch(SeekBar seekBar) {
//            // ??????????????????????????????
//            int progress = seekBar.getProgress();
//            if (videoView.isPlaying()) {
//                // ???????????????????????????
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
//    //????????????????????????
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
//     * ?????????????????????
//     *
//     * @param keyCode
//     * @param event
//     * @return
//     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_ENTER:     //?????????enter
//            case KeyEvent.KEYCODE_DPAD_CENTER:
//                Log.d(TAG, "enter--->");
//                //????????????????????????????????????????????????????????????
//                isVideoPlay(videoView.isPlaying());
//
//                //VISIBLE
//                TimerHandler.removeCallbacks(myTimerRun);
//                relativeLayout.setVisibility(View.VISIBLE);
//                TimerHandler.postDelayed(myTimerRun, 4000);
//                break;
//
//            case KeyEvent.KEYCODE_BACK:    //?????????
//                Log.d(TAG, "back--->");
//
////                return true;   //????????????break?????????????????????????????????????????? ??????????????????
//                break;
//
//            case KeyEvent.KEYCODE_SETTINGS: //?????????
//                Log.d(TAG, "setting--->");
//
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_DOWN:   //?????????
//
//                /*    ?????????????????????????????????????????????????????????????????????????????? ???????????????????????????
//                 *    exp:KeyEvent.ACTION_UP
//                 */
//                if (event.getAction() == KeyEvent.ACTION_DOWN) {
//                    Log.d(TAG, "down--->");
//                }
//
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_UP:   //?????????
//                Log.d(TAG, "up--->");
//
//                break;
//
//            case KeyEvent.KEYCODE_DPAD_LEFT: //?????????
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
//            case KeyEvent.KEYCODE_DPAD_RIGHT:  //?????????
//                Log.d(TAG, "right--->");
//                videoView.seekTo(videoView.getCurrentPosition() + 5 * 1000);
//
//                //VISIBLE
//                TimerHandler.removeCallbacks(myTimerRun);
//                relativeLayout.setVisibility(View.VISIBLE);
//                TimerHandler.postDelayed(myTimerRun, 4000);
//                break;
//
//            case KeyEvent.KEYCODE_VOLUME_UP:   //???????????????
//                Log.d(TAG, "voice up--->");
//                break;
//
//            case KeyEvent.KEYCODE_VOLUME_DOWN: //???????????????
//                Log.d(TAG, "voice down--->");
//
//                break;
//            case KeyEvent.KEYCODE_VOLUME_MUTE: //????????????
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
    //??????????????????
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
                            System.out.println("??????????????????");
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

        //????????????
        if (PermissionUtils.isGrantExternalRW(VideoActivity.this, 1)) {
            initVideo();
        }


        timeSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
//        initVideo();
        //??????????????????
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //?????????????????????
                initVideo();
                //???????????????
                btnRestartPlay.setVisibility(View.GONE);
                layFinishBg.setVisibility(View.GONE);
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(VideoActivity.this, "????????????", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //???????????????
        relativeLayout = findViewById(R.id.progress_bar);
        relativeLayout.setVisibility(View.INVISIBLE);

        //??????File?????? ??????
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/z_g_r_b/videos");
        //?????????????????????????????????
        String[] files = file.list();
        //????????????
        video_name_array = new int[files.length];

        int z = 0;
        for (String f : files) {
            System.out.println(f);
            video_name_array[z] = Integer.parseInt(f.substring(0, 1));
            z++;
        }
        //???????????????????????????????????????  ??????
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
     * ??????????????????
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

    /**
     * ?????????VideoView
     */
    private void initVideo() {
        //????????????
//        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/raw/" + video_name_array[i]));
        videoView.setVideoURI(Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/z_g_r_b/videos/" + video_name_array[i] + ".mp4"));
//  ???      System.out.println(getFilesAllName(Environment.getExternalStorageDirectory().getAbsolutePath() + "/z_g_r_b/videos/"));

        if (i < video_name_array.length - 1) {
            i = i + 1;
        } else {
            i = 0;
        }
        //????????????
//        System.out.println("???????????????????????????" + Environment.getExternalStorageDirectory().getAbsolutePath());
//        System.out.println("???????????????????????????" + Environment.getExternalStoragePublicDirectory("").getAbsolutePath());
//        System.out.println("??????????????????????????????????????????????????????files?????? " + getExternalFilesDir("").getAbsolutePath());
//        System.out.println("??????????????????????????????????????????????????????cache?????? " + getExternalCacheDir().getAbsolutePath());

        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                int totalTime = videoView.getDuration();//????????????????????????
                tvTotalTime.setText(stringForTime(totalTime));

                // ???????????????????????????????????????
                handler.postDelayed(runnable, 0);
                timeSeekBar.setMax(videoView.getDuration());
                //??????????????????,??????????????????????????????
                videoView.start();
            }
        });

    }

    /**
     * ???????????????  ??????????????????  ???????????????
     *
     * @param isPlay
     */
    private void isVideoPlay(boolean isPlay) {
        if (isPlay) {//??????
            btnPlayOrPause.setBackground(getResources().getDrawable(R.mipmap.icon_player));
            btnPlayOrPause.setVisibility(View.VISIBLE);
            videoView.pause();
        } else {//????????????
            btnPlayOrPause.setBackground(getResources().getDrawable(R.mipmap.icon_pause));
            btnPlayOrPause.setVisibility(View.VISIBLE);
            // ???????????????????????????????????????
            handler.postDelayed(runnable, 0);
            videoView.start();
            timeSeekBar.setMax(videoView.getDuration());
            timeGone();
        }

    }

    /**
     * ????????????
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
     * ???????????????
     */
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        // ???????????????????????????????????????
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // ??????????????????????????????
            int progress = seekBar.getProgress();
            if (videoView.isPlaying()) {
                // ???????????????????????????
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

    //????????????????????????
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
     * ?????????????????????
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:     //?????????enter
            case KeyEvent.KEYCODE_DPAD_CENTER:
                Log.d(TAG, "enter--->");
                //????????????????????????????????????????????????????????????
                isVideoPlay(videoView.isPlaying());

                //VISIBLE
                TimerHandler.removeCallbacks(myTimerRun);
                relativeLayout.setVisibility(View.VISIBLE);
                TimerHandler.postDelayed(myTimerRun, 4000);
                break;

            case KeyEvent.KEYCODE_BACK:    //?????????
                Log.d(TAG, "back--->");

//                return true;   //????????????break?????????????????????????????????????????? ??????????????????
                break;

            case KeyEvent.KEYCODE_SETTINGS: //?????????
                Log.d(TAG, "setting--->");

                break;

            case KeyEvent.KEYCODE_DPAD_DOWN:   //?????????

                /*    ?????????????????????????????????????????????????????????????????????????????? ???????????????????????????
                 *    exp:KeyEvent.ACTION_UP
                 */
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    Log.d(TAG, "down--->");
                }

                break;

            case KeyEvent.KEYCODE_DPAD_UP:   //?????????
                Log.d(TAG, "up--->");

                break;

            case KeyEvent.KEYCODE_DPAD_LEFT: //?????????
                Log.d(TAG, "left--->");
                if (videoView.getCurrentPosition() > 4) {
                    videoView.seekTo(videoView.getCurrentPosition() - 5 * 1000);
                }

                //VISIBLE
                TimerHandler.removeCallbacks(myTimerRun);
                relativeLayout.setVisibility(View.VISIBLE);
                TimerHandler.postDelayed(myTimerRun, 4000);
                break;

            case KeyEvent.KEYCODE_DPAD_RIGHT:  //?????????
                Log.d(TAG, "right--->");
                videoView.seekTo(videoView.getCurrentPosition() + 5 * 1000);

                //VISIBLE
                TimerHandler.removeCallbacks(myTimerRun);
                relativeLayout.setVisibility(View.VISIBLE);
                TimerHandler.postDelayed(myTimerRun, 4000);
                break;

            case KeyEvent.KEYCODE_VOLUME_UP:   //???????????????
                Log.d(TAG, "voice up--->");
                break;

            case KeyEvent.KEYCODE_VOLUME_DOWN: //???????????????
                Log.d(TAG, "voice down--->");

                break;
            case KeyEvent.KEYCODE_VOLUME_MUTE: //????????????
                Log.d(TAG, "voice mute--->");
                break;
            default:
                break;
        }

        return super.onKeyDown(keyCode, event);

    }
}



