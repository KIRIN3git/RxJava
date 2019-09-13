package com.example.rxjava.util;

import java.util.Random;

/**
 * RestUtility (Dummy)
 */
public class RestUtil {

    /**
     * WeatherInfo
     */
    public enum Weather {
        SUNNY, RAINY, WINDY
    }

    public static  Integer aaa = 0;


    /**
     * PlaceInfo
     */
    public enum Place {
        TOKYO, YOKOHAMA, NAGOYA
    }

    /**
     * Get WeatherInfo (Dummy)
     *
     * @param place PlaceInfo
     * @return  WeatherInfo
     */
    public static Weather getWeather(Place place) {
        Weather weather;

        switch (place) {
            case TOKYO:
                weather = Weather.SUNNY;
                break;
            case YOKOHAMA:
                weather = Weather.RAINY;
                break;
            case NAGOYA:
                weather = Weather.WINDY;
                break;
            default:
                weather = Weather.SUNNY;
                break;
        }

        try {
            // Dummy Logic
            Thread.sleep(new Random().nextInt(500) + 500);
        } catch (InterruptedException e) {
            // nop
        }

        return weather;
    }
}
