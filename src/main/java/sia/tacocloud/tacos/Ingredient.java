package sia.tacocloud.tacos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data //implicitly brings in @RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true) //jpa requires this; 'private' access-level as we don't intend using; via 'force' the fields are assigned nulls
@RequiredArgsConstructor
@Entity
public class Ingredient {

    @Id
    private final String id;

    private final String name;
    private final String type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
