package product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import product.model.Product;
import product.service.IProduct;
import product.service.impl.ProductService;

import javax.jws.WebParam;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ProductController {
    IProduct iProduct = new ProductService();


    // find by all
    @GetMapping(value = {"","/product/list"})
    public String index(Model model){
        List<Product> productList = iProduct.findAll();
        model.addAttribute("productList", productList);
        return "/list";
    }


    // create product
    @GetMapping(value = "/product/create")
    public String create(Model model){
        model.addAttribute("product" , new Product());
        return "/create";
    }

    @PostMapping(value = "/product/save")
    public String save(@RequestParam(name = "idProduct") int id,
                       @RequestParam(name = "name") String name,
                       @RequestParam(name = "price") double price){
        Product product = new Product(id, name, price);
        iProduct.save(product);
        return "/save";
    }


    // edit product
    @GetMapping(value = "/product/{id}/edit")
    public String edit(@PathVariable(name = "id") int idProduct,
                       Model model){
        model.addAttribute("product",iProduct.findById(idProduct));
        return "/edit";
    }

    @PostMapping(value = "/product/update")
    public String update(Product product){
        iProduct.update(product.getId(), product);
        return "/update";
    }


    // delete product
    @PostMapping(value = "/{id}/delete")
    public String delete(@PathVariable(name = "id") int idProduct){
        iProduct.remove(idProduct);
        return "delete";
    }

    // view product
    @GetMapping(value = "/{id}/view")
    public String view(@PathVariable(name = "id") int idProduct,
            Model model){
        model.addAttribute("product", iProduct.findById(idProduct));
        return "/view";
    }

    // find by name
    @PostMapping(value = "/findByName")
    public String findByName(@RequestParam(name = "findByName") String name,
                             Model model){
        model.addAttribute("productList", iProduct.findByName(name));
        return "/list";
    }
}
