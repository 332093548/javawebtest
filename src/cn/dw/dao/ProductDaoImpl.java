package cn.dw.dao;
import cn.dw.model.Product;

//操作数据库的前提创建一个Model
public class ProductDaoImpl extends BaseDaoImpl{

	// 应该通过创建一个Model(模型),完成对属性封装
	public int delete(int id) {
		String sql = "delete from product where id=?";
		return super.executeUpdate(sql, new Object[]{id});
	}

		// 应该通过创建一个Model(模型),完成对属性封装
	public int update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?";
		return super.executeUpdate(sql, 
			new Object[]{product.getName(),product.getPrice(),product.getRemark(),product.getId()});
		}

	// 应该通过创建一个Model(模型),完成对属性封装
	public int save(Product product) {
		String sql = "insert into product (name,price,remark) values (?,?,?);";
		return super.executeUpdate(sql, new Object[]{product.getName(),product.getPrice(),product.getRemark()});
	}
	
	public static void main(String[] args) {
		//new Date();//ctrl + 2 ==>L/F
		ProductDaoImpl daoImpl = new ProductDaoImpl();
		Product product = new Product();
		product.setName("xyz");
		product.setPrice(3.14);
		product.setRemark("test");
		daoImpl.save(product);
		// 进行删除测试
		//daoImpl.delete(1);
	}
}
