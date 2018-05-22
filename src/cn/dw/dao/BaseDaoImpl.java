package cn.dw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.dw.utils.JdbcUtils;

//编写一个操作数据库的父类，此类用来编写公共的功能，共性代码抽取
public class BaseDaoImpl {
	//1、编写一个方法，实现save,update,delete的功能，此方法仅交给子类调用
	//2、共性代码，父类实现，个性代码，通过子类传入
	protected int executeUpdate(String sql,Object[] params) {

		//操作数据库的4个步骤
		//1、获取数据库的连接
		Connection connection = null;
		PreparedStatement pre =null;
		try {
			connection = JdbcUtils.getConnection();//crtl + 2 ==>L
			//2、配置参数，并且执行SQL
			pre = connection.prepareStatement(sql);
			// 下标从1开始
//			pre.setString(1, product.getName());// 1代表第一个?
//			pre.setDouble(2, product.getPrice());
//			pre.setString(3, product.getRemark());
			for(int i = 0; i<params.length;i++) {
				pre.setObject(i+1, params[i]);
			}
			// SQL语句 + 参数 ==> 执行(返回的是int:影响的行数)
			return pre.executeUpdate();// 在数据库中：save delete update 都是称为更新(因为都修改数据)
			//3、进行操作获取结果集（可选）
			//4、数据库，IO流的关闭与释放
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally { // 无论数据库操作是否成功,资源都需要释放
			// Connection > PreparedStatement > ResultSet 释放资源与创建资源的顺序相反
			try {
				pre.close();// 无论pre是否关闭成功,conn都需要关闭
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	
	}
}
