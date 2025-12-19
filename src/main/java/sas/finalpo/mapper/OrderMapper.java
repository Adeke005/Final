package sas.finalpo.mapper;

import jakarta.persistence.criteria.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sas.finalpo.dto.OrderDto;


import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target="nameDto", source = "name")
    @Mapping(target="codeDto", source = "code")
    @Mapping(target="createdAtDto", source = "createdAt")
    OrderDto toDto(Order order);

    @Mapping(target="name", source = "nameDto")
    @Mapping(target="code", source = "codeDto")
    @Mapping(target="createdAt", source = "createdAtDto")
    @Mapping(target="items", ignore = true)
    Order toEntity(OrderDto orderDto);

    List<OrderDto> toDtoList(List<Order> orders);
    List<Order> toEntityList(List<OrderDto> orderDtos);
}
