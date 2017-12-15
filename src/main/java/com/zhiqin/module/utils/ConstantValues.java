package com.zhiqin.module.utils;

/**
 * @author panbo
 * @date 17-6-21
 * Keep going...
 */
public final class ConstantValues {
   /* 需求状态
0已取消 1待付款 2待审核 3审核失败 4冻结 5投标中 6已中标 7完成 8进行中 9已过期 10草稿 11已放弃
    变更为：
    需求状态：
            1待付款 2待托管 3待审核 4审核失败 5投标中 6选标中 7冻结 8已中标 9进行中 10圆满完成
11已评价 12已取消 13退款中 14退款完成 15维权中 16维权完成

            竞标进度状态
0.退出/失效 1.抢标 2.报价方案 3.中标 4.交易协议 5.完成 6.评价
    变更为：
    竞标进度状态 ：
            1投标中 2选标中 3已中标 4未中标 5冻结 6已放弃 7进行中 8圆满完成 9已评价 10退款中
11退款完成 12维权中 13维权完成  14报价方案*/


    /**
     * 订单来源类型：1充值2提现3需求4购买5冻结6退款7赔偿
     */
    public final static int ORDER_RECHARGE = 1;// transact_recharge
    public final static int ORDER_CASH = 2;// transact_cash
    public final static int ORDER_DEMAND = 3;
    public final static int ORDER_PURCHASE = 4;
    public final static int ORDER_FREEZE = 5;
    public final static int ORDER_REFUND = 6;
    public final static int ORDER_COMPENSATION = 7;

    /**
     * 产品类型
     * 1充值
     * 2提现
     * 3需求阶段付款
     * 4需求托管
     * 5购买标签【保证需求真实】
     * 6购买标签【保证完成】
     * 7购买标签【保证维护】
     * 8购买标签【保证源码】
     * 9冻结
     * 10退款
     * 11赔偿
     * 12需求置顶服务
     * 13需求加急服务
     */
    public final static int PRODUCT_RECHARGE = 1;// transact_recharge
    public final static int PRODUCT_CASH = 2;// transact_cash
    public final static int PRODUCT_DEMAND_PAYMENT = 3;// demand_offer
    public final static int PRODUCT_DEMAND_DEPOSIT = 4;// demand_info
    public final static int PRODUCT_PURCHASE_LABEL_PROMISED_DEMAND_TRUE = 5;// user_reputation
    public final static int PRODUCT_PURCHASE_LABEL_PROMISED_FINISH = 6;// user_reputation
    public final static int PRODUCT_PURCHASE_LABEL_PROMISED_MAINTENANCE = 7;// user_reputation
    public final static int PRODUCT_PURCHASE_LABEL_PROMISED_SOURCE_CODE = 8;// user_reputation
    public final static int PRODUCT_FREEZE = 9;
    public final static int PRODUCT_REFUND = 10;
    public final static int PRODUCT_COMPENSATION = 11;
    public final static int PRODUCT_DEMAND_TOP = 12;// demand_info
    public final static int PRODUCT_DEMAND_EXPRESS = 13; // demand_info

    /**
     * 付款状态0付款中1已付款2未付款
     */
    public final static int PAYMENT_UNPAID = 0;// 未付款
    public final static int PAYMENT_PAID = 1;// 已付款
    public final static int PAYMENT_IN_PAYMENT = 2;// 付款中

    /**
     * 财务流向1收入2支出
     */
    public final static int TRANSACTION_INCOME = 1;// 收入
    public final static int TRANSACTION_EXPENDITURE = 2;// 支出

    /**
     * 项目中钱转化倍数
     */
    public static final int MONEY_UNIT = 100;

    /**
     * 提现状态1提现成功2提现失败3待审核4审核中
     */
    public static final int WITHDRAWAL_SUCCESS = 1;
    public static final int WITHDRAWAL_FAILED = 2;
    public static final int PENDING_AUDIT = 3;
    public static final int IN_AUDITING = 4;

