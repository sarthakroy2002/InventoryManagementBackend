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

import com.sarthak.inventorymgmt.entity.Customers;
import com.sarthak.inventorymgmt.repository.CustomersRepo;
import com.sarthak.inventorymgmt.service.impl.CustomersServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomersServiceImplTest {

    @Mock
    private CustomersRepo repo;

    @InjectMocks
    private CustomersServiceImpl service;

    @Test
    public void testSave() {
        Customers customers = new Customers();
        when(repo.save(customers)).thenReturn(customers);

        Customers saved = service.save(customers);
        assertThat(saved).isNotNull();
        verify(repo, times(1)).save(customers);
    }

    @Test
    public void testFindById() {
        Customers customers = new Customers();
        when(repo.findById(1L)).thenReturn(Optional.of(customers));

        Optional<Customers> found = service.findById(1L);
        assertThat(found).isPresent();
        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        Customers customers = new Customers();
        when(repo.findAll()).thenReturn(Arrays.asList(customers));

        List<Customers> all = service.findAll();
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
