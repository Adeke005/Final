package sas.finalpo.mapper;

import org.mapstruct.Mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sas.finalpo.dto.CategoryDto;
import sas.finalpo.entity.Category;


import java.util.List;


@Mapper(componentModel = "spring", uses = { ItemMapper.class })
public interface CategoryMapper {
    @Mapping(target = "nameDto", source = "name")
    CategoryDto toDto(Category category);

    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "items", ignore = true)
    Category toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDtoList(List<Category> categories);
    List<Category> toEntityList(List<CategoryDto> categoryDtos);
}
