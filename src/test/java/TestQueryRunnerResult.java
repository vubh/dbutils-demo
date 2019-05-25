import com.vubh.learn.core.BaseDao;
import com.vubh.learn.entity.UserEntity;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * QueryRunner查询操作测试
 */
public class TestQueryRunnerResult extends BaseDao {

    /****************************************常用********************************************/
    /**
     * 单行单列
     *
     * @throws Exception
     */
    @Test
    public void testScalarHandler() throws Exception {
        String sql = "select count(id) from t_user";
        long count = queryRunner.query(sql, new ScalarHandler<>());
        System.out.println(count);
    }

    /**
     * 结果集转换成Bean
     *
     * @throws Exception
     */
    @Test
    public void testBeanHandler() throws Exception {
        String sql = "select id, name, age, description from t_user where id = ?";
        UserEntity user = queryRunner.query(sql, new BeanHandler<>(UserEntity.class), 4);
        System.out.println(user.toString());
    }

    /**
     * 结果集每一行数据转换成Bean放到List中
     *
     * @throws Exception
     */
    @Test
    public void testBeanListHandler() throws Exception {
        String sql = "select * from t_user";
        List<UserEntity> user = queryRunner.query(sql, new BeanListHandler<>(UserEntity.class));
        System.out.println(user.toString());
    }

    /**
     * 结果集转换成Map
     *
     * @throws Exception
     */
    @Test
    public void testMapHandler() throws Exception {
        String sql = "select id, name, age, description from t_user where id = ?";
        Map<String, Object> map = queryRunner.query(sql, new MapHandler(), 4);
        System.out.println(map.toString());
    }

    /**
     * 结果集每一行数据转换成Map放到List中
     *
     * @throws Exception
     */
    @Test
    public void testMapListHandler() throws Exception {
        String sql = "select * from t_user";
        List<Map<String, Object>> mapList = queryRunner.query(sql, new MapListHandler());
        System.out.println(mapList.toString());
    }


    /****************************************非常用********************************************/

    /**
     * 结果集转换成key->Bean
     * key默认为第一列
     *
     * @throws Exception
     */
    @Test
    public void testBeanMapHandler() throws Exception {
        String sql = "select * from t_user";
        Map<Object, UserEntity> map = queryRunner.query(sql, new BeanMapHandler<>(UserEntity.class));
        map.forEach((k, v) -> {
            System.out.println("key:" + k);
            System.out.println("value:" + v.toString());
        });
    }

    /**
     * 结果集转换成key->Map
     * key默认为第一列
     *
     * @throws Exception
     */
    @Test
    public void testKeyedHandler() throws Exception {
        String sql = "select * from t_user";
        Map<Object, Map<String, Object>> map = queryRunner.query(sql, new KeyedHandler<>());
        map.forEach((k, v) -> {
            System.out.println("key:" + k);
            System.out.println("value:" + v);
        });
    }


    /**
     * 结果集第一行数据转换成数组
     *
     * @throws Exception
     */
    @Test
    public void testArrayHandler() throws Exception {
        String sql = "select * from t_user";
        Object[] arr = queryRunner.query(sql, new ArrayHandler());
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 结果集每一行数据转换成数组放到List中
     *
     * @throws Exception
     */
    @Test
    public void testArrayListHandler() throws Exception {
        String sql = "select * from t_user";
        List<Object[]> list = queryRunner.query(sql, new ArrayListHandler());
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                System.out.print(list.get(i)[j] + ",");
            }
            System.out.println();
        }
    }

    /**
     * 结果集某一列数据放到List
     *
     * @throws Exception
     */
    @Test
    public void testColumnListHandler() throws Exception {
        String sql = "select * from t_user";
        List<String> list = queryRunner.query(sql, new ColumnListHandler<>("name"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
