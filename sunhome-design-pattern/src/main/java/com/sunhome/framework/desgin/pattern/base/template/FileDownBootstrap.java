package com.sunhome.framework.desgin.pattern.base.template;

import com.sunhome.framework.desgin.pattern.base.template.entiy.FileResult;

/**
 * @author wangqijia
 * @date 2019/11/14 17:35
 */
public class FileDownBootstrap {
    private static String music_url = "https://www.xiami.com/song/376049";

    private static String car_url = "https://www.kaixin.com/html/buycar.html?city=wuhan";


    public static void main(String[] args) {
//        FileDown fileDown = new MusicFileDownProcessor();
//        FileResult result = fileDown.download(music_url);
//        System.out.println(result.getFileBody());

        FileDown carDown = new MusicFileDownProcessor();
        FileResult carResult = carDown.download(car_url);
        System.out.println(carResult.getFileBody());


    }
}
