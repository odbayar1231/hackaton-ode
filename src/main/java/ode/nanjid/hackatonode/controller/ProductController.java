package ode.nanjid.hackatonode.controller;

import ode.nanjid.hackatonode.model.Product;
import ode.nanjid.hackatonode.model.Supplier;
import ode.nanjid.hackatonode.service.ProductService;
import ode.nanjid.hackatonode.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/srm4gdm/product"})
public class ProductController {

    private ProductService productService;
    private SupplierService supplierService;

    @Autowired
    public ProductController(ProductService productService, SupplierService supplierService) {
        this.productService = productService;
        this.supplierService = supplierService;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView listProducts() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.getAllProducts();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("product/list");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public String displayNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "product/new";
    }

    @PostMapping(value = {"/new"})
    public String addNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Supplier> suppliers = supplierService.getAllSuppliers();
            model.addAttribute("suppliers", suppliers);
            model.addAttribute("product", product);
            return "product/new";
        }
        productService.saveProduct(product);
        return "redirect:/srm4gdm/product/list";
    }

    @GetMapping(value = {"/edit/{productId}"})
    public String displayEditProductForm(@PathVariable Long productId, Model model) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            model.addAttribute("product", product);
            List<Supplier> suppliers = supplierService.getAllSuppliers();
            model.addAttribute("suppliers", suppliers);
            model.addAttribute("product", product);
            return "product/edit";
        }
        return "product/list";
    }

    @PostMapping(value = {"/update"})
    public String updateEditedProduct(@Valid @ModelAttribute("product")Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

        }

    }
}

