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

import com.sarthak.inventorymgmt.entity.SaleItems;
import com.sarthak.inventorymgmt.repository.SaleItemsRepo;
import com.sarthak.inventorymgmt.service.impl.SaleItemsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SaleItemsServiceImplTest {

    @Mock
    private SaleItemsRepo repo;

    @InjectMocks
    private SaleItemsServiceImpl service;

    @Test
    public void testSave() {
        SaleItems saleItems = new SaleItems();
        when(repo.save(saleItems)).thenReturn(saleItems);

        SaleItems saved = service.save(saleItems);
        assertThat(saved).isNotNull();
        verify(repo, times(1)).save(saleItems);
    }

    @Test
    public void testFindById() {
        SaleItems saleItems = new SaleItems();
        when(repo.findById(1L)).thenReturn(Optional.of(saleItems));

        Optional<SaleItems> found = service.findById(1L);
        assertThat(found).isPresent();
        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        SaleItems saleItems = new SaleItems();
        when(repo.findAll()).thenReturn(Arrays.asList(saleItems));

        List<SaleItems> all = service.findAll();
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
