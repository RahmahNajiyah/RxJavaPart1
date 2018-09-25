package com.hafidzcode.rxjavatrial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

public class MainActivity extends AppCompatActivity {


    //todo 2 deklarasi (sure you was make the layout before)
    Button btn1, btn2, btn3, btn4, btn5;
    //todo 20 deklarasi Movie
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 3 inisialisasi
        btn1 = (Button) findViewById(R.id.btnRun);
        btn2 = (Button) findViewById(R.id.btnRun2);
        btn3 = (Button) findViewById(R.id.btnRun3);
        btn4 = (Button) findViewById(R.id.btnRun4);
        btn5 = (Button) findViewById(R.id.btnRun5);

        // todo 4 setClick
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // todo 5 make new method for From() method
                demoObservableFrom();
            }
        });

        //todo 8
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 9 make new method for Just() method
                demoObservableJust();
            }
        });

        //todo 15
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //todo 16
                //todo 21 delete Movie (yg sblmya kita buat), just make it movie exist here (inisial dr Movie)
             movie = new Movie("Beauty & the beast");
            //todo 19 kita buat scripts br lagi disini
                Observable<Movie> movieObservable = Observable.defer(new Func0<Observable<Movie>>() {
                    @Override
                    public Observable<Movie> call() {
                        return Observable.just(movie);
                    }
                });
                //todo 22
                movie = new Movie("The lagend of aang");
                movieObservable.subscribe(new Subscriber<Movie>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Movie movie) {
                        //todo 23
                        Log.i("onNext", movie.name);

                    }
                });

            //todo 18 setelah smua scripts yg tlh kita buat di todo 16 (scripts dibawah ini) kita hilangkan scripts berikut
//            Observable<Movie> movieObservable = Observable.just(movie);
//            movie = new Movie("the lagend of aang");
//            movieObservable.subscribe(new Subscriber<Movie>() {
//                @Override
//                public void onCompleted() {
//
//                }
//
//                @Override
//                public void onError(Throwable e) {
//
//                }
//
//                @Override
//                public void onNext(Movie movie) {
//                    //todo 17
//                    Log.i("onNext",movie.name);
//                }
//            });

            }
        });

        //todo 24
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                demoObservableInterval();

            }
        });

        //todo 26
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                demoObservableCreate();
            }
        });
    }

    //hasil dari new method demoObservableCreate();
    private void demoObservableCreate() {
        //todo 27 implement method
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onNext(3);
                subscriber.onCompleted();

            }
            //todo 28
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                //todo 29
                Log.i("onNext", String.valueOf(integer));

            }
        });
    }

    //hasil dari new method demoObservableInterval();
    private void demoObservableInterval() {
        Observable.interval(2, TimeUnit.SECONDS).subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {
                //todo 25
                if (aLong == 15)
                    unsubscribe();
                Log.i("onNext",String.valueOf(aLong));

            }
        });
    }

    //todo 12 make a class here
    class Movie{
        public String name;

        //todo 13 generate (alt + ins)
        //this scripts from generate -> constructor
        public Movie(String name) {
            this.name = name;
        }

        //todo 14 generate again
        //this scripts from generate -> setter n getter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //hasil dr create newmethod demoObservableJust()
    private void demoObservableJust() {
        //todo 10
        Observable.just(1,2,3).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                //todo 11
                Log.i("onNext", String.valueOf(integer));

            }
        });
    }

    //hasil dr create newmethod demoObservableFrom()
    private void demoObservableFrom() {

        //Observable.fromArray(new Integer[]{1,2,3}).subscribe(new ) >> td pake yg ini trs gk bs trnyt mslhnya ada di librarynya sm di versi gradlenya trs aku samain persis kyk di tutorial youtubenya
        //kata tirun knp pas dibagian new gk muncul scripts yg kita pengen set secara lgsg (kyk scripts new O (lgsg muncul)) itu bs jd krn mslh di gradlenya
        //pas disamain persis (gradlenya) kyk ditutorial br bs deh ngikutin persis jalannya dr awal jd sama
        //todo 6 didalam method ini isi sm script dibawah ini
        //- array ini gk ditaro diats sblmnya tp lgsg taro dibawah ini
        Observable.from(new Integer[]{1,2,3}).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                //todo 7
                Log.i("onNext", String.valueOf(integer));

            }
        });
    }
}
