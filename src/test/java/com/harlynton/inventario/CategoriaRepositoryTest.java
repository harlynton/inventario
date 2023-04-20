package com.harlynton.inventario;

import com.harlynton.inventario.categoria.Categoria;
import com.harlynton.inventario.categoria.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategoriaRepositoryTest {
    @Autowired
    private CategoriaRepository repositorio;

    @Test
    public void testCrearCategoria(){
        Categoria categoriaGuardada = repositorio.save(new Categoria("Electronicos"));
        assertThat(categoriaGuardada.getId()).isGreaterThan(0);
    }
}
