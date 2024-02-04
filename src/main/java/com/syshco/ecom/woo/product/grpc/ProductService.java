package com.syshco.ecom.woo.product.grpc;


import com.google.protobuf.Empty;
import com.syshco.ecom.woo.gen.ProductId;
import com.syshco.ecom.woo.gen.ProductList;
import com.syshco.ecom.woo.gen.ProductServiceGrpc;
import com.syshco.ecom.woo.product.ProductMapper;
import com.syshco.ecom.woo.product.ProductRepository;
import com.syshco.ecom.woo.starter.GrpcService;
import com.syshco.ecom.woo.gen.Product;
import com.syshco.ecom.woo.product.ProductEntity;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@GrpcService
@RequiredArgsConstructor
public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void getAllProducts(Empty request, StreamObserver<ProductList> responseObserver) {
        List<Product> products = fetchProducts();
        ProductList productList = toProductList(products);
        responseObserver.onNext(productList);
        responseObserver.onCompleted();
    }

    @Override
    public void addProducts(ProductList products, StreamObserver<Empty> responseObserver) {
        List<ProductEntity> newProducts = toProductEntity(products);

        productRepository.saveAll(newProducts);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }


    @Override
    public void getByProductId(ProductId request, StreamObserver<Product> responseObserver) {
        Optional<ProductEntity> product = productRepository.findById(request.getProductId());
        if (product.isPresent()) {
            responseObserver.onNext(productMapper.toProduct(product.get()));

        } else {
            responseObserver.onError(new RuntimeException("No Product found with id " + request.getProductId()));
        }
        responseObserver.onCompleted();
    }

    private ProductList toProductList(List<Product> products) {
        return ProductList.newBuilder().addAllProducts(products).build();
    }

    private List<Product> fetchProducts() {
        return productRepository.findAll()
                .stream().map(productMapper::toProduct)
                .toList();
    }

    private List<ProductEntity> toProductEntity(ProductList products) {
        return products.getProductsList().stream().map(productMapper::toProductEntity)
                .peek(productEntity -> {
                    productEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
                    productEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                })
                .toList();
    }
}
