package com.system.admin.sys.sysshortcutmenu.controller;

import com.system.admin.common.controller.CommonController;
import com.system.admin.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import com.system.admin.sys.sysshortcutmenu.service.SysShortcutMenuService;
import com.system.admin.sys.sysshortcutmenu.vo.SysShortcutMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/sysShortcutMenu/")
public class SysShortcutMenuController extends CommonController<SysShortcutMenuVo, SysShortcutMenu, String> {
    @Autowired
    private SysShortcutMenuService sysShortcutMenuService;
}
