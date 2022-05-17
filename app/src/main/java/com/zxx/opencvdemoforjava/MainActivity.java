package com.zxx.opencvdemoforjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.picture);
        OpenCVLoader.initDebug();
    }

    public void processPic(View view) {
        Mat srcMat = new Mat();
        Mat dstMat = new Mat();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        Utils.bitmapToMat(bitmap, srcMat);
        Imgproc.cvtColor(srcMat, dstMat, Imgproc.COLOR_BGR2GRAY);
        Utils.matToBitmap(dstMat, bitmap);
        mImageView.setImageBitmap(bitmap);
    }
}
