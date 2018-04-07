package cn.sh.strategy;

/**
 * @author sh
 * 初级会员打折方案
 */
public class PrimaryMemberStrategy implements MemeberStrategy {

    /**
     * 计算打折后的价格
     * @param price
     * @return
     */
    @Override
    public double calPrice(double price) {
        System.out.println("初级会员不进行打折");
        return price;
    }
}
