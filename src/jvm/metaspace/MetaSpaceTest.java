package jvm.metaspace;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.HashMap;

/**
 * @author sh
 */
public class MetaSpaceTest {

    public static void main(String[] args) {
        int i = 0;
        try {
            for (i = 0; i < 100000; i++) {
                new CglibBean(new HashMap<String, Object>());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("total create count:" + i);
        }
        MetaSpaceTest.intern();
    }

    public static void intern() {
        String s3 = "hello";
        String s1 = new String("he") + new String("llo");
        String s2 = s1.intern();
        System.out.println(s1 == s3);
        System.out.println(s1 == s2);
    }

    public static class CglibBean {

        public CglibBean(Object object) {
            Enhancer enhancer = new Enhancer();
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> obj);
            enhancer.setSuperclass(object.getClass());
            enhancer.create();
        }
    }
}
