package com.harlynton.inventario.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepo;

    @GetMapping("/categorias")
    public String listaCategorias(Model model){
        List<Categoria> listaCategorias = categoriaRepo.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return "categorias";
    }

    @GetMapping("/categorias/new")
    public String showNewCatForm(Model model){
        model.addAttribute("categoria", new Categoria());
        return "categoria_form";
    }

    @PostMapping("/categorias/save")
    public String saveCategoria(Categoria categoria){
        categoriaRepo.save(categoria);
        return "redirect:/categorias";
    }

}
