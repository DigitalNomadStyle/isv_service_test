package demo.biz;

import com.alibaba.fastjson.JSONObject;
import com.jinritemai.cloud.base.api.BaseRequest;
import com.jinritemai.cloud.base.api.BaseResponse;
import com.jinritemai.cloud.base.api.ExtensionService;
import com.jinritemai.cloud.base.api.ExtensionServiceHandler;
import demo.api.ItemDTO;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@ExtensionService("executeCmd")
@Slf4j
public class ExecuteCmdService implements ExtensionServiceHandler<ItemDTO, Integer> {

    @Override
    public BaseResponse<Integer> handle(BaseRequest<ItemDTO> req) {
        log.info("data:{}", JSONObject.toJSONString(req));
        // 轻应用前端的业务传参
        final ItemDTO itemDTO = req.getData();

        // 拿到前端传过来的shell命令
        String cmdString = itemDTO.getCmd();
        log.info("cmd string value :{}",cmdString);
        // 执行
        execShell(cmdString);

        return BaseResponse.<Integer>builder()
                .success(true)
                .data(123)
                .build();
    }


    public static void execShell(String cmd){
        Process process = null;
        List<String> processList = new ArrayList<String>();
        try {
            // 执行命令
            process = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            // 执行结果写到processList中
            while ((line = input.readLine()) != null) {
                processList.add(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : processList) {
            System.out.println(line);
        }
    }


}
