package com.syshco.ecom.woo.product;

import com.syshco.ecom.woo.gen.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "createdAt", expression = "java( mapTimestamp(productEntity.getCreatedAt()) )")
    @Mapping(target = "updatedAt", expression = "java( mapTimestamp(productEntity.getUpdatedAt()) )")
    Product toProduct(ProductEntity productEntity);

    @InheritInverseConfiguration
    @Mapping(target = "createdAt", expression = "java( mapProtobufTimestampToSqlTimestamp(product.getCreatedAt()) )")
    @Mapping(target = "updatedAt", expression = "java( mapProtobufTimestampToSqlTimestamp(product.getUpdatedAt()) )")
    ProductEntity toProductEntity(Product product);

    default com.google.protobuf.Timestamp mapTimestamp(Timestamp timestamp) {
        if (timestamp != null) {
            long seconds = timestamp.getTime() / 1000;
            int nanos = (int) ((timestamp.getTime() % 1000) * 1_000_000);

            return com.google.protobuf.Timestamp.newBuilder()
                    .setSeconds(seconds)
                    .setNanos(nanos)
                    .build();
        }
        return null;
    }

    default Timestamp mapProtobufTimestampToSqlTimestamp(com.google.protobuf.Timestamp protobufTimestamp) {
        if (protobufTimestamp != null) {
            long millis = protobufTimestamp.getSeconds() * 1000 + protobufTimestamp.getNanos() / 1_000_000;
            return new Timestamp(millis);
        }
        return null;
    }

}
