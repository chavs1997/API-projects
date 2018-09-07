package forer.rx;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxSample {
    public static void  main(String [] args){
        Observable <Integer> observable = Observable.just(5, 4, 3, 2, 1);
        Disposable disposable = observable.filter(integer -> integer % 2 == 0)
                .sorted()
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println);

        disposable.dispose();
    }
}
