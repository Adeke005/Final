package sas.finalpo.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sas.finalpo.dto.OrderDto;
import sas.finalpo.service.OrderService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderApi {
    private final OrderService service;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> post(@RequestBody OrderDto orderDto){
        return new ResponseEntity<>(service.post(orderDto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id,@RequestBody OrderDto orderDto){
        return new ResponseEntity<>(service.put(id,orderDto),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
    @PutMapping("/{id}/items/{itemId}")
    public ResponseEntity<?> connectItemsWithOrders(@PathVariable Long id,@PathVariable Long itemId){
        return new ResponseEntity<>(service.connectItemsWithOrders(id,itemId),HttpStatus.OK);
    }
}