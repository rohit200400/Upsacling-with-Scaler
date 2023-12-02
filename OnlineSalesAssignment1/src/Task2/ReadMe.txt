Task2 { Expression Evaluator }

I have used a coin bucket type rate limiter to limit the request per second by each client.

The application contains a concurrent queue where client dumps their expressions which needs to be evaluated.
There is a concurrent hashmap which stores the client id and their token bucket.
I have used this rate limiter because it is easy to implement and simple but effective as per the required constrains.

The evaluateExpressions() method runs continuously and keeps checking if there is any expression in queue to process.
If any expression found it checks with the corresponding client bucket for token,
    if token is available then it calls the api method and submits the request.
    else it takes request and adds it to the end of the queue.

The Api takes input in JSON form and returns in JSON form.

The expression evaluator takes two input one is the client rate limit of sending request and other is the URL.

I have used virtual threads so that large volume of requests could be handled. As virtual threads are light weight and disposable.

To run the code you need to install java 21 and then run the task2 file. The file contains all the testcases.

I have tested the code against large data set. This tests are there in the main class.
Improvements :
> Currently the queue follows FIFO so if first 100 request is from client1 then it will send 50 request
    and then pprocess the next 50 and put them in the end of the queue.
    This could be avoided by using a sequenced map of client and list of request.
    We can directly move to next client in this case if current clients bucket is empty.

> We can use an adaptor design pattern instead of directly connecting to the API.

> We could use Data transfer objects (DTO) for sending and receiving data to API.