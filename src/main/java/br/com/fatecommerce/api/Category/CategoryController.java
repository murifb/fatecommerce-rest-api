package br.com.fatecommerce.api.Category;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecommerce.api.service.CategoryService;

@RestController
@RequestMapping(value = "/api/v1/category")
@CrossOrigin(value = "*")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getInfoCategories(){
        List<Category> result = categoryService.getInfoCategories();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> saveCategory(@RequestBody Category category){
        Category result = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    } 

}
