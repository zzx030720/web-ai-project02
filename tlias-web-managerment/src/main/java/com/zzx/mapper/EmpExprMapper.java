package com.zzx.mapper;

import com.zzx.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//MyBatis注解：告诉MyBatis为这个接口自动生成实现类，并交给Spring容器管理，service中才能注入使用
//具体的SQL（批量插入/删除）写在 resources/com/zzx/mapper/EmpExprMapper.xml 中
@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历
     * @param exprList
     */

    void insertBatch(List<EmpExpr> exprList);


    /**
     * 根据员工ID批量删除员工工作经历
     * @param ids
     */
    void deleteEmpId(List<Integer> empIds);


}