    /**
     * 充值状态1充值成功2充值失败3充值中
     */
    public static final int RECHARGE_SUCCESS = 1;
    public static final int RECHARGE_FAILED = 2;
    public static final int RECHARGE_IN_RECHARGE = 3;

    /**
     * 充值类型1线上支付2线下支付
     */
    public static final int PAYMENT_ONLINE = 1;
    public static final int PAYMENT_OFFLINE = 2;

//    /**
//     * 需求状态 0已取消 1待付款 2待审核 3审核失败 4冻结 5投标中 6已中标 7完成 8进行中 9已过期 10草稿 11已放弃
//     */
//    public static final int DEMAND_STATUS_CANCEL = 0;
//    public static final int DEMAND_STATUS_UNPAID = 1;
//    public static final int DEMAND_STATUS_UNAUDITED = 2;
//    public static final int DEMAND_STATUS_AUDIT_FAIL = 3;
//    public static final int DEMAND_STATUS_FROZEN = 4;
//    public static final int DEMAND_STATUS_BIDING = 5;
//    public static final int DEMAND_STATUS_BADE = 6;
//    public static final int DEMAND_STATUS_FINISH = 7;
//    public static final int DEMAND_STATUS_GOING = 8;
//    public static final int DEMAND_STATUS_INVALID = 9;
//    public static final int DEMAND_STATUS_DRAFT = 10;
//    public static final int DEMAND_STATUS_QUIT = 11;


//    /**
//     * 竞标进度状态  0.退出/失效 1.抢标 2.报价方案 3.中标 4.交易协议 5.完成 6.评价
//     */
//    public final static int BID_QUIT = 0;
//    public final static int BID_BIDING = 1;
//    public final static int BID_OFFER = 2;
//    public final static int BID_WIN = 3;
//    public final static int BID_PROTOCOL = 4;
//    public final static int BID_FINISH = 5;
//    public final static int BID_COMMENT = 6;

    /**
     * 需求状态：
     * 1待付款 2待托管 3待审核 4审核失败 5投标中 6选标中 7冻结 8已中标(完成签署协议之后变成阶段付款中) 9进行中（阶段付款中）  10圆满完成
     * 11已评价 12已取消 13退款中 14退款完成 15维权中 16维权完成
     */
    public static final int DEMAND_STATUS_UNPAID = 1;
    public static final int DEMAND_STATUS_UNDEPOSIT = 2;
    public static final int DEMAND_STATUS_UNAUDITED = 3;
    public static final int DEMAND_STATUS_AUDITED_FAILED = 4;
    public static final int DEMAND_STATUS_BIDING = 5;
    public static final int DEMAND_STATUS_SELECT_BIDDER_GOING = 6;
    public static final int DEMAND_STATUS_FROZEN = 7;
    public static final int DEMAND_STATUS_SELECT_BIDDER_FINISH = 8;
    public static final int DEMAND_STATUS_GOING = 9;
    public static final int DEMAND_STATUS_FINISH = 10;
    public static final int DEMAND_STATUS_EVALUATED = 11;
    public static final int DEMAND_STATUS_CANCEL = 12;
    public static final int DEMAND_STATUS_REFUNDING = 13;
    public static final int DEMAND_STATUS_REFUNDED = 14;
    public static final int DEMAND_STATUS_RIGHT_PROTECT_GOING = 15;
    public static final int DEMAND_STATUS_RIGHT_PROTECT_FINISH = 16;

    /**
     * 竞标进度状态 ：
     * 1投标中 2已报价 3选标中 4冻结 5未中标 6已放弃 7已中标 8进行中（协议中） 9阶段付款中 10圆满完成（待评价） 11已评价
     * 12退款中 13退款完成 14维权中 15维权完成
     */
    public static final int BID_STATUS_BIDING = 1;
    public static final int BID_STATUS_OFFER = 2;
    public static final int BID_STATUS_SELECT_BIDDER_GOING = 3;
    public static final int BID_STATUS_FROZEN = 4;
    public static final int BID_STATUS_FAILED = 5;
    public static final int BID_STATUS_QUIT = 6;
    public static final int BID_STATUS_WIN = 7;
    public static final int BID_STATUS_GOING = 8;
    public static final int BID_STATUS_PAYMENT = 9;
    public static final int BID_STATUS_FINISH = 10;
    public static final int BID_STATUS_EVALUATED = 11;
    public static final int BID_STATUS_REFUNDING = 12;
    public static final int BID_STATUS_REFUNDED = 13;
    public static final int BID_STATUS_RIGHT_PROTECT_GOING = 14;
    public static final int BID_STATUS_RIGHT_PROTECT_FINISH = 15;


