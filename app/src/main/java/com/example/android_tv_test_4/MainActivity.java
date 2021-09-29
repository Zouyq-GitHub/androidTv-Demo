package com.example.android_tv_test_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends AppCompatActivity {

    private Button button;
    //id list
    private final int[] id_list = new int[]{R.id.image_button, R.id.video_button, R.id.exit_button};
    private Intent intent = getIntent();
    //width
    private int t_width = 0;
    //访问页面次数
    private int num = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        by_button_width_height();
        onHover();
        button = findViewById(R.id.video_button);
        button.getLayoutParams().height = t_width + 50;
        button.getLayoutParams().width = t_width + 50;
    }


    private void onClick() {
        for (int i = 0; i < id_list.length; i++) {
            button = findViewById(id_list[i]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.video_button:
                            intent = new Intent(MainActivity.this, VideoActivity.class);
                            //跳转
                            startActivityForResult(intent, 1);
                            break;
                        case R.id.image_button:
                            intent = new Intent(MainActivity.this, ImageActivity.class);
                            //跳转
                            startActivityForResult(intent, 2);
                            break;
                        case R.id.exit_button:
//                            finish();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("none");
                            break;
                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        onClick();
    }

    //hover
    private void onHover() {
//        button = findViewById(R.id.video_button);
        for (int j : id_list) {
            button = findViewById(j);
            button.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (num == 0) {
                        t_width = findViewById(view.getId()).getWidth() - 50;
                        num++;
                        // - - - -
                    } else if (num == 1) {
                        button = findViewById(R.id.exit_button);
                        button.getLayoutParams().height = t_width;
                        button.getLayoutParams().width = t_width;
                        button = findViewById(R.id.video_button);
                        button.getLayoutParams().height = t_width;
                        button.getLayoutParams().width = t_width;
                        num++;
                    } else {
                        button = findViewById(view.getId());
                        System.out.println(view.getId());
                        if (b) {
                            button.getLayoutParams().height = t_width + 50;
                            button.getLayoutParams().width = t_width + 50;
                        } else {
                            button.getLayoutParams().height = t_width;
                            button.getLayoutParams().width = t_width;
                        }
                        button.setLayoutParams(button.getLayoutParams());
                    }
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //width_height
    private void by_button_width_height() {
        button = findViewById(R.id.image_button);
        button.post(new Runnable() {
            @Override
            public void run() {
                //height
                for (int i = 0; i < id_list.length; i++) {
                    button = findViewById(id_list[i]);
                    button.getLayoutParams().height = button.getWidth();
                    button.setLayoutParams(button.getLayoutParams());
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            ResultVideo();
        } else {
            ResultImg();
        }
    }

    //Result
    private void ResultImg() {
        //width
        button = findViewById(R.id.video_button);
        button.getLayoutParams().height = t_width;
        button.getLayoutParams().width = t_width;
        button.setLayoutParams(button.getLayoutParams());
        button = findViewById(R.id.image_button);
        button.getLayoutParams().height = t_width + 50;
        button.getLayoutParams().width = t_width + 50;
        button.setLayoutParams(button.getLayoutParams());
        button = findViewById(R.id.exit_button);
        button.getLayoutParams().height = t_width;
        button.getLayoutParams().width = t_width;
    }

    private void ResultVideo() {
        //width
        button = findViewById(R.id.video_button);
        button.getLayoutParams().height = t_width + 50;
        button.getLayoutParams().width = t_width + 50;
        button.setLayoutParams(button.getLayoutParams());
        button = findViewById(R.id.image_button);
        button.getLayoutParams().height = t_width;
        button.getLayoutParams().width = t_width;
        button.setLayoutParams(button.getLayoutParams());
        button = findViewById(R.id.exit_button);
        button.getLayoutParams().height = t_width;
        button.getLayoutParams().width = t_width;
    }
}