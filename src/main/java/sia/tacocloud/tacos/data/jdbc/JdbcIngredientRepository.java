//package sia.tacocloud.tacos.data;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//import sia.tacocloud.tacos.Ingredient;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Repository
//public class JdbcIngredientRepository implements IngredientRepository {
//
//    private JdbcTemplate jdbc; //added as bean via autoconfiguration. Spring boot advantage.
//
//    @Autowired
//    public JdbcIngredientRepository(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    @Override
//    public Iterable<Ingredient> findAll() {
//        return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient); //a list is iterable as it can be accessed multiple times per access
//    }
//
//    @Override
//    public Ingredient findOne(String id) {
//        return jdbc.queryForObject("select id, name, id from Ingredient where id=?", this::mapRowToIngredient, id);
//    }
//
//    @Override
//    public Ingredient save(Ingredient ingredient) {
//        jdbc.update("insert into Ingredient (id, name, type) values (?, ?, ?)",
//                    ingredient.getId(),
//                    ingredient.getName(),
//                    ingredient.getType());
//
//        return ingredient;
//    }
//
//    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
//        return new Ingredient(
//                rs.getString("id"),
//                rs.getString("name"),
//                Ingredient.Type.valueOf(rs.getString("type"))
//        );
//    }
//}
