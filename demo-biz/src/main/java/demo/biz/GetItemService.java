package demo.biz;

import com.jinritemai.cloud.base.api.BaseRequest;
import com.jinritemai.cloud.base.api.BaseResponse;
import com.jinritemai.cloud.base.api.ExtensionService;
import com.jinritemai.cloud.base.api.ExtensionServiceHandler;
import demo.api.InParamDTO;
import demo.api.ItemDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * author       hahafeng
 * email        chenzhifeng@youzan.com
 * created_at   2022/7/10 1 2:42 上午
 */
@ExtensionService("GetItem")
@Slf4j
public class GetItemService implements ExtensionServiceHandler<InParamDTO, ItemDTO> {
    @Override
    public BaseResponse<ItemDTO> handle(BaseRequest<InParamDTO> req) {
        // 轻应用前端的业务传参
//        final ItemDTO itemDTO = req.getData();
//        final String authId = req.getAuthId();


        // 业务逻辑处理
        // do something...
        // db.save(itemDTO);
        log.info("GetItemService -23 {}", req.getData());

        return BaseResponse.<ItemDTO>builder().build();
    }
}
