package sas.finalpo.mapper;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import sas.finalpo.dto.CategoryDto;
import sas.finalpo.entity.Category;

import java.util.ArrayList;
import java.util.List;

class CategoryMapperTest {

    private final CategoryMapper categoryMapper =
            Mappers.getMapper(CategoryMapper.class);

    @Test
    void convertEntityToDtoTest() {
        Category entityCategory =
                new Category(1L, "adeke", new ArrayList<>());

        CategoryDto dtoCategory = categoryMapper.toDto(entityCategory);

        Assertions.assertNotNull(dtoCategory);
        Assertions.assertEquals(entityCategory.getId(), dtoCategory.getId());
        Assertions.assertEquals(entityCategory.getName(), dtoCategory.getNameDto());
    }

    @Test
    void convertDtoToEntityTest() {
        CategoryDto dtoCategory = new CategoryDto(1L, "asd");

        Category entityCategory = categoryMapper.toEntity(dtoCategory);

        Assertions.assertNotNull(entityCategory);
        Assertions.assertEquals(dtoCategory.getId(), entityCategory.getId());
        Assertions.assertEquals(dtoCategory.getNameDto(), entityCategory.getName());
    }

    @Test
    void convertListTest() {
        List<Category> categories = List.of(
                new Category(1L, "A", new ArrayList<>()),
                new Category(2L, "B", new ArrayList<>())
        );

        List<CategoryDto> dtoList = categoryMapper.toDtoList(categories);

        Assertions.assertEquals(categories.size(), dtoList.size());
    }
}

