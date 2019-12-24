import com.alibaba.fastjson.JSON;
import com.canon.base.run.Main;
import com.canon.model.platform.IdCenter;
import com.canon.model.platform.IdCenterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/9 16:30
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class ApplicationTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    IdCenterRepository idCenterRepository;

    @Test
    public void demo()  throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement = connection
                .prepareStatement("select * from t_idcenter where id ='1'");
        ResultSet resultSet = prepareStatement.executeQuery();
        //System.out.println(resultSet.getString("app"));

        while (resultSet.next()) {
            String propertiesName = resultSet.getString("app");
            System.out.println(propertiesName);
        }

    }

    @Test
    public void useJdbcTemplate() {
        List<IdCenter> query = jdbcTemplate.query("select * from t_idcenter where id ='1'", new BeanPropertyRowMapper<IdCenter>(IdCenter.class));
        System.err.println(JSON.toJSONString(query));
    }

    @Test
    public void useJPA() {
        Iterable<IdCenter> all = idCenterRepository.findAll();
        System.out.println(JSON.toJSONString(all));
    }

}
