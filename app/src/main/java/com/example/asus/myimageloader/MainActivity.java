package com.example.asus.myimageloader;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class MainActivity extends AppCompatActivity {
        private ImageView mImageView;
    private MyThread myThread;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=(ImageView)findViewById(R.id.img_text);
        mButton=(Button)findViewById(R.id.fresco_but);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyFrescoActivity.class);
                startActivity(intent);
            }
        });
        myThread=new MyThread();
        runOnUiThread(myThread);
    }
    class  MyThread implements Runnable{

        @Override
        public void run() {
            String str="http://p0.qhimg.com/t015f3654b694ad2f8a.jpg";
            DisplayImageOptions options=new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisc(true)
                    .showImageForEmptyUri(R.mipmap.ic_launcher)
                    .showImageOnLoading(R.mipmap.ic_launcher)
                    .displayer(new FadeInBitmapDisplayer(100))
                    .build();
            ImageLoader.getInstance().displayImage(str,mImageView,options);
        }
    }
}
