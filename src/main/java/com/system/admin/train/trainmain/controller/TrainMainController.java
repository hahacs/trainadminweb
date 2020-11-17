package com.system.admin.train.trainmain.controller;

import com.system.admin.annotation.Decrypt;
import com.system.admin.annotation.Encrypt;
import com.system.admin.common.controller.CommonController;
import com.system.admin.common.pojo.PageInfo;
import com.system.admin.common.pojo.Result;
import com.system.admin.sys.syssetting.service.SysSettingService;
import com.system.admin.sys.sysuser.pojo.SysUser;
import com.system.admin.sys.sysuser.service.SysUserService;
import com.system.admin.sys.sysuser.vo.SysUserVo;
import com.system.admin.train.trainmain.pojo.TrainMain;
import com.system.admin.train.trainmain.service.TrainMainService;
import com.system.admin.train.trainmain.vo.TrainMainVo;
import com.system.admin.util.SysSettingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/train/trainMain/")
public class TrainMainController extends CommonController<TrainMainVo, TrainMain, String> {
    @Autowired
    private TrainMainService trainMainService;

    @GetMapping("trainmain")
    public ModelAndView trainmain(){
        return new ModelAndView("train/trainmain/trainmain");
    }

}
