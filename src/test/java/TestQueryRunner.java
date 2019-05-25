import com.vubh.learn.core.BaseDao;
import com.vubh.learn.entity.UserEntity;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.math.BigInteger;

/**
 * QueryRunner增、删、改操作测试
 */
public class TestQueryRunner extends BaseDao {

    @Test
    public void insertUser() throws Exception {
        String sql = "insert into t_user(name,age,description)values(?,?,?)";

        int rows = queryRunner.update(sql,"test1", 10, "描述");
        System.out.println("影响行数：" + rows);

        BigInteger id = queryRunner.insert(sql, new ScalarHandler<>(), "test1", 10, "描述");
        System.out.println("返回的主键：" + id);
    }

    @Test
    public void batchInsertUser() throws Exception {
        String sql = "insert into t_user(name,age,description)values(?,?,?)";

        Object[][] users = new Object[][]{
                {"test1", 10, "描述"},
                {"test2", 10, "描述"}
        };
        int[] rows = queryRunner.batch(sql, users);
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void updateUser() throws Exception {
        String sql = "update t_user set name=?,age=?,description=? where id=?";
        int rows = queryRunner.update(sql, "test2", 25, "描述2", 4);
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void deleteUser() throws Exception {
        String sql = "delete from t_user where id=?";
        int rows = queryRunner.update(sql, 4);
        System.out.println("影响行数：" + rows);
    }
}
