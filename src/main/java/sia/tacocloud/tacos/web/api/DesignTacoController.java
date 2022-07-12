//package sia.tacocloud.tacos.web.api;
//
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import sia.tacocloud.tacos.Taco;
//import sia.tacocloud.tacos.data.jpa.TacoRepository;
//
//import java.util.Optional;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//
////this is a REST api
//@RestController
//@RequestMapping(path = "/design")
//@CrossOrigin(origins = "*") //allows browsers to render response of cross-origin requests by including CORS headers in its response
//public class DesignTacoController {
//
//    private final TacoRepository tacoRepo;
//
//    public DesignTacoController(TacoRepository tacoRepo) {
//        this.tacoRepo = tacoRepo;
//    }
//
//    @GetMapping("/recent")
//    public CollectionModel<TacoResource> recentTacos() {
//        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
//        Iterable<Taco> tacos = tacoRepo.findAll(page).getContent();
//        CollectionModel<TacoResource> tacoResources = new TacoResourceAssembler().toCollectionModel(tacos);
//        return tacoResources.add(linkTo(methodOn(DesignTacoController.class).recentTacos())
//                            .withRel("recents"));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<TacoResource> tacoById(@PathVariable("id") Long id) {
//        Optional<Taco> optTaco = tacoRepo.findById(id);
//        if (optTaco.isPresent()) {
//            return new ResponseEntity<>(new TacoResourceAssembler().toModel(optTaco.get()), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Taco postTaco(@RequestBody Taco taco) { //@Valid isn't necessary.
//        return tacoRepo.save(taco);
//    }
//}