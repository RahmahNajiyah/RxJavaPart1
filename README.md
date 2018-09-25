# RxJavaPart1
learn about 5 methods of RxJava 1. From 2. Just 3. Defer 4. Interval 5. Create

Basic structure :
- observable released item
- subscriber use item.

one observable can create 0 or many item, after that, it will finish because of completion or due to
an error. for each subscriber it has, observable will call onNext() corresponding to the number of items it hsa
then calll onCompleted() or onError() int the result of the end.

How to create ?
Rxjava gives us 10 functions to create an observable, inthis tutorial i would like to mention only basic functions, partly because of limited knowledge, the other is to avoid tutorial becomes too long boring.
 
The function of each method Rx explanation 

1. observable.From() method
observable.from method take on an unlimited numer of parameter and can be of any type
(here we pass an array of 3 numbers (1,2,3) ).
observable.subscribe() method will create a subscriber with three onCompleted(), onError() and onNext() functions to use the items passed in a above ! 

2. Observable.just() method
Observable.just method takes on an unlimited number of parameters and can be of any type 
(here we pass 3 numbers (1,2,3) ).
observable.subscribe() method will create a subscriber with three onCompleted(), onError() and onNext() functions to use the items passed in a above ! 

>> the both result of 2 method above
the result of Just() is same with From() method !
But, what is different between From and Just ?
- From : when we pass into an array or list item, it will issue an array and list that item and the subscrier will also take the parameter as an array or list.
- Just : it will issue each item in the list (will call onNext times the size of the list in error condition don't available)

3. Observable.defer();
- Let see below codes
why it don't show "the lagend of aang" ? It is new data so we will want to show newest data
It show "Beauty and the beast" because this is value is created when just() method be called.
All other method will save value of item when observable is created, not when Observable is subscribe by one Subscriber.
In many case, we will want to our data is newest, so if we don't subscribe as soon as create then we have data is not newest so  what is solution for this case ? defer will help us
Now our problem is solved ! alhamdulillah

4. Observable.interval()
we will create task with call after 2 seconds and after 6 times it will finish!
Interval will be useful when we want to schedule update data.
Ex : update data after 2 seconds

5. Observable.create()
it give us result same to Observable.just(1,2,3)
Create() method also provides behavior as defer() - stores the value item when subscribe, not initialized however, in most cases you should not use this function because it has some rules that we must follow as only called Subscriber.onCompleted() or Subscriber.onError()
only once and are not call more function later

OK! in this tutorial we have learn about 5 methods of RxJava
1. From
2. Just
3. Defer
4. Interval
5. Create