    /**
     * 企业案例状态
     */
    public static final int CASE_STATUS_DELETE = 0;
    public static final int CASE_STATUS_DISPLAY = 1;
    public static final int CASE_STATUS_HIDDEN = 2;

    /**
     * 投标个数相关
     */
    public static final int BID_NUM_COM = 50;
    public static final int BID_NUM_VIP = 100;
    public static final int DEMAND_BID_NUM_COM = 150;
    public static final int DEMAND_BID_NUM_VIP = 300;

    /**
     * 需求个数相关
     */
    public static final int DEMAND_NUM_COM = 50;
    public static final int DEMAND_NUM_VIP = 100;

    /**
     * 投标身份
     */
    public static final int BID_TYPE_PERSONAL = 1;
    public static final int BID_TYPE_COMPANY = 2;

    /**
     * 取消竞标类型（0没有取消 1系统超时取消 2服务商主动取消 3未中标 4需求方取消需求）
     */
    public static final int CANCEL_TYPE_NONE = 0;
    public static final int CANCEL_TYPE_TIMEOUT = 1;
    public static final int CANCEL_TYPE_ACTIVE_CANCELLATION = 2;
//    public static final int CANCEL_TYPE_FAILURE = 3;
    public static final int CANCEL_TYPE_DEMAND_CANCEL = 4;


    /**
     * 需求置顶金额
     */
    public static final int DEMAND_TOP_SRV_PRICE = 20;

    /**
     * 需求加急金额
     */
    public static final int DEMAND_EXPRESS_SRV_PRICE = 20;

    /**
     * 需求协议状态
     */
    public static final int DEMAND_PROTOCOL_STATUS_NONE = 0;
    public static final int DEMAND_PROTOCOL_STATUS_PROVIDER = 1;//接包方
    public static final int DEMAND_PROTOCOL_STATUS_DEMANDER = 2;//发包方
    public static final int DEMAND_PROTOCOL_STATUS_SUCCESS = 3;//成功

    /**
     * 评价状态
     */
    public static final int DEMAND_REMARK_STATUS_NONE = 0;//未评价
    public static final int DEMAND_REMARK_STATUS_PROVIDER = 1;//接包方已评价
    public static final int DEMAND_REMARK_STATUS_DEMANDER = 2;//发包方已评价
    public static final int DEMAND_REMARK_STATUS_SUCCESS = 3;//评价成功

    /**
     * 需求发布类型
     */
    public static final int DEMAND_TYPE_TENDER = 1;// 招标需求
    public static final int DEMAND_TYPE_EMPLOYMENT = 2;// 雇佣需求
    public static final int DEMAND_TYPE_REWARD = 3;// 悬赏需求


    /**
     * 发票操作状态
     */
    public static final int RECEIPT_STATUS_WAITING = 1;// 待寄送
    public static final int RECEIPT_STATUS_SENDING = 2;// 寄送中
    public static final int RECEIPT_STATUS_ACQUIRED = 3;// 已收取


    /**
     * 获取邮箱相关信息
     */
//    public static final String SMTP_SERVER = "smtp.exmail.qq.com";
//    public static final String SMTP_PORT = "465";
//    public static final String ACCOUNT = "no-reply@aimgoo.com";
//    public static final String PWD = "Aimgoo123456x";
//    public static final String EMAIL_ADDRESS = " http://172.26.53.130:7070";

