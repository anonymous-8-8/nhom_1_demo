package edu.poly.test_qlda.controller;

import edu.poly.test_qlda.infrastructure.request.ProductRequest;

import edu.poly.test_qlda.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest request){
        String erro= productService.createProduct(request,null);
        return new ResponseEntity<>(erro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductRequest request , @PathVariable("id") Long id){
        String erro= productService.createProduct(request,id);
        return new ResponseEntity<>(erro, HttpStatus.CREATED);
    }
}


}

