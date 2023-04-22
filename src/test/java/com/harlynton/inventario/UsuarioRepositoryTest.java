package com.harlynton.inventario;

import com.harlynton.inventario.usuario.Rol;
import com.harlynton.inventario.usuario.Usuario;
import com.harlynton.inventario.usuario.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCrearRoles(){
        Rol rolAdmin = new Rol("Administrador");
        Rol rolEditor = new Rol("Editor");
        Rol rolVisitante = new Rol("Visitante");

        entityManager.persist(rolAdmin);
        entityManager.persist(rolEditor);
        entityManager.persist(rolVisitante);
    }

    @Test
    public void crearNuevoUsuarioConUnRol(){
        Rol rolAdmin = entityManager.find(Rol.class, 1);
        Usuario user = new Usuario("pepe@yopmail.com", "123456");

        user.addRol(rolAdmin);
        usuarioRepository.save(user);
    }
}
