package com.example.redistut.controller;

import com.example.redistut.dto.ProductDTO;
import com.example.redistut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class ControllerClass {

    @Autowired
    ProductService productService;

    @GetMapping("/get-product/{id}")
    public ProductDTO getProduct(@PathVariable("id") String id){
        ProductDTO productDTO = productService.getProduct(id);
        return productDTO;
    }
}
