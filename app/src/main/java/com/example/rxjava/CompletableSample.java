package com.example.rxjava;

import com.example.rxjava.util.RestUtil;

import io.reactivex.rxjava3.core.Completable;

/**
 * sample of Completable
 */
public class CompletableSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** CompletableSample main start ***");

        Completable.create(emitter -> {
            RestUtil.Weather tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO);
            RestUtil.Weather yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA);
            RestUtil.Weather nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA);

            System.out.println(tokyoWeather);
            System.out.println(yokohamaWeather);
            System.out.println(nagoyaWeather);
            emitter.onComplete();

        }).subscribe(() -> {
            System.out.println("CompletableSample Complete!!");

        }, throwable -> {
            System.out.println("CompletableSample Error!!");
            throwable.printStackTrace();

        });

        System.out.println("*** CompletableSample main end ***");
    }
}
