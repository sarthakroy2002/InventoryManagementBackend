package com.sarthak.inventorymgmt.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sarthak.inventorymgmt.entity.Categories;
import com.sarthak.inventorymgmt.repository.CategoriesRepo;
import com.sarthak.inventorymgmt.service.impl.CategoriesServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CategoriesServiceImplTest {

    @Mock
    private CategoriesRepo repo;

    @InjectMocks
    private CategoriesServiceImpl service;

    @Test
    public void testSave() {
        Categories categories = new Categories();
        when(repo.save(categories)).thenReturn(categories);

        Categories saved = service.save(categories);
        assertThat(saved).isNotNull();
        verify(repo, times(1)).save(categories);
    }

    @Test
    public void testFindById() {
        Categories categories = new Categories();
        when(repo.findById(1L)).thenReturn(Optional.of(categories));

        Optional<Categories> found = service.findById(1L);
        assertThat(found).isPresent();
        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        Categories categories = new Categories();
        when(repo.findAll()).thenReturn(Arrays.asList(categories));

        List<Categories> all = service.findAll();
        assertThat(all).hasSize(1);
        verify(repo, times(1)).findAll();
    }

    @Test
    public void testDeleteById() {
        doNothing().when(repo).deleteById(1L);
        service.deleteById(1L);
        verify(repo, times(1)).deleteById(1L);
    }
}
