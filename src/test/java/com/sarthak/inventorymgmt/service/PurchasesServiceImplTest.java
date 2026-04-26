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

import com.sarthak.inventorymgmt.entity.Purchases;
import com.sarthak.inventorymgmt.repository.PurchasesRepo;
import com.sarthak.inventorymgmt.service.impl.PurchasesServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PurchasesServiceImplTest {

    @Mock
    private PurchasesRepo repo;

    @InjectMocks
    private PurchasesServiceImpl service;

    @Test
    public void testSave() {
        Purchases purchases = new Purchases();
        when(repo.save(purchases)).thenReturn(purchases);

        Purchases saved = service.save(purchases);
        assertThat(saved).isNotNull();
        verify(repo, times(1)).save(purchases);
    }

    @Test
    public void testFindById() {
        Purchases purchases = new Purchases();
        when(repo.findById(1L)).thenReturn(Optional.of(purchases));

        Optional<Purchases> found = service.findById(1L);
        assertThat(found).isPresent();
        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        Purchases purchases = new Purchases();
        when(repo.findAll()).thenReturn(Arrays.asList(purchases));

        List<Purchases> all = service.findAll();
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
