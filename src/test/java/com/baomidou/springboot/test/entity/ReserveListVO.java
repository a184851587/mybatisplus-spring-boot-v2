package com.baomidou.springboot.test.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangdi
 * @since 2020/8/13
 */
@Data
public class ReserveListVO {

    /**
     * 预约ID
     */
    private Long id;
    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 会员昵称
     */
    private String memberName;
    /**
     * 头像
     */
    private String headImage;
    /**
     * 会员等级
     */
    private String level;
    /**
     * 预约状态
     */
    private String reserveStatus;

    private String reserveStatusDesc;
    /**
     * 预约类型
     */
    private String reserveType;
    /**
     * 预约时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 拒绝原因
     */
    private String refuseReason;

    private Date created;

    private CardItem cardItem;

    private OrderService orderService;

    @Data
    public static class CardItem{
        /**
         * 产品名称
         */
        private String name;
        /**
         * 图片
         */
        private String mainImage;
        /**
         * 规格属性
         */
        private String attrValues;
    }

    @Data
    public static class OrderService{
        /**
         * 产品名称
         */
        private String name;
        /**
         * 图片
         */
        private String mainImage;
        /**
         * 规格属性
         */
        private String attrValues;
    }
}
