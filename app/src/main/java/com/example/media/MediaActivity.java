package com.example.media;

import java.io.File;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.R;

/**
 * Created by roger.zhang on 2014/7/23.
 */
public class MediaActivity extends Activity implements OnClickListener {
    private Button btn_videoview, btn_controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_main);

        btn_videoview = (Button) findViewById(R.id.btn_videoview);
        btn_controller = (Button) findViewById(R.id.btn_controller);

        btn_videoview.setOnClickListener(this);
        btn_controller.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_videoview:
                intent=new Intent(MediaActivity.this, VideoViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_controller:
                intent=new Intent(MediaActivity.this, ControllerActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

}
