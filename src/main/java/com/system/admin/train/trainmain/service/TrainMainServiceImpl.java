package com.system.admin.train.trainmain.service;

import com.system.admin.common.pojo.PageInfo;
import com.system.admin.common.pojo.Result;
import com.system.admin.common.service.CommonServiceImpl;
import com.system.admin.sys.sysauthority.vo.SysAuthorityVo;
import com.system.admin.train.trainmain.pojo.TrainMain;
import com.system.admin.train.trainmain.repository.TrainMainRepository;
import com.system.admin.train.trainmain.vo.TrainMainVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TrainMainServiceImpl extends CommonServiceImpl<TrainMainVo, TrainMain, String> implements TrainMainService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TrainMainRepository trainMainRepository;

    @Override
    public Result<TrainMainVo> findById(String id) {
        return null;
    }

    @Override
    public Result<PageInfo<TrainMainVo>> findALLTrainList() {
        Result<PageInfo<TrainMainVo>> page = super.page(new TrainMainVo());
        return page;
    }

    public void findAllTrainList(){
        //更新权限集合
        List<TrainMainVo> authorityVoList = super.list(new TrainMainVo()).getData();
    }

    @Override
    public void finshOneTrain(TrainMainVo trainMainVo){
        TrainMainVo trainMainById = this.findById(trainMainVo.getId()).getData();
        trainMainById.setLastTrainTime(new Date());
        trainMainById.setTrainTimes(trainMainById.getTrainTimes()+1);
        //训练总时长
        Long preTrainAllTime = trainMainById.getTrainAllTime()==null?0L:trainMainById.getTrainAllTime();
//        Long updateTrainTime = new BigDecimal(preTrainAllTime).add(new BigDecimal((currentTrainTime.getTime() - startTraintime.getTime())/1000)).longValue();
//        trainMainById.setTrainAllTime(updateTrainTime);
        this.save(trainMainById);
    }

}
