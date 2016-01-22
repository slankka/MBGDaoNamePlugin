package com.slanka.mybatis.plugin

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
/**
 * 
 * Mybatis插件 自动把Dao接口名称改成xxxDao
 * @author zz 2016年1月18日 16:29:56
 *
 */
public class MyBatisGeneratorDaoNamePlugin extends PluginAdapter{

     public boolean validate(List<String> warnings) {
         return true;
     }

	@Override
	public void initialized(IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub
		super.initialized(introspectedTable);
		String name = introspectedTable.getMyBatis3JavaMapperType();
		/**
		 * 不要试图修改selectByExample
		 */
		introspectedTable.setMyBatis3JavaMapperType(name.replaceAll("Mapper$", "Dao"));
		
	}


     
}
