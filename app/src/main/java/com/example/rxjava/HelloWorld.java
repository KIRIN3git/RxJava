package com.example.rxjava;

import android.util.Log;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HelloWorld {
    public static void main() {
        Flowable.just("Hello world").subscribe(System.out::println);

        Flowable<Integer> flow = Flowable.range(1, 5)
                .map(v -> v * v)
                .filter(v -> v % 3 == 0)
                ;
        Log.w( "DEBUG_DATA", "flow = " + flow );

        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);
                Log.w( "DEBUG_DATA", "time " + time );
                if (time % 2 != 0) {
                    emitter.onError(new IllegalStateException("Odd millisecond!"));
                    break;
                }
            }
        })
                .subscribe(System.out::println, Throwable::printStackTrace);

        Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        try {
            Thread.sleep(2000); // <--- wait for the flow to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}