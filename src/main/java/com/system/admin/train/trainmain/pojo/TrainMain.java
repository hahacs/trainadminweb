package com.system.admin.train.trainmain.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "train_main")
@Data
public class TrainMain {
    /**
     * id
     */
    @Id
    private String id;

    @Transient
    private String createDateStr;

    @Transient
    private String lastTrainTimeStr;

    @Transient
    private String trainAllTimeStr;

    @Transient
    private String trainTypeStr;



    /**
     * 训练标题
     */
    @Column(name = "trainTitle")
    private String trainTitle;

    /**
     * 训练内容
     */
    @Column(name = "trainContent")
    private String trainContent;

    /**
     * 训练类型
     */
    @Column(name = "trainType")
    private Long trainType;

    /**
     * 训练次数
     */
    @Column(name = "trainTimes")
    private Long trainTimes;

    /**
     * 训练总时长
     */
    @Column(name = "trainAllTime")
    private Long trainAllTime;

    /**
     * 上次训练时间
     */
    @Column(name = "lastTrainTime")
    private Date lastTrainTime;

    /**
     * 创建时间
     */
    @Column(name = "date_created")
    private Date date_created;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否在训练计划内
     */
    private String planFlag;

    /**
     * 训练错误次数
     */
    private Long errorTimes;

}