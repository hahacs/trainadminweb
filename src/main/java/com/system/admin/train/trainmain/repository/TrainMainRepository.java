package com.system.admin.train.trainmain.repository;

import com.system.admin.common.repository.CommonRepository;
import com.system.admin.sys.sysusermenu.pojo.SysUserMenu;
import com.system.admin.train.trainmain.pojo.TrainMain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainMainRepository extends CommonRepository<TrainMain, String> {
}
