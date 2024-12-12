package com.example.redistut.service;

import com.example.redistut.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class ProductService {

    RestTemplate restTemplate;

    RedisService redisService;

    public ProductDTO getProduct(String id){
        String apiUrl = "https://fakestoreapi.com/products/" + id;
        ProductDTO productDTORedis = redisService.get(id, ProductDTO.class);
        if(productDTORedis!=null){
            System.out.println("Object of Redis Cache :- "+ productDTORedis);
            return productDTORedis;
        }else {
            ProductDTO productDTO = restTemplate.getForObject(apiUrl, ProductDTO.class);
            if(productDTO != null){
                System.out.println("Saving to Redis .....");
                redisService.set(id,productDTO,300L);
                System.out.println("Saved to Redis" + productDTO);
            }
            System.out.println("Object from Fake Store API :- "+productDTO);
            return productDTO;
        }
    }
}
