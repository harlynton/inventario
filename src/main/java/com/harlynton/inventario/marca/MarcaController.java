package com.harlynton.inventario.marca;

import com.harlynton.inventario.categoria.Categoria;
import com.harlynton.inventario.categoria.CategoriaRepository;
import com.harlynton.inventario.producto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepo;

    @Autowired
    private CategoriaRepository categoriaRepo;

    @GetMapping("/marcas")
    public String listaMarcas(Model model){
        List<Marca> listaMarcas = marcaRepo.findAll();
        model.addAttribute("listaMarcas", listaMarcas);
        return "marcas";
    }

    @GetMapping("/marcas/new")
    public String showNewMarcaForm(Model model){
        List<Categoria> listaCategorias = categoriaRepo.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        model.addAttribute("marca",new Marca());

        return "marca_form";
    }

    @PostMapping("marcas/save")
    public String saveMarca(Marca marca){
        marcaRepo.save(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/marcas/edit/{id}")
    public String showUpdateMarcaForm(@PathVariable("id") Integer id, Model model){
        List<Categoria> listaCategorias = categoriaRepo.findAll();
        Marca marca = marcaRepo.findById(id).get();

        model.addAttribute("listaCategorias", listaCategorias);
        model.addAttribute("marca", marca);

        return "marca_form";
    }

    @GetMapping("/marcas/delete/{id}")
    public String deleteMarca(@PathVariable("id") Integer id, Model model){
        marcaRepo.deleteById(id);
        return "redirect:/marcas";
    }

}
