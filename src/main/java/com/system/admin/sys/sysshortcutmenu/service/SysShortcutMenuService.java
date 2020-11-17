package com.system.admin.sys.sysshortcutmenu.service;

import com.system.admin.common.pojo.Result;
import com.system.admin.common.service.CommonService;
import com.system.admin.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import com.system.admin.sys.sysshortcutmenu.vo.SysShortcutMenuVo;

import java.util.List;

public interface SysShortcutMenuService extends CommonService<SysShortcutMenuVo, SysShortcutMenu, String> {
    Result<List<SysShortcutMenuVo>> findByUserId(String userId);
}
