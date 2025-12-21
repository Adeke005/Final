package sas.finalpo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sas.finalpo.dto.OrderDto;
import sas.finalpo.entity.Order;
import sas.finalpo.mapper.OrderMapper;
import sas.finalpo.repository.OrderRepo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepo orderRepo;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getByIdTest() {
        Order order = new Order();
        order.setId(1L);
        OrderDto dto = new OrderDto();
        dto.setId(1L);

        when(orderRepo.findById(1L)).thenReturn(Optional.of(order));
        when(orderMapper.toDto(order)).thenReturn(dto);

        OrderDto result = orderService.getById(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    void getAllTest() {
        List<Order> orders = List.of(new Order(), new Order());
        List<OrderDto> dtos = List.of(new OrderDto(), new OrderDto());

        when(orderRepo.findAll()).thenReturn(orders);
        when(orderMapper.toDtoList(orders)).thenReturn(dtos);

        List<OrderDto> result = orderService.getAll();
        assertEquals(2, result.size());
    }

    @Test
    void postTest() {
        OrderDto dto = new OrderDto();
        Order order = new Order();

        when(orderMapper.toEntity(dto)).thenReturn(order);
        when(orderRepo.save(order)).thenReturn(order);
        when(orderMapper.toDto(order)).thenReturn(dto);

        OrderDto result = orderService.post(dto);
        assertNotNull(result);
    }
}
