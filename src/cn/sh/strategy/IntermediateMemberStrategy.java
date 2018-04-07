package cn.sh.strategy;


/**
 * @author sh
 * 中级会员打折策略
 */
public class IntermediateMemberStrategy implements MemeberStrategy {

    @Override
    public double calPrice(double price) {
        System.out.println("中级会员打9折");
        return price * 0.9;
    }
}
