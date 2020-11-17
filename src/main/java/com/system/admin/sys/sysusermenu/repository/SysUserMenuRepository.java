package com.system.admin.sys.sysusermenu.repository;

import com.system.admin.common.repository.CommonRepository;
import com.system.admin.sys.sysusermenu.pojo.SysUserMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMenuRepository extends CommonRepository<SysUserMenu, String> {
    List<SysUserMenu> findByUserId(String userId);
}
