package cn.dw.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.dw.model.Product;

// 通过spring来管理类与类之间的依赖(以前是通过代码的方式new,现在把所有依赖都配置在xml文件中,实现高内聚低耦合)
public class ProductDaoImpl {

	// 所有的Dao依赖Spring提供的JdbcTemplate,如果要赋值,必须要有Set方法(因为构造方法不灵活)
	private JdbcTemplate jdbcTemplate = null;
	
	public Product getById(int id) {
		String sql = "select * from product where id=?";
		// queryForObject: 查询并且返回一个对象
		// 直接通过接口创建的对象,称为匿名对象,此方式优点效率高.缺点是代码量大
//		return jdbcTemplate.queryForObject(sql, new RowMapper<Product>() {
//			@Override
//			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Product product = new Product();
//				product.setName(rs.getString("name"));
//				product.setPrice(rs.getDouble("price"));
//				return product;
//			}}, id);
		return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Product>(Product.class), id);
	}
	
	public List<Product> queryByName(String name,int page,int size){
		String sql = "select * from product where name like ? limit ?,?";
		//此处应该制定用来存储对象的类型
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), new Object[] {"%" + name + "%",(page - 1) * size, size});
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("setJdbcTemplate()........");
		this.jdbcTemplate = jdbcTemplate;
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int delete(int id) {
		String sql = "delete from product where id=?";
		return jdbcTemplate.update(sql, id);
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?";
		return jdbcTemplate.update(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}

}