package com.senyint.exercise.mapper;

import com.senyint.exercise.entity.SysUser;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper extends Mapper<SysUser> {
    SysUser selectByUsername(String username);
}