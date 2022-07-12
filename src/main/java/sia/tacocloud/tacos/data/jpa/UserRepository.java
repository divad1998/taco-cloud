package sia.tacocloud.tacos.data.jpa;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.tacos.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
