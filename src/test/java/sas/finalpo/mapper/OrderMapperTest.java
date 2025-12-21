package sas.finalpo.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import sas.finalpo.dto.OrderDto;
import sas.finalpo.entity.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class OrderMapperTest {

    private final OrderMapper orderMapper =
            Mappers.getMapper(OrderMapper.class);

    @Test
    void convertEntityToDtoTest() {
        Order order = new Order(
                1L,
                "adil",
                "code",
                LocalDateTime.now(),
                new ArrayList<>()
        );

        OrderDto dtoOrder = orderMapper.toDto(order);

        Assertions.assertNotNull(dtoOrder);
        Assertions.assertEquals(order.getId(), dtoOrder.getId());
        Assertions.assertEquals(order.getName(), dtoOrder.getNameDto());
        Assertions.assertEquals(order.getCode(), dtoOrder.getCodeDto());
        Assertions.assertEquals(order.getCreatedAt(), dtoOrder.getCreatedAtDto());
    }

    @Test
    void convertDtoToEntityTest() {
        OrderDto orderDto = new OrderDto(
                1L,
                "adilet",
                "adik",
                LocalDateTime.now()
        );

        Order order = orderMapper.toEntity(orderDto);

        Assertions.assertNotNull(order);
        Assertions.assertEquals(orderDto.getId(), order.getId());
        Assertions.assertEquals(orderDto.getNameDto(), order.getName());
        Assertions.assertEquals(orderDto.getCodeDto(), order.getCode());
        Assertions.assertEquals(orderDto.getCreatedAtDto(), order.getCreatedAt());
    }

    @Test
    void convertListOrderToListOrderDtoTest() {

        List<Order> orderList = List.of(
                Order.builder()
                        .id(1L)
                        .name("asd")
                        .code("ass")
                        .createdAt(LocalDateTime.now())
                        .build(),
                Order.builder()
                        .id(2L)
                        .name("dfs")
                        .code("ass")
                        .createdAt(LocalDateTime.now())
                        .build(),
                Order.builder()
                        .id(3L)
                        .name("kfd0")
                        .code("alsl")
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        List<OrderDto> dtoList = orderMapper.toDtoList(orderList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(orderList.size(), dtoList.size());

        for (int i = 0; i < orderList.size(); i++) {
            Assertions.assertEquals(
                    orderList.get(i).getName(),
                    dtoList.get(i).getNameDto()
            );
        }
    }
}
