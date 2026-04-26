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

import com.sarthak.inventorymgmt.entity.Suppliers;
import com.sarthak.inventorymgmt.repository.SuppliersRepo;
import com.sarthak.inventorymgmt.service.impl.SuppliersServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SuppliersServiceImplTest {

    @Mock
    private SuppliersRepo repo;

    @InjectMocks
    private SuppliersServiceImpl service;

    @Test
    public void testSave() {
        Suppliers suppliers = new Suppliers();
        when(repo.save(suppliers)).thenReturn(suppliers);

        Suppliers saved = service.save(suppliers);
        assertThat(saved).isNotNull();
        verify(repo, times(1)).save(suppliers);
    }

    @Test
    public void testFindById() {
        Suppliers suppliers = new Suppliers();
        when(repo.findById(1L)).thenReturn(Optional.of(suppliers));

        Optional<Suppliers> found = service.findById(1L);
        assertThat(found).isPresent();
        verify(repo, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        Suppliers suppliers = new Suppliers();
        when(repo.findAll()).thenReturn(Arrays.asList(suppliers));

        List<Suppliers> all = service.findAll();
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
