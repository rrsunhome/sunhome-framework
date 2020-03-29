package com.sunhome.framework.pattern.builder;

/**
 * @author : qijia.wang
 * create at:  2020/3/29  下午7:16
 * @description:
 */
public class PaymentDTO {
    /**
     * 付款基恩
     */
    private double money;

    private String bankNo;


    private PaymentDTO(Builder builder) {
        money = builder.money;
        bankNo = builder.bankNo;
    }

    public static class Builder{

        private double money;

        private String bankNo;

        public PaymentDTO build() {
            if (money == 0) {
                throw new IllegalArgumentException("金额错误");
            }
            if (bankNo == null || bankNo.isEmpty()) {
                throw new IllegalArgumentException("卡号错误");
            }

            return new PaymentDTO(this);
        }


        public Builder setMoney(double money) {
            this.money = money;
            return this;
        }

        public Builder setBankNo(String bankNo) {
            this.bankNo = bankNo;
            return this;
        }
    }

}
