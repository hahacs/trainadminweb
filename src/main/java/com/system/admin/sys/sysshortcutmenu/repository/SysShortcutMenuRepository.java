package com.system.admin.sys.sysshortcutmenu.repository;

import com.system.admin.common.repository.CommonRepository;
import com.system.admin.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysShortcutMenuRepository extends CommonRepository<SysShortcutMenu, String> {
    List<SysShortcutMenu> findByUserId(String userId);
}
