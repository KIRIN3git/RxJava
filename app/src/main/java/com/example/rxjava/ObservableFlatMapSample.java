package com.example.rxjava;


import com.example.rxjava.util.RestUtil;

import io.reactivex.rxjava3.core.Observable;

/**
 * sample of Observable
 */
public class ObservableFlatMapSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** ObservableFlatMapSample main start ***");

        Observable.<RestUtil.Place>create(emitter -> {
            emitter.onNext(RestUtil.Place.TOKYO);
            emitter.onNext(RestUtil.Place.YOKOHAMA);
            emitter.onNext(RestUtil.Place.NAGOYA);
            emitter.onComplete();

        }).flatMap(place -> {
            return Observable.create(emitter -> {
                RestUtil.Weather tokyoWeather = RestUtil.getWeather(place);
                emitter.onNext(tokyoWeather);
                emitter.onComplete();
            });

        }).subscribe(weather -> {
            System.out.println("ObservableFlatMapSample Next!!");
            System.out.println(weather);

        }, throwable -> {
            System.out.println("ObservableFlatMapSample Error!!");
            throwable.printStackTrace();

        }, () -> {
            System.out.println("ObservableFlatMapSample Complete!!");

        });

        System.out.println("*** ObservableFlatMapSample main end ***");
    }
}
