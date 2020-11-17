package com.system.admin.train.trainmain.vo;

import com.system.admin.common.pojo.PageCondition;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TrainMainVo extends PageCondition implements Serializable {


    private String id;
    private String trainTitle;
    private String trainContent;
    private Long trainType;
    private Long trainTimes;
    private Long trainAllTime;
    private Date lastTrainTime;
    private Date date_created;
    private String remark;
    private String planFlag;
}