    /**
     * 因为只要用户购买就会多送一天，再加上当天，所以实际服务天数是真实天数+2，但是退款的时候要减去，避免金额不对等
     * 此处设定额外天数，以后可以修改避免魔法值存在
     */
    public static final int EXTRA_SRV_DAY = 2;

    /**
     * 查询默认全部查询为99
     */
    public static final int CHECK_ALL_THING = 99;

    /**
     * 需求退款状态1待确认退款2退款成功3退款关闭4已拒绝5已撤销
     */
    public static final int DEMAND_REFUND_STATUS_TO_BE_CONFIRMED = 1;
    public static final int DEMAND_REFUND_STATUS_SUCCESS = 2;
    public static final int DEMAND_REFUND_STATUS_CLOSED = 3;
    public static final int DEMAND_REFUND_STATUS_REFUSE = 4;
    public static final int DEMAND_REFUND_STATUS_CANCELED = 5;

    /**
     * 维权阶段1举证期2判定期3法律援助中4取消5处理完毕
     */
    public static final int RIGHT_SAFEGUARD_STATUS_PROOF = 1;
    public static final int RIGHT_SAFEGUARD_STATUS_JUDGEMENT = 2;
    public static final int RIGHT_SAFEGUARD_STATUS_LEGAL_AID_GOING = 3;
    public static final int RIGHT_SAFEGUARD_STATUS_CANCELED = 4;
    public static final int RIGHT_SAFEGUARD_STATUS_FINISH = 5;

    /**
     * 需求身份类型1需求方2服务方3客服
     */
    public static final int IDENTITY_DEMANDER = 1;
    public static final int IDENTITY_PROVIDER = 2;
    public static final int IDENTITY_CUSTOMER_SERVICE = 3;

    /**
     * 维权身份类型1发起2接受
     */
    public static final int RIGHT_IDENTITY_SPONSOR = 1;
    public static final int RIGHT_IDENTITY_RECEIVER = 2;

    /**
     * 退款流程操作1新增2拒绝3修改4取消5付款6关闭7维权
     */
    public static final int DEMAND_REFUND_OPERATION_ADD = 1;
    public static final int DEMAND_REFUND_OPERATION_REFUSE = 2;
    public static final int DEMAND_REFUND_OPERATION_UPDATE = 3;
    public static final int DEMAND_REFUND_OPERATION_CANCEL = 4;
    public static final int DEMAND_REFUND_OPERATION_PAY = 5;
    public static final int DEMAND_REFUND_OPERATION_CLOSED = 6;
    public static final int DEMAND_REFUND_OPERATION_RIGHT_SAFEGUARD = 7;

    /**
     * 维权流程操作1新增2客服通知补充证据3需求双方补充证据4进入判定期5客服仲裁6取消
     */
    public static final int RIGHT_SAFEGUARD_OPERATION_ADD = 1;
    public static final int RIGHT_SAFEGUARD_OPERATION_NOTICE_TO_ADMINICULAR_EVIDENCE = 2;
    public static final int RIGHT_SAFEGUARD_OPERATION_ADMINICULAR_EVIDENCE = 3;
    public static final int RIGHT_SAFEGUARD_OPERATION_TO_JUDGEMENT = 4;
    public static final int RIGHT_SAFEGUARD_OPERATION_ARBITRATION = 5;
    public static final int RIGHT_SAFEGUARD_OPERATION_CANCEL = 6;

    /**
     * 系统默认操作人
     */
    public static final String SYSTEM_DEFAULT_OPERATOR = "system";

    /**
     * 退款类型1项目继续2项目结束
     */
    public static final int DEMAND_REFUND_TYPE_GOING = 1;
    public static final int DEMAND_REFUND_TYPE_CANCELED = 2;

    /**
     * 客服仲裁结果1通过2驳回3提供法律援助
     */
    public static final int RIGHT_SAFEGUARD_JUDGE_ADOPT = 1;
    public static final int RIGHT_SAFEGUARD_JUDGE_REJECT = 2;
    public static final int RIGHT_SAFEGUARD_JUDGE_LEGAL_AID = 3;
}
