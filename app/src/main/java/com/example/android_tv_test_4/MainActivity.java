package com.example.android_tv_test_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends AppCompatActivity {

    private Button button;
    //id list
    private final int[] id_list = new int[]{R.id.image_button, R.id.video_button, R.id.exit_button};
    private Intent intent = getIntent();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClick();
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
//        by_button_width_height();

        



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
            System.out.println("video");
        } else {
            System.out.println("image");
        }
    }
}