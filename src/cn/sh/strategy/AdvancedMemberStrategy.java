package cn.sh.strategy;

/**
 * @author sh
 * 高级会员打折策略
 */
public class AdvancedMemberStrategy implements MemeberStrategy {

    @Override
    public double calPrice(double price) {
        System.out.println("高级会员打五折");
        return price * 0.5;
    }
}
