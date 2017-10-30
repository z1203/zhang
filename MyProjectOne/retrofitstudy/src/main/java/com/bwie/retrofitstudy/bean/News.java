package com.bwie.retrofitstudy.bean;

import java.util.List;

/**
 * Created by 张丹阳 on 2017/10/30.
 */

public class News {
    public List<Ads> ads;

    public class Ads{
        public String imgsrc;
        public String gonggaoren;
    }
}
