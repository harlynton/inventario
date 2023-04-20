package com.harlynton.inventario.producto;

import com.harlynton.inventario.categoria.Categoria;
import com.harlynton.inventario.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("productos/new")
    public String showNewProdForm(Model model){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("producto", new Producto());
        model.addAttribute("listaCategorias", listaCategorias);
        return "producto_form";
    }

    @PostMapping("/productos/save")
    public String guardarProducto(Producto producto){
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos")
    public String listaProductos(Model modelo){
        List<Producto> listaProductos = productoRepository.findAll();
        modelo.addAttribute("listaProductos", listaProductos);
        return "productos";
    }
}
