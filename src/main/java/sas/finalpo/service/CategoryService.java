package sas.finalpo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sas.finalpo.dto.CategoryDto;
import sas.finalpo.entity.Category;
import sas.finalpo.entity.Item;
import sas.finalpo.mapper.CategoryMapper;
import sas.finalpo.repository.CategoryRepo;
import sas.finalpo.repository.ItemRepo;


import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepo repo;
    private final CategoryMapper mapper;
    private final ItemRepo itemRepo;
    public CategoryDto getById(Long id){
        return mapper.toDto(repo.findById(id).orElseThrow());
    }
    public List<CategoryDto> getAll(){
        return mapper.toDtoList(repo.findAll());
    }
    public CategoryDto post(CategoryDto categoryDto){
        return mapper.toDto(repo.save(mapper.toEntity(categoryDto)));
    }
    public CategoryDto put(Long id, CategoryDto categoryDto){
        Category category = repo.findById(id).orElseThrow();
        category.setName(categoryDto.getNameDto());
        return mapper.toDto(repo.save(category));
    }
    public boolean delete(Long id){
        if (repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }public boolean addItemsToCategory(Long categoryId,Long itemId){
        if (repo.existsById(categoryId) && itemRepo.existsById(itemId)){
            Category category = repo.findById(categoryId).orElseThrow();
            Item item = itemRepo.findById(itemId).orElseThrow();
            category.getItems().add(item);
            item.setCategory(category);
            repo.save(category);
            return true;
        }else {
            return false;
        }
    }
}
