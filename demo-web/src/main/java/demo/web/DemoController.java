package demo.web;

import com.alibaba.fastjson.JSON;
import com.doudian.open.api.order_orderDetail.OrderOrderDetailRequest;
import com.doudian.open.api.order_orderDetail.OrderOrderDetailResponse;
import com.doudian.open.api.order_orderDetail.param.OrderOrderDetailParam;
import com.doudian.open.api.product_list.ProductListRequest;
import com.doudian.open.api.product_list.ProductListResponse;
import com.doudian.open.api.product_list.param.ProductListParam;
import com.doudian.open.core.GlobalConfig;
import com.jinritemai.cloud.base.api.TokenService;
import com.jinritemai.cloud.base.core.util.AuthThreadLocalUtil;
import com.jinritemai.cloud.base.core.util.LogUtils;
import demo.api.ItemDTO;
import demo.biz.ExceptionCheckPlanService;
import demo.biz.UserService;
import demo.dal.entity.ExceptionCheckPlan;
import demo.dal.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * author       hahafeng
 * created_at   2022/7/10 12:11 上午
 */
@RestController
@RequestMapping("/demo")
@Slf4j
@CrossOrigin(origins = "*")
public class DemoController {
    private static final String LOG_ID_KEY = "LOG_ID";

    @Autowired
    private UserService userService;

    @Resource
    private TokenService tokenService;

    @Autowired
    private ExceptionCheckPlanService exceptionCheckPlanService;


    @RequestMapping("/hello")
    public String hello() {
        final String word = "hello world rlj!";

        log.info(word);
        return word;
    }

    @RequestMapping("/token")
    public String token() {
        try {
            final String token = tokenService.getToken("95250");
            log.info(token);
            return token;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/user")
    public List<User> queryUser() {
        return userService.find();
    }

    @GetMapping("/ext")
    public List<ExceptionCheckPlan> queryExt() {
        MDC.put(LOG_ID_KEY, "test-logId-333");
        return exceptionCheckPlanService.find();
    }

    @GetMapping("/api")
    public void itemApi() {
//        LogUtils.setLogId("20220721172502010174235038047A1000");
        AuthThreadLocalUtil.set("1111114035");
        OrderOrderDetailRequest request = new OrderOrderDetailRequest();
        OrderOrderDetailParam param = request.getParam();
        param.setShopOrderId("4949486364490458473");
        OrderOrderDetailResponse response = request.execute();

        log.info("response: {}", JSON.toJSONString(response));
    }

    @PostMapping("/post")
    public String testPost(@RequestBody ItemDTO itemDTO) {
        return itemDTO.getTitle();
    }

}
