package com.app.controllers;

import com.app.model.CatalogItem;
import com.app.model.Category;
import com.app.model.Subcategory;
import com.app.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestCatalogController {
    @Autowired
    private AdminService adminService;

    @CrossOrigin
    @GetMapping("/getItems")
    public List<CatalogItem> getItems() {
        return adminService.getItems();
    }

    @CrossOrigin
    @GetMapping("/getItems/{id}")
    public List<CatalogItem> getItemsById(@PathVariable(value = "id") long id) {
        return adminService.getItemsById(id);
    }

    @CrossOrigin
    @GetMapping("/getCategories")
    public List<Category> getCategories() {
        return adminService.getCategories();
    }

    @CrossOrigin
    @GetMapping("/getSubcategories/{categoryId}")
    public List<Subcategory> getSubcategoriesByCategory(@PathVariable(value="categoryId") long categoryId) {
        // 404 custom page here as example
        return adminService.getSubcategories(categoryId);
    }
}
