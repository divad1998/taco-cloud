package sia.tacocloud.tacos.data.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sia.tacocloud.tacos.Ingredient;

import java.util.Arrays;
import java.util.List;

@Component
public class PreloadIngredientData implements CommandLineRunner {

    private final IngredientRepository ingredientRepo;

    public PreloadIngredientData(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        //Instantiate 10 Ingredient objects
        List<Ingredient> ingredientList = Arrays.asList(
                                            new Ingredient("FLTO", "Flour Tortilla", "WRAP"),
                                            new Ingredient("COTO", "Corn Tortilla", "WRAP"),
                                            new Ingredient("GRBF", "Ground Beef", "PROTEIN"),
                                            new Ingredient("CARN", "Carnitas", "PROTEIN"),
                                            new Ingredient("TMTO", "Diced Tomatoes", "VEGGIES"),
                                            new Ingredient("LETC", "Lettuce", "VEGGIES"),
                                            new Ingredient("CHED", "Cheddar", "CHEESE"),
                                            new Ingredient("JACK", "Monterrey Jack", "CHEESE"),
                                            new Ingredient("SLSA", "Salsa", "SAUCE"),
                                            new Ingredient("SRCR", "Sour Cream", "SAUCE")
                );

        //persist all
        ingredientRepo.saveAll(ingredientList);
    }
}
