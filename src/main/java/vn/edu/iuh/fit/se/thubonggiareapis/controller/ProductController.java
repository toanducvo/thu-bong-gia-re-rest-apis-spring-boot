package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping(value = {"", "/"}, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    })
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO model) {
        try {
            ProductDTO result = productService.addProduct(model);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = {
            "", "/"
    })
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam(name = "id", required = false) Optional<List<Long>> ids) {
        try {
            if (ids.isPresent()) {
                List<ProductDTO> result = productService.getProductsByIds(ids.get());
                return result.size() > 0 ?  new ResponseEntity<>(productService.getProductsByIds(ids.get()), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            List<ProductDTO> products = productService.getProducts();
            if (products.size() == 0) {
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
            }
            return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        try {
            ProductDTO result = productService.getProductById(id);
            if (result == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
