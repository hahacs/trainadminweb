package com.system.admin.sys.sysuserauthority.service;

import com.system.admin.common.pojo.Result;
import com.system.admin.common.service.CommonService;
import com.system.admin.sys.sysuserauthority.pojo.SysUserAuthority;
import com.system.admin.sys.sysuserauthority.vo.SysUserAuthorityVo;

import java.util.List;

public interface SysUserAuthorityService extends CommonService<SysUserAuthorityVo, SysUserAuthority, String> {
    Result<List<SysUserAuthorityVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String authorityIdList);
}
