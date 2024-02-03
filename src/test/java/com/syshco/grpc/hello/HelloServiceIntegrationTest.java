/*
package com.syshco.grpc.hello;

import com.syshco.grpc.gen.HelloRequest;
import com.syshco.grpc.gen.HelloResponse;
import com.syshco.grpc.gen.HelloServiceGrpc;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class HelloServiceIntegrationTest {

    @Autowired
    private HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

    @Test
    public void sayHello() {
        // Arrange
        String name = "Luffy";

        // Act
        HelloResponse response = blockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());

        // Assert
        assertEquals("Hello, World!", response.getName());
    }

}*/
