import netUtil.NetUtil;
import netUtil.ParametersBuilder;
import netUtil.PropertyBuilder;

import java.io.IOException;

public class Main {

    //选课相关，在浏览器上把cookie和formData复制下来了。。。
    private static final String url = "http://xk4.cqupt.edu.cn/xkPost.php";
    private static final String cookie = "_gscu_1026695571=203891650ct7zr31; UM_distinctid=16262628059e94-0e4719d271e4d-336c7b05-13c680-1626262805a43b; PHPSESSID=8t0vkv2h76ttggsg88li3j7120";
    private static final String formData = "kcmc=%E6%95%B0%E6%8D%AE%E6%8C%96%E6%8E%98%E5%9F%BA%E7%A1%80B&xf=2.0&jxb=A04181A2040501001&sdPrint=%E6%98%9F%E6%9C%9F3%E7%AC%AC7-8%E8%8A%822-13%E5%91%A8%2C16-17%E5%91%A8&teacher=%E5%88%98%E7%BE%A4&syxs=0&kclb=%E9%80%89%E4%BF%AE&xkzt=1&kcbh=A2040501&sd%5B%5D=378&zc%5B%5D=01111111111110011000&isOver=0&isTyfx=0&isSksy=0&nj=2016&zym=%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%A7%91%E5%AD%A6%E4%B8%8E%E6%8A%80%E6%9C%AF&kchType=%E7%90%86%E8%AE%BA";

    public static void main(String[] args) throws IOException {
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
    }

    private static NetUtil.ConnectFinishListener getListener() {
        return result -> System.out.println(new Data(result));
    }
}
