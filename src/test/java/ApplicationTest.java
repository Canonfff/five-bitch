import com.alibaba.fastjson.JSON;
import com.canon.base.dao.BaseMapper;
import com.canon.base.run.Main;
import com.canon.model.platform.IdCenter;
import com.canon.model.platform.User;
import com.canon.service.dao.IdCenterMapper;
import com.canon.service.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
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

//    @Resource
//    IIdCenterService iIdCenterService;

    @Resource
    IdCenterMapper idCenterMapper;


    @Autowired
    BaseMapper<IdCenter> baseMapper;
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
        Iterable<IdCenter> all = idCenterMapper.findAll(1L);
        System.out.println(JSON.toJSONString(all));
    }

    @Test
    public void findByBase() {
        IdCenter idCenter = baseMapper.selectById(1L);
        System.out.println(JSON.toJSONString(idCenter));
    }

    @Autowired
    UserDao userDao;

    @Test
    public void selectList() {
        List<User> users = userDao.selectList("canon");
        System.out.println(JSON.toJSONString(users));
    }

}
