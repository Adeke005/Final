package sas.finalpo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sas.finalpo.dto.CategoryDto;
import sas.finalpo.entity.Category;
import sas.finalpo.mapper.CategoryMapper;
import sas.finalpo.repository.CategoryRepo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock
    private CategoryRepo categoryRepo;

    @Mock
    private CategoryMapper categoryMapper;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getByIdTest() {
        Category cat = new Category();
        cat.setId(1L);
        CategoryDto dto = new CategoryDto();
        dto.setId(1L);

        when(categoryRepo.findById(1L)).thenReturn(Optional.of(cat));
        when(categoryMapper.toDto(cat)).thenReturn(dto);

        CategoryDto result = categoryService.getById(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    void getAllTest() {
        List<Category> cats = List.of(new Category(), new Category());
        List<CategoryDto> dtos = List.of(new CategoryDto(), new CategoryDto());

        when(categoryRepo.findAll()).thenReturn(cats);
        when(categoryMapper.toDtoList(cats)).thenReturn(dtos);

        List<CategoryDto> result = categoryService.getAll();
        assertEquals(2, result.size());
    }

    @Test
    void postTest() {
        CategoryDto dto = new CategoryDto();
        Category cat = new Category();

        when(categoryMapper.toEntity(dto)).thenReturn(cat);
        when(categoryRepo.save(cat)).thenReturn(cat);
        when(categoryMapper.toDto(cat)).thenReturn(dto);

        CategoryDto result = categoryService.post(dto);
        assertNotNull(result);
    }
}
