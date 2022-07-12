package sia.tacocloud.tacos.data.jpa;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import sia.tacocloud.tacos.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {
}