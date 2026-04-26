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

import com.sarthak.inventorymgmt.entity.Products;
import com.sarthak.inventorymgmt.repository.ProductsRepo;
import com.sarthak.inventorymgmt.service.impl.ProductsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductsServiceImplTest {

    @Mock
    private ProductsRepo repo;

    @InjectMocks
    private ProductsServiceImpl service;

    @Test
    public void testSave() {
        Products products = new Products();
        when(repo.save(products)).thenReturn(products);

        Products saved = service.save(products);
        assertThat(saved).isNotNull();
        verify(repo, times(1)).save(products);
    }

    @Test
    public void testFindById() {
        Products products = new Products();
        when(repo.findById(1L)).thenReturn(Optional.of(products));

        Optional<Products> found = service.findById(1L);
        assertThat(found).isPresent();
        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        Products products = new Products();
        when(repo.findAll()).thenReturn(Arrays.asList(products));

        List<Products> all = service.findAll();
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
