package com.bawei.week2.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.week2.R;
import com.bawei.week2.base.BaseActivity;
import com.bawei.week2.base.BasePresenter;
import com.bawei.week2.model.bean.Evencz;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends BaseActivity {

    @BindView(R.id.ewm)
    TextView ewm;
    @BindView(R.id.zfc)
    Button zfc;
    @BindView(R.id.dx)
    Button dx;
    @BindView(R.id.image)
    ImageView image;

    @Override
    protected BasePresenter providerPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        CodeUtils.init(this);
        image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                CodeUtils.analyzeByImageView(image, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(Main2Activity.this, "成功"+result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(Main2Activity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }


    @OnClick({R.id.ewm, R.id.zfc, R.id.dx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ewm:
                Bitmap bitmap = CodeUtils.createImage(ewm.getText().toString(), 400, 400, null);
                image.setImageBitmap(bitmap);
                break;
            case R.id.zfc:
                EventBus.getDefault().post("字符串");
                break;
            case R.id.dx:
                EventBus.getDefault().post(new Evencz("名字",32));
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void onevena(String json){
        Toast.makeText(this, "成功"+json, Toast.LENGTH_SHORT).show();
    }
    @Subscribe
    public void onevena(Evencz json){
        Toast.makeText(this, "成功"+json, Toast.LENGTH_SHORT).show();
    }
}
