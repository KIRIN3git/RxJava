package com.example.rxjava;


import com.example.rxjava.util.RestUtil;

import io.reactivex.rxjava3.core.Observable;

/**
 * sample of Observable
 */
public class ObservableSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** ObservableSample main start ***");

        Observable.<RestUtil.Weather>create(emitter -> {
            RestUtil.Weather tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO);
            emitter.onNext(tokyoWeather);

            RestUtil.Weather yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA);
            emitter.onNext(yokohamaWeather);

            RestUtil.Weather nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA);
            emitter.onNext(nagoyaWeather);

            emitter.onComplete();

        }).subscribe(weather -> {
            System.out.println("ObservableSample Next!!");
            System.out.println(weather);

        }, throwable -> {
            System.out.println("ObservableSample Error!!");
            throwable.printStackTrace();

        }, () -> {
            System.out.println("ObservableSample Complete!!");

        });

        System.out.println("*** ObservableSample main end ***");
    }
}
