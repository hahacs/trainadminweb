package com.system.admin.sys.sysuser.repository;

import com.system.admin.common.repository.*;
import com.system.admin.sys.sysuser.pojo.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends CommonRepository<SysUser, String> {
    SysUser findByLoginName(String username);
}
