package sas.finalpo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sas.finalpo.dto.CategoryDto;


@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryApi {
    private final CategoryService service;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> post(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(service.post(categoryDto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id,@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(service.put(id,categoryDto),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
    @PutMapping("/{id}/items/{itemId}")
    public ResponseEntity<?> addItemsToCategory(@PathVariable Long id,@PathVariable Long itemId){
        return new ResponseEntity<>(service.addItemsToCategory(id,itemId),HttpStatus.OK);
    }
}
