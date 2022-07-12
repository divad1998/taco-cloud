package sia.tacocloud.tacos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity //tags this as a jpa persistable
@Table(name = "Taco_Order")
public class Order {

    @Id
    @GeneratedValue //serial generation of id
    private Long id;

    @NotBlank(message = "Name is required.")
    private String deliveryName;

    @NotBlank(message = "Street is required.")
    private String deliveryStreet; //can also be a non-existent street

    @NotBlank(message = "City is required.")
    private String deliveryCity;

    @NotBlank(message = "State is required.")
    private String deliveryState; //

    @NotBlank(message = "Zip code is required.")
    private String deliveryZip; //

    @NotBlank(message = "Not a valid credit card number.")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/([2-9][0-9])$", message = "Date must be formatted as MM/YY")
    private String ccExpiration; //can be a date in the past

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV; //can be more than 3

    //order can hold list of taco designs
    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    private Date placedAt;

    //ToDo: uncomment this
//    @ManyToOne
//    private User user;

    public void addDesign(Taco design) {
        tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}