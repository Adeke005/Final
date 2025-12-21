package sas.finalpo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sas.finalpo.dto.ItemDto;
import sas.finalpo.entity.Item;
import sas.finalpo.mapper.ItemMapper;
import sas.finalpo.repository.ItemRepo;
import sas.finalpo.repository.OrderRepo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceTest {

    @Mock
    private ItemRepo itemRepo;

    @Mock
    private ItemMapper itemMapper;

    @Mock
    private OrderRepo orderRepo;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getByIdTest() {
        Item item = Item.builder().id(1L).name("Phone").build();
        ItemDto dto = ItemDto.builder().id(1L).nameDto("Phone").build();

        when(itemRepo.findById(1L)).thenReturn(Optional.of(item));
        when(itemMapper.toDto(item)).thenReturn(dto);

        ItemDto result = itemService.getById(1L);

        assertEquals("Phone", result.getNameDto());
    }

    @Test
    void getAllTest() {
        List<Item> items = List.of(Item.builder().id(1L).name("A").build(),
                Item.builder().id(2L).name("B").build());
        List<ItemDto> dtos = List.of(ItemDto.builder().id(1L).nameDto("A").build(),
                ItemDto.builder().id(2L).nameDto("B").build());

        when(itemRepo.findAll()).thenReturn(items);
        when(itemMapper.toDtoList(items)).thenReturn(dtos);

        List<ItemDto> result = itemService.getAll();

        assertEquals(2, result.size());
    }

    @Test
    void postTest() {
        ItemDto dto = ItemDto.builder().nameDto("New").build();
        Item item = Item.builder().name("New").build();

        when(itemMapper.toEntity(dto)).thenReturn(item);
        when(itemRepo.save(item)).thenReturn(item);
        when(itemMapper.toDto(item)).thenReturn(dto);

        ItemDto result = itemService.post(dto);
        assertEquals("New", result.getNameDto());
    }

    @Test
    void deleteTestExists() {
        when(itemRepo.existsById(1L)).thenReturn(true);
        assertTrue(itemService.delete(1L));
        verify(itemRepo).deleteById(1L);
    }

    @Test
    void deleteTestNotExists() {
        when(itemRepo.existsById(1L)).thenReturn(false);
        assertFalse(itemService.delete(1L));
        verify(itemRepo, never()).deleteById(1L);
    }
}
