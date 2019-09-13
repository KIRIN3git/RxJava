package com.example.rxjava;


import com.example.rxjava.util.RestUtil;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * sample of Observable
 */
public class ThreadSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** ThreadSample main start ***");

        Observable.<RestUtil.Weather>create(emitter -> {
            RestUtil.Weather tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO);
            emitter.onNext(tokyoWeather);

            RestUtil.Weather yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA);
            emitter.onNext(yokohamaWeather);

            RestUtil.Weather nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA);
            emitter.onNext(nagoyaWeather);

            emitter.onComplete();

        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(weather -> {
                    System.out.println("ThreadSample Next!!");
                    System.out.println(weather);

                }, throwable -> {
                    System.out.println("ThreadSample Error!!");
                    throwable.printStackTrace();

                }, () -> {
                    System.out.println("ThreadSample Complete!!");

                });

        System.out.println("*** ThreadSample main end ***");
    }
}
