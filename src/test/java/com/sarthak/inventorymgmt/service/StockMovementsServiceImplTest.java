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

import com.sarthak.inventorymgmt.entity.StockMovements;
import com.sarthak.inventorymgmt.repository.StockMovementsRepo;
import com.sarthak.inventorymgmt.service.impl.StockMovementsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class StockMovementsServiceImplTest {

    @Mock
    private StockMovementsRepo repo;

    @InjectMocks
    private StockMovementsServiceImpl service;

    @Test
    public void testSave() {
        StockMovements stockMovements = new StockMovements();
        when(repo.save(stockMovements)).thenReturn(stockMovements);

        StockMovements saved = service.save(stockMovements);
        assertThat(saved).isNotNull();
        verify(repo, times(1)).save(stockMovements);
    }

    @Test
    public void testFindById() {
        StockMovements stockMovements = new StockMovements();
        when(repo.findById(1L)).thenReturn(Optional.of(stockMovements));

        Optional<StockMovements> found = service.findById(1L);
        assertThat(found).isPresent();
        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        StockMovements stockMovements = new StockMovements();
        when(repo.findAll()).thenReturn(Arrays.asList(stockMovements));

        List<StockMovements> all = service.findAll();
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
