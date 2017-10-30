package com.bwie.retrofitstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bwie.retrofitstudy.api.Api;
import com.bwie.retrofitstudy.bean.Info;
import com.bwie.retrofitstudy.bean.News;
import com.bwie.retrofitstudy.bean.User;
import com.bwie.retrofitstudy.inter.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取数据
       // getData();
        //getArgumentData();
        getArgumentData2();
    }

    private void getArgumentData2() {
        //得到Retrofit对象,建造者设计模式
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.baseUrl3).addConverterFactory(GsonConverterFactory.create()).build();
        //得到一个网络接口，通过动态代理的方式获得
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<Info> call = retrofitService.getArgumentDate2(1, 0);
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Info info = response.body();
                List<Info.DataInfo> data = info.data;
                for (Info.DataInfo infos:data) {
                    Toast.makeText(MainActivity.this, "请求成功"+infos.TITLE, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });


    }

    private void getArgumentData() {
        //得到Retrofit对象,建造者设计模式
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.baseUrl2).addConverterFactory(GsonConverterFactory.create()).build();
        //得到一个网络接口，通过动态代理的方式获得
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        //获得Call对象
        Call<User> call = retrofitService.getArgumentDate("forever");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Toast.makeText(MainActivity.this, "请求成功"+user.avatar_url, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

    private void getData() {
        //得到Retrofit对象,建造者设计模式
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.baseUrl1).addConverterFactory(GsonConverterFactory.create()).build();
        //得到一个网络接口，通过动态代理的方式获得
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        //获得Call对象
        Call<News> call = retrofitService.getData();
        //执行异步请求
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                //回调在主线程
                //Love_mysunshine
                //chaixiaokai
                News news = response.body();
                List<News.Ads> ads = news.ads;
                for (int i = 0; i < ads.size(); i++) {
                    News.Ads ads1 = ads.get(i);
                    String s = ads1.gonggaoren;
                    String s1 = ads1.imgsrc;
                    Toast.makeText(MainActivity.this, "请求成功"+s+","+s1, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });

    }
}
