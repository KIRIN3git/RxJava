package com.example.rxjava;


import com.example.rxjava.util.RestUtil;

import io.reactivex.rxjava3.core.Observable;

/**
 * sample of Observable
 */
public class ObservableMapSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** ObservableMapSample main start ***");

        Observable.<RestUtil.Weather>create(emitter -> {
            RestUtil.Weather tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO);
            emitter.onNext(tokyoWeather);

            RestUtil.Weather yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA);
            emitter.onNext(yokohamaWeather);

            RestUtil.Weather nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA);
            emitter.onNext(nagoyaWeather);

            emitter.onComplete();

        }).map(weather -> {
            switch (weather) {
                case SUNNY:
                    return "happy day!!";
                case RAINY:
                    return "sad day...";
                case WINDY:
                default:
                    return "normal day";
            }

        }).subscribe(weather -> {
            System.out.println("ObservableMapSample Next!!");
            System.out.println(weather);

        }, throwable -> {
            System.out.println("ObservableMapSample Error!!");
            throwable.printStackTrace();

        }, () -> {
            System.out.println("ObservableMapSample Complete!!");

        });

        System.out.println("*** ObservableMapSample main end ***");
    }
}
