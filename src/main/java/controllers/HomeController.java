package controllers;

import list.CrudCategory;
import list.CrudProduct;
import models.Category;
import models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    CrudCategory crudCategory = new CrudCategory();
    CrudProduct crudProduct = new CrudProduct();

    @GetMapping("/home")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("Home");
        modelAndView.addObject("products", crudProduct.productList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("categories",crudCategory.categoryList);
        return modelAndView;
    }
    @PostMapping ("/create")
    public ModelAndView create(@RequestParam int id,@RequestParam String name,@RequestParam int price,@RequestParam String img,@RequestParam int categoryId,@RequestParam boolean status){
        Category category = null;
        for (int i = 0; i < crudCategory.categoryList.size(); i++) {
            if (categoryId == crudCategory.categoryList.get(i).getId()){
                category = crudCategory.categoryList.get(i);
            }
        }
        Product product = new Product(id,name,price,img,category,status);
        crudProduct.create(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }


    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        for (Product p : crudProduct.productList) {
            if (p.getId() == id) {
                model.addAttribute("product", p);
                break;
            }
        }
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("categories",crudCategory.categoryList);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@RequestParam int id,@RequestParam String name,@RequestParam int price,@RequestParam String img,@RequestParam int categoryId,@RequestParam boolean status) {
        Category category = null;
        for (int i = 0; i < crudCategory.categoryList.size(); i++) {
            if (categoryId == crudCategory.categoryList.get(i).getId()){
                category = crudCategory.categoryList.get(i);
            }
        }
        int index = -1;
        for (int i = 0; i < crudProduct.productList.size(); i++) {
            if (id == crudProduct.productList.get(i).getId()){
                index = crudProduct.productList.indexOf(crudProduct.productList.get(i));
            }
        }

        Product product = new Product(id,name,price,img,category,status);
        crudProduct.edit(product,index);

        return "redirect:/home";
    }

    @GetMapping("/Search")
    public String search(@RequestParam String search,Model model) {
        List<Product> findSearch = new ArrayList<>();
        for (Product p : crudProduct.productList) {
            if (p.getName().contains(search)) {
                findSearch.add(p);
            }
        }
        model.addAttribute("products", findSearch);
        return "Home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        for (Product p : crudProduct.productList) {
            if (p.getId() == id) {
                int index = crudProduct.productList.indexOf(p);
                crudProduct.productList.remove(index);
                break;
            }
        }
        return "redirect:/home";
    }
}
