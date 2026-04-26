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

import com.sarthak.inventorymgmt.entity.PurchaseItems;
import com.sarthak.inventorymgmt.repository.PurchaseItemsRepo;
import com.sarthak.inventorymgmt.service.impl.PurchaseItemsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PurchaseItemsServiceImplTest {

    @Mock
    private PurchaseItemsRepo repo;

    @InjectMocks
    private PurchaseItemsServiceImpl service;

    @Test
    public void testSave() {
        PurchaseItems purchaseItems = new PurchaseItems();
        when(repo.save(purchaseItems)).thenReturn(purchaseItems);

        PurchaseItems saved = service.save(purchaseItems);
        assertThat(saved).isNotNull();
        verify(repo, times(1)).save(purchaseItems);
    }

    @Test
    public void testFindById() {
        PurchaseItems purchaseItems = new PurchaseItems();
        when(repo.findById(1L)).thenReturn(Optional.of(purchaseItems));

        Optional<PurchaseItems> found = service.findById(1L);
        assertThat(found).isPresent();
        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        PurchaseItems purchaseItems = new PurchaseItems();
        when(repo.findAll()).thenReturn(Arrays.asList(purchaseItems));

        List<PurchaseItems> all = service.findAll();
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
