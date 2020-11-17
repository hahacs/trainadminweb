package com.system.admin.user.service;

import com.system.admin.common.pojo.Result;
import com.system.admin.sys.sysuser.vo.SysUserVo;

public interface UserService {
    Result<SysUserVo> updatePassword(String oldPassword, String newPassword);

    Result<SysUserVo> updateUser(SysUserVo sysUserVo);
}
