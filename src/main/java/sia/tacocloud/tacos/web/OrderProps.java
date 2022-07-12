package sia.tacocloud.tacos.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//A config property holder bean
@Component
@ConfigurationProperties(prefix = "taco.orders")
@Data
@Validated
public class OrderProps {

    @Min(value = 5, message = "pageSize must be between 5 and 25")
    @Max(value = 25, message = "pageSize must be between 5 and 25")
    private int pageSize = 20;

}