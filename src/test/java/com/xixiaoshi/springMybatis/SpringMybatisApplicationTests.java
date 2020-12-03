package com.xixiaoshi.springMybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xixiaoshi.springMybatis.entities.OmsOrder;
import com.xixiaoshi.springMybatis.entities.UmsAdmin;
import com.xixiaoshi.springMybatis.mapper.OmsOrderMapper;
import com.xixiaoshi.springMybatis.mapper.UmsAdminMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringMybatisApplication.class)
@Transactional
@Rollback
class SpringMybatisApplicationTests {

	@Autowired
	private UmsAdminMapper umsAdminMapper;

	@Autowired
	private OmsOrderMapper omsOrderMapper;

	@Test
	public void testSelect() {
		List<UmsAdmin> admins = umsAdminMapper.selectAll();
		for (UmsAdmin admin : admins) {
			System.out.println(admin.getUsername());
		}
	}

	@Test
	public void testPagination() {
		PageHelper.startPage(1, 10);
		Example example = new Example(OmsOrder.class);
		PageInfo<OmsOrder> pageInfo = new PageInfo<>(omsOrderMapper.selectByExample(example));
		List<OmsOrder> list = pageInfo.getList();
		for(OmsOrder order : list) {
			System.out.println(order.getOrderSn());
		}
	}

}
