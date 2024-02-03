/*
package com.syshco.grpc.hello;

import static org.junit.jupiter.api.Assertions.*;

import com.syshco.grpc.gen.HelloRequest;
import com.syshco.grpc.gen.HelloResponse;
import com.syshco.grpc.gen.HelloServiceGrpc;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

class HelloServiceTest {


    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

    @Test
    public void sayHello() throws Exception {
        String name = "Luffy";
        HelloService service = new HelloService();
        String serverName = InProcessServerBuilder.generateName();

        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName)
                .directExecutor()
                .addService(service)
                .build()
                .start());

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(
                grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

        HelloResponse response = stub.sayHello(HelloRequest.newBuilder().setName(name).build());

        assertEquals("Luffy Good Night!", response.getName());
    }

}*/
