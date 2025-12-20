package sas.finalpo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sas.finalpo.dto.OrderDto;
import sas.finalpo.entity.Item;
import sas.finalpo.entity.Order;
import sas.finalpo.mapper.OrderMapper;
import sas.finalpo.repository.ItemRepo;
import sas.finalpo.repository.OrderRepo;


import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final ItemRepo itemRepo;
    private final OrderRepo repo;
    private final OrderMapper mapper;
    public OrderDto getById(Long id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public List<OrderDto> getAll() {
        return mapper.toDtoList(repo.findAll());
    }

    public OrderDto post(OrderDto orderDto) {
        return mapper.toDto(repo.save(mapper.toEntity(orderDto)));
    }

    public OrderDto put(Long id, OrderDto orderDto) {
        Order order = repo.findById(id).orElseThrow();
        order.setName(orderDto.getNameDto());
        order.setCode(orderDto.getCodeDto());
        return mapper.toDto(repo.save(order));
    }

    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public boolean connectItemsWithOrders(Long orderId, Long itemId) {
        if (repo.existsById(orderId) && itemRepo.existsById(itemId)) {
            Order order = repo.findById(orderId).orElseThrow();
            Item item = itemRepo.findById(itemId).orElseThrow();

            order.getItems().add(item);
            item.getOrders().add(order);

            repo.save(order);
            return true;
        } else {
            return false;
        }
    }

}