package sas.finalpo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sas.finalpo.dto.ItemDto;
import sas.finalpo.entity.Item;
import sas.finalpo.entity.Order;
import sas.finalpo.mapper.ItemMapper;
import sas.finalpo.repository.ItemRepo;
import sas.finalpo.repository.OrderRepo;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepo repo;
    private final ItemMapper mapper;
    private final OrderRepo orderRepo;
    public ItemDto getById(Long id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public List<ItemDto> getAll() {
        return mapper.toDtoList(repo.findAll());
    }

    public ItemDto post(ItemDto itemDto) {
        return mapper.toDto(repo.save(mapper.toEntity(itemDto)));
    }

    public ItemDto put(Long id, ItemDto itemDto) {
        Item item = repo.findById(id).orElseThrow();
        item.setName(itemDto.getNameDto());
        item.setDescription(itemDto.getDescriptionDto());
        item.setCode(itemDto.getCodeDto());
        item.setPrice(itemDto.getPriceDto());
        return mapper.toDto(repo.save(item));
    }

    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public boolean connectItemsWithOrders(Long itemId, Long orderId) {
        if (repo.existsById(itemId) && orderRepo.existsById(orderId)) {
            Item item = repo.findById(itemId).orElseThrow();
            Order order = orderRepo.findById(orderId).orElseThrow();

            item.getOrders().add(order);
            order.getItems().add(item);

            repo.save(item);
            return true;
        } else {
            return false;
        }
    }
}