package sia.tacocloud.tacos.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.tacocloud.tacos.Ingredient;
import sia.tacocloud.tacos.data.jpa.IngredientRepository;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientRepository ingredientRepo;

    public IngredientController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }
    @GetMapping
    public Iterable<Ingredient> getIngredients() {
        return ingredientRepo.findAll();
    }

}
