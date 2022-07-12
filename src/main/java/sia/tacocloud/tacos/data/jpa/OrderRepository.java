package sia.tacocloud.tacos.data.jpa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.tacos.Order;
import sia.tacocloud.tacos.User;

import java.util.List;

//Observations: No @Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    //get by user and ordered in descending fashion(latest to oldest)
    //List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

    //return order where id is greater than parameter //works
    List<Order> findByIdGreaterThan(Long l); //should return all orders with id greater than param

    //return where id is >= to parameter //works
    List<Order> getByIdGreaterThanEqual(Long l); //inclusive of param

    //reverse of 1 above //works
    List<Order> readByIdLessThan(Long l); //should return opposite of 1

    //reverse of 2 above  //works
    List<Order> readByIdLessThanEqual(Long l); //should return opposite of 2

    //testing Between //works and is inclusive
    List<Order> getByIdBetween(Long lowerIdLimit, Long HigherIdLimit); //should return ids btw arg1 and arg2

    //testing isNotNUll //works
    List<Order> findByIdNotNull(); //returrn orders with nonnull ids

    //test startsWith //works/
    List<Order> findByDeliveryStateStartsWith(String initialOfDeliveryState);

    //testing endsWith  //works
    List<Order> readByDeliveryStateEndsWith(String endOfDeliveryState);

    //testing contains //works
    List<Order> getByDeliveryCityContains(String content);

    //testing like //works
    List<Order> findByDeliveryStateLike(String model);

    //testing isNotLike  //works
    List<Order> getByIdIsNotLike(Long id);

    //testing Equals //works
    List<Order> readByIdEquals(Long id);

    //testing ignoringCase //works
    List<Order> getByDeliveryNameIgnoringCase(String deliveryName);

    //testing orderBy //works
    List<Order> findByDeliveryStateOrderByDeliveryName(String deliveryState);
}