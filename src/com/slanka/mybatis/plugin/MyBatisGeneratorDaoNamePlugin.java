package com.slanka.mybatis.plugin

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
/**
 * 
 * Mybatis插件 自动把Dao接口以及把带有Example的名称改成xxxDao
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
		
		introspectedTable.setCountByExampleStatementId("countByCriteria"); //$NON-NLS-1$
        introspectedTable.setDeleteByExampleStatementId("deleteByCriteria"); //$NON-NLS-1$
        introspectedTable.setInsertSelectiveStatementId("insertSelective"); //$NON-NLS-1$
        introspectedTable.setSelectByExampleStatementId("selectByCriteria"); //$NON-NLS-1$
        introspectedTable.setSelectByExampleWithBLOBsStatementId("selectByCriteriaWithBLOBs"); //$NON-NLS-1$
        introspectedTable.setUpdateByExampleStatementId("updateByCriteria"); //$NON-NLS-1$
        introspectedTable.setUpdateByExampleSelectiveStatementId("updateByCriteriaSelective"); //$NON-NLS-1$
        introspectedTable.setUpdateByExampleWithBLOBsStatementId("updateByCriteriaWithBLOBs"); //$NON-NLS-1$
        introspectedTable.setExampleWhereClauseId("Criteria_Where_Clause"); //$NON-NLS-1$
        introspectedTable.setMyBatis3UpdateByExampleWhereClauseId("Update_By_Criteria_Where_Clause"); //$NON-NLS-1$
		
		//RenamePlugin Can Change This :Example->Criteria  
		//introspectedTable.setExampleType(exampleType);
		introspectedTable.setMyBatis3JavaMapperType(name.replaceAll("Mapper$", "Dao"));
		
	}


     
}
