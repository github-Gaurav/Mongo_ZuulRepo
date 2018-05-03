package com.example.demo.react;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;

public class ReactDemo {

	public static void main(String[] args) {

		Observable<String> obs =  Observable.just("Hello");
		Observable.range(1, 5).subscribe(
				u -> System.out.println(u),
				v -> System.out.println("error"),
				() -> System.out.println(Thread.currentThread().getId()));
		 
		 Observable<Integer> source = Observable.range(1, 5);

	        Subscriber<Integer> consumer = new Subscriber<Integer>() {
	            @Override
	            public void onNext(Integer number) { System.out.println(number); }

	            @Override
	            public void onError(Throwable e) { System.out.println("error"); }


				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSubscribe(Subscription arg0) {
					// TODO Auto-generated method stub
					
				}
	        };
	        source.subscribe();
	        
	        
	}

}
