package com.system.admin.sys.sysusermenu.service;

import com.system.admin.common.pojo.Result;
import com.system.admin.common.service.CommonService;
import com.system.admin.sys.sysmenu.vo.SysMenuVo;
import com.system.admin.sys.sysusermenu.pojo.SysUserMenu;
import com.system.admin.sys.sysusermenu.vo.SysUserMenuVo;

import java.util.List;

public interface SysUserMenuService extends CommonService<SysUserMenuVo, SysUserMenu, String> {
    Result<List<SysMenuVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String menuIdList);
}
