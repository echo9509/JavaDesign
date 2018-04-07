package cn.sh.strategy;

/**
 * @author sh
 */
public class Client {

    public static void main(String[] args) {

        String format = "%1s打折后价格：%2s";

        //新建初级会员打折策略
        MemeberStrategy primary = new PrimaryMemberStrategy();
        //新建中级会员
        MemeberStrategy intermediate = new IntermediateMemberStrategy();
        //新建高级会员
        MemeberStrategy advanced = new AdvancedMemberStrategy();

        //购买总价格500
        double price = 500;

        Price discountPrice = new Price();
        //设置初级会员打折策略
        discountPrice.setStrategy(primary);
        //计算并输出打折后价格
        System.out.println(String.format(format, "初级会员", discountPrice.quote(price)));
        //设置中级会员打折策略
        discountPrice.setStrategy(intermediate);
        //计算并输出打折后价格
        System.out.println(String.format(format, "中级会员", discountPrice.quote(price)));
        //设置高级会员打折策略
        discountPrice.setStrategy(advanced);
        //计算并输出打折后价格
        System.out.println(String.format(format, "高级会员", discountPrice.quote(price)));
    }
}
