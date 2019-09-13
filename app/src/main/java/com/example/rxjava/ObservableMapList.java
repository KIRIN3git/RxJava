package com.example.rxjava;

import io.reactivex.rxjava3.core.Observable;

public class ObservableMapList {

    public static void ListProcess(){
            System.out.println("*** ListProcess main start ***");

            Observable.<Integer>create(emitter -> {
                Integer[] no_list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

                for(int i = 0; i< no_list.length; i++){
                    if( i % 2 == 0 ) emitter.onNext(i);
                }
                emitter.onComplete();

            }).map(no -> {
                if( no % 2 == 0){
                    return no * 10;
                }
                else return no;

            }).subscribe(no -> {
                System.out.println("ListProcess Next!!");
                System.out.println(no);

            }, throwable -> {
                System.out.println("ListProcess Error!!");
                throwable.printStackTrace();

            }, () -> {
                System.out.println("ListProcess Complete!!");
            });

            System.out.println("*** ListProcess main end ***");
        }


}
