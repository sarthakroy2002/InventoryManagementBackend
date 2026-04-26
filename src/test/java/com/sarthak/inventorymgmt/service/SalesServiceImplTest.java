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

import com.sarthak.inventorymgmt.entity.Sales;
import com.sarthak.inventorymgmt.repository.SalesRepo;
import com.sarthak.inventorymgmt.service.impl.SalesServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SalesServiceImplTest {

    @Mock
    private SalesRepo repo;

    @InjectMocks
    private SalesServiceImpl service;

    @Test
    public void testSave() {
        Sales sales = new Sales();
        when(repo.save(sales)).thenReturn(sales);

        Sales saved = service.save(sales);
        assertThat(saved).isNotNull();
        verify(repo, times(1)).save(sales);
    }

    @Test
    public void testFindById() {
        Sales sales = new Sales();
        when(repo.findById(1L)).thenReturn(Optional.of(sales));

        Optional<Sales> found = service.findById(1L);
        assertThat(found).isPresent();
        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        Sales sales = new Sales();
        when(repo.findAll()).thenReturn(Arrays.asList(sales));

        List<Sales> all = service.findAll();
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
