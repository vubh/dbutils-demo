
# Common DbUtils 使用

> Commons DbUtils是Apache组织提供的一个对JDBC进行简单封装的开源工具类库，使用它能够简化JDBC应用程序的开发，同时也不会影响程序的性能。

## QueryRunner

## AsyncQueryRunner(异步查询)

## ResultSetHandler

1、BeanHandler(一个Bean) <==> BeanListHandler(多个Bean)

2、MapHandler(一个Map) <==> MapListHandler(返回多个Map)

3、ArrayHandler(一个数组) <==> ArrayListHandler(多个数组)

4、ScalarHandler(单列值) <==> ColumnListHandler(获取指定列的值)

5、BeanMapHandler返回Map(key, Bean) <==>  KeyedHandler返回Map(key, Map)
