package com.example.uplaoding.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.uplaoding.R;
import com.example.uplaoding.adapter.VpAdapter;
import com.example.uplaoding.bean.BannerBean;
import com.example.uplaoding.contract.MainContract;
import com.example.uplaoding.fragment.SaveFragment;
import com.example.uplaoding.fragment.StudentFragment;
import com.example.uplaoding.presenter.ImpMainPresenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private Banner ban;
    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> list;
    private VpAdapter adapter;
    private ImpMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initDate() {
        presenter = new ImpMainPresenter(this);
        presenter.mainPresenter();
    }

    private void initView() {
        ban = findViewById(R.id.ban);
        tab = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);

        list = new ArrayList<>();
        list.add(new SaveFragment());
        list.add(new StudentFragment());
        adapter = new VpAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("学校新闻");
        tab.getTabAt(1).setText("班级成绩查询");

    }

    @Override
    public void onSuccess(BannerBean bannerBean) {
        ban.setImages(bannerBean.getBannerlist())
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        BannerBean.BannerlistDTO bannerlistDTO= (BannerBean.BannerlistDTO) path;
                        Glide.with(MainActivity.this).load(bannerlistDTO.getImageurl()).into(imageView);
                    }
                }).start();
    }

    @Override
    public void onFail(String error) {
        Log.e("TAG",error);
    }
}