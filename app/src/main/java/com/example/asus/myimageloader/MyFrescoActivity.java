package com.example.asus.myimageloader;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;


public class MyFrescoActivity extends AppCompatActivity {
    private SimpleDraweeView simpleDraweeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(MyFrescoActivity.this);
        setContentView(R.layout.activity_my_fresco);
        simpleDraweeView=(SimpleDraweeView)findViewById(R.id.my_image_view);
        DraweeController animatedGifController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                .setUri(Uri.parse("http://p0.qhimg.com/t015f3654b694ad2f8a.jpg"))
                .build();
        simpleDraweeView.setController(animatedGifController);

    }
}
