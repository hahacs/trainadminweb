package com.system.admin.train.trainmain.service;

import com.system.admin.common.pojo.PageInfo;
import com.system.admin.common.pojo.Result;
import com.system.admin.common.service.CommonService;
import com.system.admin.train.trainmain.pojo.TrainMain;
import com.system.admin.train.trainmain.vo.TrainMainVo;

public interface TrainMainService extends CommonService<TrainMainVo, TrainMain, String> {

    Result<TrainMainVo> findById(String id);

    public Result<PageInfo<TrainMainVo>> findALLTrainList();
}
