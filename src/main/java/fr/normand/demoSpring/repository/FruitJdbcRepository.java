package fr.normand.demoSpring.repository;

import fr.normand.demoSpring.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class FruitJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Fruit> getAll() {
        String sql = "SELECT ID, NAME FROM fruit";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        List<Fruit> fruits = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            Long fruitId = ((Number) row.get("ID")).longValue();
            String fruitName = (String) row.get("NAME");
            Fruit fruit = new Fruit(fruitId, fruitName);
            fruits.add(fruit);
        }

        return fruits;
    }


    public Fruit getById(Long id) {
        String sql = "SELECT ID, NAME FROM fruit WHERE ID = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);

        if (rows.isEmpty()) {
            return null;
        } else {
            Map<String, Object> row = rows.get(0);
            Long fruitId = ((Number) row.get("ID")).longValue();
            String fruitName = (String) row.get("NAME");
            Fruit fruit = new Fruit(fruitId, fruitName);
            return fruit;
        }
    }
    public Fruit create(String name) {
        String sql = "INSERT INTO fruit (name) VALUES (?)";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            return ps;
        }, holder);

        Long fruitId = holder.getKey().longValue();
        return new Fruit(fruitId, name);
    }
    public void delete(Long id) {
            String sql = "DELETE FROM fruit WHERE id = ?";
            jdbcTemplate.update(sql, id);
        }
    public void update(Long id) {
        String sql = "DELETE FROM fruit WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
