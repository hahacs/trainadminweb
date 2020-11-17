package com.system.admin.sys.sysuser.service;

import com.system.admin.common.pojo.Result;
import com.system.admin.common.service.CommonService;
import com.system.admin.sys.sysuser.pojo.SysUser;
import com.system.admin.sys.sysuser.vo.SysUserVo;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public interface SysUserService extends CommonService<SysUserVo, SysUser, String> {
    Result<SysUserVo> findByLoginName(String username);
    Result<SysUserVo> resetPassword(String userId);
    PersistentTokenRepository getPersistentTokenRepository2();
}
