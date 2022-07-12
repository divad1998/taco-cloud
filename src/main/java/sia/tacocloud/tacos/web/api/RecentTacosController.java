package sia.tacocloud.tacos.web.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import sia.tacocloud.tacos.Taco;
import sia.tacocloud.tacos.data.jpa.TacoRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController //a stereotype annotation, also providing data rest base url but not writing response to body
public class RecentTacosController {

    private final TacoRepository tacoRepo;

    public RecentTacosController(TacoRepository tacoRepo) { //Instantiated in app context and passed by ref to this constructor
        this.tacoRepo = tacoRepo;
    }

    @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
    public ResponseEntity<CollectionModel<TacoResource>> recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        Iterable<Taco> tacos = tacoRepo.findAll(page).getContent();
        CollectionModel<TacoResource> tacoResources = new TacoResourceAssembler().toCollectionModel(tacos);
        tacoResources.add(linkTo(methodOn(RecentTacosController.class).recentTacos()).withRel("recents")); //this is wrong!

        return new ResponseEntity<>(tacoResources, HttpStatus.OK);
    }
}
