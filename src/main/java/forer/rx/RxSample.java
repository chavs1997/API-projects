package forer.rx;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxSample {
    public static void  main(String [] args){
        Observable <Integer> observable = Observable.just(5, 4, 3,4,4, 2, 1);
        Disposable disposable = observable.filter(integer -> integer % 2 == 0)
                .map(integer -> integer * 2)
                .distinct()
                .sorted()
                .count()
                //.subscribeOn(Schedulers.computation())
                //.observeOn(Schedulers.single())
                .subscribe(System.out::println);

        // Only dispose when finished.
        disposable.dispose();
    }
}
