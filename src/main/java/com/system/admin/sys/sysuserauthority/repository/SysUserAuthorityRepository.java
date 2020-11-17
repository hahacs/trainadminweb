package com.system.admin.sys.sysuserauthority.repository;

import com.system.admin.common.repository.CommonRepository;
import com.system.admin.sys.sysuserauthority.pojo.SysUserAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserAuthorityRepository extends CommonRepository<SysUserAuthority, String> {
    List<SysUserAuthority> findByUserId(String userId);
}
