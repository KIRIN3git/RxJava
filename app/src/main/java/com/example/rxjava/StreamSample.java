package com.example.rxjava;


import com.example.rxjava.util.RestUtil;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * sample of Stream
 */
public class StreamSample {

    /**
     * main logic
     */
    public static void main(String[] args) {
        System.out.println("*** StreamSample main start ***");

        RestUtil.Weather tokyoWeather = RestUtil.getWeather(RestUtil.Place.TOKYO);
        RestUtil.Weather yokohamaWeather = RestUtil.getWeather(RestUtil.Place.YOKOHAMA);
        RestUtil.Weather nagoyaWeather = RestUtil.getWeather(RestUtil.Place.NAGOYA);

        Stream.of(Arrays.asList(tokyoWeather, yokohamaWeather, nagoyaWeather))
                .forEach(weather -> {
                    System.out.println(weather + "");
                });

        System.out.println("*** StreamSample main end ***");
    }
}
