package com.system.admin.sys.sysmenu.service;

import com.system.admin.common.pojo.Result;
import com.system.admin.common.service.*;
import com.system.admin.sys.sysmenu.pojo.SysMenu;
import com.system.admin.sys.sysmenu.vo.SysMenuVo;

import java.util.List;

public interface SysMenuService extends CommonService<SysMenuVo, SysMenu, String> {
    Result<List<SysMenuVo>> listByTier(SysMenuVo entityVo);
}
