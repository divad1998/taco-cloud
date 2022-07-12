//package sia.tacocloud.tacos.web;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//import org.thymeleaf.engine.TemplateManager;
//import org.thymeleaf.exceptions.TemplateInputException;
//import sia.tacocloud.tacos.Ingredient;
//import sia.tacocloud.tacos.Order;
//import sia.tacocloud.tacos.Taco;
//import sia.tacocloud.tacos.data.jpa.IngredientRepository;
//import sia.tacocloud.tacos.data.jpa.TacoRepository;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//
//import static sia.tacocloud.tacos.Utility.filterByType;
//
//@Slf4j
//@Controller
//@RequestMapping(value = "/design")
//@SessionAttributes("order")
//public class DesignTacoController {
//
//    private final IngredientRepository ingredientRepository;
//    private final TacoRepository designRepo;
//
//    @Autowired //AppContext, please inject an implementation of this interface
//    public DesignTacoController(IngredientRepository ingredientRepository,
//                                TacoRepository designRepo) {
//        this.ingredientRepository = ingredientRepository;
//        this.designRepo = designRepo;
//    }
//
//    @ModelAttribute(name = "order")
//    public Order order() {
//        return new Order();
//    }
//
//    @ModelAttribute(name = "design")
//    public Taco taco() {
//        return new Taco();
//    }
//
//    @GetMapping
//    public String showDesignForm(Model model) { //request is processed within
//        List<Ingredient> ingredients = new ArrayList<>();
//        //add all ingredients to the above list
//        ingredientRepository.findAll().forEach(ingredients::add);
//        //sort and group ingredients according to type
//        Ingredient.Type[] types = Ingredient.Type.values();
//        for (Ingredient.Type type : types) {
//            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type)); //align ingredient type and ingredient
//        }
//
//        return "design";
//    }
//
//    @PostMapping //POST here
//    public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order) {
//
//        if (errors.hasErrors()) {
//            return "design";
//        }
//
//        Taco saved = designRepo.save(design); //here
//        order.addDesign(saved);
//
//        return "redirect:/orders/current";
//    }
//}
