package com.sarthak.inventorymgmt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sarthak.inventorymgmt.entity.Categories;

@SpringBootTest
public class CategoriesRepoTest {

    @Autowired
    private CategoriesRepo categoriesRepo;

    @Test
    public void testSaveAndFind() {
        Categories category = new Categories();
        category.setName("Test Category");
        category.setDescription("Test Description");

        Categories savedCategory = categoriesRepo.save(category);
        assertThat(savedCategory.getId()).isNotNull();

        Optional<Categories> found = categoriesRepo.findById(savedCategory.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Test Category");
    }

    @Test
    public void testSoftDelete() {
        Categories category = new Categories();
        category.setName("Delete Test Category");
        Categories savedCategory = categoriesRepo.save(category);
        Long id = savedCategory.getId();

        categoriesRepo.deleteById(id);

        // After deleteById, the repository (which has @SQLRestriction("active_flag = 'Y'"))
        // should no longer return it.
        Optional<Categories> found = categoriesRepo.findById(id);
        assertThat(found).isEmpty();
        
        List<Categories> allCategories = categoriesRepo.findAll();
        assertThat(allCategories).extracting(Categories::getId).doesNotContain(id);
    }
}
