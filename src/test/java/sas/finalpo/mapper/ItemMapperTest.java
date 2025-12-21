package sas.finalpo.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import sas.finalpo.dto.ItemDto;
import sas.finalpo.entity.Item;

import java.util.List;

class ItemMapperTest {

    private final ItemMapper itemMapper =
            Mappers.getMapper(ItemMapper.class);

    @Test
    void convertDtoToEntityTest() {
        ItemDto itemDto = ItemDto.builder()
                .id(1L)
                .nameDto("Adilet")
                .descriptionDto("strong")
                .priceDto(123)
                .codeDto("sss")
                .build();

        Item item = itemMapper.toEntity(itemDto);

        Assertions.assertNotNull(item);
        Assertions.assertEquals(itemDto.getId(), item.getId());
        Assertions.assertEquals(itemDto.getNameDto(), item.getName());
        Assertions.assertEquals(itemDto.getCodeDto(), item.getCode());
        Assertions.assertEquals(itemDto.getPriceDto(), item.getPrice());
        Assertions.assertEquals(itemDto.getDescriptionDto(), item.getDescription());

        Assertions.assertNull(item.getCategory());
        Assertions.assertTrue(item.getOrders() == null || item.getOrders().isEmpty());
    }

    @Test
    void convertEntityToDtoTest() {
        Item item = Item.builder()
                .id(5L)
                .name("Axe")
                .description("Chop chop")
                .price(300)
                .code("AXE1")
                .build();

        ItemDto itemDto = itemMapper.toDto(item);

        Assertions.assertNotNull(itemDto);

        Assertions.assertEquals(item.getId(), itemDto.getId());
        Assertions.assertEquals(item.getName(), itemDto.getNameDto());
        Assertions.assertEquals(item.getDescription(), itemDto.getDescriptionDto());
        Assertions.assertEquals(item.getPrice(), itemDto.getPriceDto());
        Assertions.assertEquals(item.getCode(), itemDto.getCodeDto());
    }

    @Test
    void convertListItemEntityToListItemDtoTest() {

        List<Item> itemList = List.of(
                Item.builder().id(1L).name("phone").price(200000).build(),
                Item.builder().id(2L).name("laptop").price(300000).build(),
                Item.builder().id(3L).name("watch").price(150000).build()
        );

        List<ItemDto> dtoList = itemMapper.toDtoList(itemList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(itemList.size(), dtoList.size());

        for (int i = 0; i < itemList.size(); i++) {
            Assertions.assertEquals(
                    itemList.get(i).getName(),
                    dtoList.get(i).getNameDto()
            );
        }
    }
}
