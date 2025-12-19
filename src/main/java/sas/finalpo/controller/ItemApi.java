package sas.finalpo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sas.finalpo.dto.ItemDto;


@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemApi {
    private final ItemService service;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> post(@RequestBody ItemDto itemDto){
        return new ResponseEntity<>(service.post(itemDto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id,@RequestBody ItemDto itemDto){
        return new ResponseEntity<>(service.put(id,itemDto),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
    @PutMapping("/{id}/orders/{orderId}")
    public ResponseEntity<?> connectItemsWithOrders(@PathVariable Long id,@PathVariable Long orderId){
        return new ResponseEntity<>(service.connectItemsWithOrders(id,orderId),HttpStatus.OK);
    }
}