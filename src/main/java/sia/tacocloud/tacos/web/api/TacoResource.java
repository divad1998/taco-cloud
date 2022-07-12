package sia.tacocloud.tacos.web.api;

import lombok.Getter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import sia.tacocloud.tacos.Ingredient;
import sia.tacocloud.tacos.Taco;

import java.util.List;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoResource extends RepresentationModel<TacoResource> {

    @Getter
    private String name;
    @Getter
    private CollectionModel<IngredientResource> ingredients;

    private static final IngredientResourceAssembler ingredientResourceAssembler = new IngredientResourceAssembler();

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.ingredients = ingredientResourceAssembler.toCollectionModel(taco.getIngredients());
    }
}
