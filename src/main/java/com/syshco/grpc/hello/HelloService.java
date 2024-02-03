package com.syshco.grpc.hello;

import com.syshco.grpc.gen.HelloRequest;
import com.syshco.grpc.gen.HelloResponse;
import com.syshco.grpc.gen.HelloServiceGrpc;
import com.syshco.grpc.starter.GrpcService;
import io.grpc.stub.StreamObserver;

import java.util.Calendar;


@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String sayHello = request.getName() + " " + getGreeting();
        HelloResponse hello = HelloResponse.newBuilder().setName(sayHello).build();
        responseObserver.onNext(hello);
        responseObserver.onCompleted();
    }

    public static String getGreeting() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 5 && hour < 12) {
            return "Good Morning!";
        } else if (hour >= 12 && hour < 18) {
            return "Good Afternoon!";
        } else {
            return "Good Night!";
        }
    }


}
