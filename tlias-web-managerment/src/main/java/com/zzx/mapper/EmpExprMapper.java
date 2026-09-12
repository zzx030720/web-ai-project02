package com.zzx.mapper;

import com.zzx.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
