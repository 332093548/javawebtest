package cn.dw.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.dw.model.Product;

public class ProductDaoImplTest {
	// static说明当前属性是类属性,只有一份,静态方法只能操作静态属性
		private static ProductDaoImpl daoImpl = null;

		@BeforeClass  // 测试用例之前会调用,一般用来初始化资源
		static void setUpBeforeClass() throws Exception {
			System.out.println("setUpBeforeClass.....");
			daoImpl = new ProductDaoImpl();
		}

		@AfterClass  // 测试用例之后会调用,一般用来销毁资源
		static void tearDownAfterClass() throws Exception {
			System.out.println("tearDownAfterClass.....");
			daoImpl = null;
		}

		@Test
		void testDelete() {
			daoImpl.delete(2);
		}

		@Test
		void testUpdate() {
			fail("Not yet implemented");
		}

		@Test
		void testSave() {
			System.out.println("save........");
			Product product = new Product();
			product.setName("xyz!!!");
			product.setPrice(3.14);
			product.setRemark("remark");
			daoImpl.save(product);
		}

}
