//package sia.tacocloud.tacos.data;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//import sia.tacocloud.tacos.Ingredient;
//import sia.tacocloud.tacos.Taco;
//
//import java.sql.Timestamp;
//import java.sql.Types;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Repository
//public class JdbcTacoRepository implements TacoRepository {
//
//    private final SimpleJdbcInsert tacoInserter;
//    private final SimpleJdbcInsert ingredientInserter;
//
//    //no use of @Autowired
//    public JdbcTacoRepository(JdbcTemplate jdbc) {
//
//        this.tacoInserter = new SimpleJdbcInsert(jdbc)
//                                    .withTableName("Taco")
//                                    .usingGeneratedKeyColumns("id");
//
//        this.ingredientInserter = new SimpleJdbcInsert(jdbc).withTableName("Taco_Ingredients");
//    }
//
//    @Override
//    public Taco save(Taco taco) {
//        long tacoId = saveTacoInfo(taco);
//        taco.setId(tacoId);
//        for (String ingredientId : taco.getIngredients()) {
//            saveIngredientToTaco(ingredientId, tacoId);
//        }
//        return taco;
//    }
//
//    private long saveTacoInfo(Taco taco) {
//        taco.setCreatedAt(new Date());
//        Map<String, Object> insertData = new HashMap<>();
//        insertData.put("name", taco.getName());
//        insertData.put("createdAt", taco.getCreatedAt());
//
//        return tacoInserter
//                .executeAndReturnKey(insertData)
//                .longValue();
//    }
//
//    private void saveIngredientToTaco(String ingredientId, long tacoId) {
//        //set up map manually as Taco_Ingredients isn't a pojo
//        Map<String, Object> insertData = new HashMap<>();
//        insertData.put("taco", tacoId);
//        insertData.put("ingredient", ingredientId);
//        ingredientInserter.execute(insertData);
//    }
//}