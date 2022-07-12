//package sia.tacocloud.tacos.data;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//import sia.tacocloud.tacos.Order;
//import sia.tacocloud.tacos.Taco;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class JdbcOrderRepository implements OrderRepository {
//    private final SimpleJdbcInsert orderInserter; //Why is this object not autowired? not A BEAN?
//    private final SimpleJdbcInsert orderTacoInserter;
//    private final ObjectMapper objectMapper; //autowired
//
//    public JdbcOrderRepository(JdbcTemplate jdbc) { //autowired
//        this.orderInserter = new SimpleJdbcInsert(jdbc) //due to the design
//                .withTableName("Taco_Order")
//                .usingGeneratedKeyColumns("id");
//
//        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
//                .withTableName("Taco_Order_Tacos");
//
//        this.objectMapper = new ObjectMapper(); //why not autowired?
//    }
//
//    @Override
//    public Order save(Order order) {
//        order.setPlacedAt(new Date());
//        long orderId = saveOrderDetails(order);
//        order.setId(orderId);
//        List<Taco> tacos = order.getTacos();
//        for (Taco taco : tacos) {
//            saveTacoToOrder(taco, orderId);
//        }
//        return order;
//    }
//
//    //persist Order
//    private long saveOrderDetails(Order order) {
//        @SuppressWarnings("unchecked") //this will be mapped effectively
//        Map<String, Object> values = objectMapper.convertValue(order, Map.class);
//        values.put("placedAt", order.getPlacedAt()); //because objectMapper maps placedAt to long type
//        long orderId = orderInserter
//                .executeAndReturnKey(values)
//                .longValue();
//        return orderId;
//    }
//
//    //persist order-associated Tacos
//    private void saveTacoToOrder(Taco taco, long orderId) {
//        Map<String, Object> values = new HashMap<>();
//        values.put("tacoOrder", orderId);
//        values.put("taco", taco.getId());
//        orderTacoInserter.execute(values);
//    }
//}
