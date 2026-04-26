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

import com.sarthak.inventorymgmt.entity.Inventory;
import com.sarthak.inventorymgmt.repository.InventoryRepo;
import com.sarthak.inventorymgmt.service.impl.InventoryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceImplTest {

    @Mock
    private InventoryRepo repo;

    @InjectMocks
    private InventoryServiceImpl service;

    @Test
    public void testSave() {
        Inventory inventory = new Inventory();
        when(repo.save(inventory)).thenReturn(inventory);

        Inventory saved = service.save(inventory);
        assertThat(saved).isNotNull();
        verify(repo, times(1)).save(inventory);
    }

    @Test
    public void testFindById() {
        Inventory inventory = new Inventory();
        when(repo.findById(1L)).thenReturn(Optional.of(inventory));

        Optional<Inventory> found = service.findById(1L);
        assertThat(found).isPresent();
        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        Inventory inventory = new Inventory();
        when(repo.findAll()).thenReturn(Arrays.asList(inventory));

        List<Inventory> all = service.findAll();
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
