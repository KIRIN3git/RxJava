package com.example.rxjava;

import com.example.rxjava.util.RestUtil;

import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * sample of Single
 */
public class SingleSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** SingleSample main start ***");

        Single.<List<RestUtil.Weather>>create(emitter -> {
            RestUtil.Weather tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO);
            RestUtil.Weather yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA);
            RestUtil.Weather nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA);
            emitter.onSuccess(Arrays.asList(tokyoWeather, yokohamaWeather, nagoyaWeather));

        }).subscribe(weathers -> {
            System.out.println("SingleSample Complete!!");
            for (RestUtil.Weather weather : weathers) {
                System.out.println(weather);
            }

        }, throwable -> {
            System.out.println("SingleSample Error!!");
            throwable.printStackTrace();

        });

        System.out.println("*** SingleSample main end ***");
    }
}
