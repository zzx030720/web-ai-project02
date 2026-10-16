package com.zzx.service;

import com.zzx.pojo.Clazz;
import com.zzx.pojo.ClazzQueryParam;
import com.zzx.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    /**
     * 分页查询
     */
    PageResult<Clazz> page(ClazzQueryParam param);

    /**
     * 添加班级
     */
    void save(Clazz clazz);

    /**
     * 根据ID查询班级信息
     */
    Clazz getById(Integer id);

    /**
     * 修改班级信息
     */
    void update(Clazz clazz);

    /**
     * 删除班级
     */
    void delete(Integer id);

    /**
     * 查询所有班级
     */
    List<Clazz> listAll();

}
