package sia.tacocloud.tacos.web.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.web.client.RestTemplate;
import sia.tacocloud.tacos.Taco;

@Configuration
public class TacoResourceConfig {

    @Bean
    public RepresentationModelProcessor<PagedModel<Taco>> tacoProcessor(EntityLinks links) {

        return new RepresentationModelProcessor<PagedModel<Taco>>() {
            @Override
            public PagedModel<Taco> process(PagedModel<Taco> model) { //takes the returned HATEOAS type in the controller
                model.add(links.linkFor(Taco.class).slash("recent").withRel("recents"));

                return model;
            }
        };
    }
}
