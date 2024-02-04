package com.syshco.grpc.product;

import com.syshco.grpc.gen.ProductList;
import com.syshco.grpc.gen.ProductServiceGrpc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServiceGrpc.ProductServiceBlockingStub serviceBlockingStub;

    @GetMapping
    public ProductList getAllProducts() {
        return serviceBlockingStub.getAllProducts(com.google.protobuf.Empty.getDefaultInstance());
    }
}
