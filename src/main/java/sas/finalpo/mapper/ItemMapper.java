package sas.finalpo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sas.finalpo.dto.ItemDto;
import sas.finalpo.entity.Item;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    @Mapping(target="nameDto", source = "name")
    @Mapping(target="descriptionDto", source = "description")
    @Mapping(target="priceDto", source = "price")
    @Mapping(target="codeDto", source = "code")
    ItemDto toDto(Item item);

    @Mapping(target="name", source = "nameDto")
    @Mapping(target="description", source = "descriptionDto")
    @Mapping(target="price", source = "priceDto")
    @Mapping(target="code", source = "codeDto")
    @Mapping(target="category", ignore = true)
    @Mapping(target="orders", ignore = true)
    Item toEntity(ItemDto itemDto);

    List<ItemDto> toDtoList(List<Item> items);
    List<Item> toEntityList(List<ItemDto> itemDtos);





}
