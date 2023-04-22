package com.harlynton.inventario.usuario;

import com.harlynton.inventario.categoria.Categoria;
import com.harlynton.inventario.producto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/usuarios")
    public String listaUsuarios(Model modelo){
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        modelo.addAttribute("listaUsuarios", listaUsuarios);

        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String showNewUsuarioForm(Model modelo){
        List<Rol> listaRoles = rolRepository.findAll();

        modelo.addAttribute("listaRoles", listaRoles);
        modelo.addAttribute("usuario", new Usuario());

        return "usuario_form";
    }

    @PostMapping("/usuarios/save")
    public String guardarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/edit/{id}")
    public String showUpdateUsuarioForm(@PathVariable("id") Integer id, Model model){
        Usuario usuario = usuarioRepository.findById(id).get();
        model.addAttribute("usuario", usuario);

        List<Rol> listaRoles = rolRepository.findAll();
        model.addAttribute("listaRoles", listaRoles);

        return "usuario_form";
    }

    @GetMapping("/usuarios/delete/{id}")
    public String deleteUsuario(@PathVariable("id") Integer id, Model model){
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }


}
