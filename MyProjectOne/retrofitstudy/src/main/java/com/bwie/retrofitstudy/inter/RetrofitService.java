package com.bwie.retrofitstudy.inter;

import com.bwie.retrofitstudy.bean.Info;
import com.bwie.retrofitstudy.bean.News;
import com.bwie.retrofitstudy.bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 1.类的用途：网络接口  封装请求方式和请求参数
 * 2.@author  forever
 * 3.@date  2017/10/30  15:24
 */

public interface RetrofitService {

    /**
     *  无参get请求
     *  http://service.meiyinkeqiu.com/service/ads/cptj
     */
    @GET("service/ads/cptj")
    Call<News> getData();

    /**
     * 有参get请求
     * 拼接参数 /形式
     *
     * @return https://api.github.com/users/baiiu
     */
    @GET("users/{user}")
    Call<User> getArgumentDate(@Path("user")String user);

    /**
     * http://www.93.gov.cn/93app/data.do
     * channelId
     * startNum
     * 拼接 ? &
     * 为主
     */
    @GET("data.do")
    Call<Info> getArgumentDate2(@Query("channelId") int channelId,@Query("startNum") int startNum);

}
