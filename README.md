# NetUtil
网络请求封装，用来抢课的。。

使用了Builder模式，重新封装了一下，专门用来搞抢课这种东西

实现了header设置，get和post，cookies设置，定时执行等功能

使用方法：
~~~java
PropertyBuilder propertyBuilder = new PropertyBuilder()
                .addProperty("Referer", url)
                .addProperty("Cookie", cookie);
        NetUtil net = new NetUtil.Builder(url)
                .doPost(new ParametersBuilder().put(formData))
                .property(propertyBuilder)
                .openLog(false)
                .connectFinishListener(getListener())
                .build();
        net.fuckingConnect(1500);
~~~
