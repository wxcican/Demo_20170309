package com.fuicuiedu.xc.demo_20170309;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.main_btn1)Button mBtn1;//单行复制      ctrl + d
    @BindView(R.id.main_btn2)Button mBtn2;
    @BindView(R.id.main_btn3)Button mBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//绑定到Activity身上

        mBtn1.setText("面对疾风吧！");
        mBtn2.setText("面对疾风吧！");
        mBtn3.setText("面对疾风吧！");

    }
}
