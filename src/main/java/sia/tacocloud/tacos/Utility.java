package sia.tacocloud.tacos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {

        List<Ingredient> ingredientList = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getType().equalsIgnoreCase(type.name())) {
                ingredientList.add(ingredient);
            }

            File file = new File("text.txt"); //it is

        }
        return ingredientList;
    }
}
