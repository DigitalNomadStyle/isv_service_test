package demo.api;


import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * author       hahafeng
 * email        chenzhifeng.777@bytedance.com
 * date         2022/9/15 6:38 PM
 */
@Data
public class InParamDTO {
    private UserDTO userDTO;
    private List<UserDTO> userDTOList;
    private UserDTO[] userDTOArray;
    private Map<String, UserDTO> userDTOMap;
    private String[] studentNames;
}
