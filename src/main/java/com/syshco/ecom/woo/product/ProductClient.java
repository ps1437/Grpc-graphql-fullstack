package com.syshco.ecom.woo.product;

import com.google.protobuf.Empty;
import com.syshco.ecom.woo.gen.ProductList;
import com.syshco.ecom.woo.gen.ProductServiceGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @GrpcClient("products")
    private ProductServiceGrpc.ProductServiceBlockingStub productServiceBlockingStub;

    private final ProductMapper productMapper;

    public List<ProductDTO> getProducts() {
        ProductList products = productServiceBlockingStub.getProducts(Empty.getDefaultInstance());
        return products.getProductsList().stream()
                .map(productMapper::toProductDTO).toList();
    }
}
