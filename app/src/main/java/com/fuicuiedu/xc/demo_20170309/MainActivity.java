package com.fuicuiedu.xc.demo_20170309;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private Unbinder unbinder;


    @BindView(R.id.main_btn1)Button mBtn1;//单行复制      ctrl + d
    @BindView(R.id.main_btn2)Button mBtn2;
    @BindView(R.id.main_btn3)Button mBtn3;

    //绑定视图列表
    @BindViews({R.id.main_btn1,R.id.main_btn2,R.id.main_btn3})List<Button> buttons;

    //资源绑定
    @BindString(R.string.app_name)String app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);//绑定到Activity身上

        mBtn1.setText(app_name);
        mBtn2.setText("面对疾风吧！");
        mBtn3.setText("面对疾风吧！");

        //统一操作视图集合
        ButterKnife.apply(buttons, new ButterKnife.Action<Button>() {
            @Override
            public void apply(@NonNull Button view, int index) {
                view.setText(app_name);
            }
        });

        ButterKnife.apply(buttons, new ButterKnife.Setter<Button, String>() {
            @Override
            public void set(@NonNull Button view, String value, int index) {
                view.setText(value);
            }
        },"呵呵");

    }

    @OnClick({R.id.main_btn1,R.id.main_btn2,R.id.main_btn3})
    public void aaa(View view){
        switch (view.getId()){
            case R.id.main_btn1:
                Toast.makeText(this, "btn1111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn2:
                Toast.makeText(this, "btn2222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn3:
                Toast.makeText(this, "btn3333", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();//视图销毁时，解绑。
    }
}
