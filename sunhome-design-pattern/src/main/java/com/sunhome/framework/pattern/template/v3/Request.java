package com.sunhome.framework.pattern.template.v3;

/**
 * @author : wangqijia
 * create at:  2020/4/20  下午1:45
 */
public class Request {

    public void process(ICallback callback) {
        callback.pre();
        System.out.println("Request ...");
        callback.post();
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.process(new ICallback() {
            @Override
            public void pre() {
                System.out.println("pre");
            }

            @Override
            public void post() {
                System.out.println("post");
            }
        });
    }
}
