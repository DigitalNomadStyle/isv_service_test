package demo.biz;

import demo.dal.entity.ExceptionCheckPlan;
import demo.dal.entity.User;
import demo.dal.mapper.ExceptionCheckPlanMapper;
import demo.dal.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExceptionCheckPlanService {

    @Autowired
    private ExceptionCheckPlanMapper exceptionCheckPlanMapper;

    public List<ExceptionCheckPlan> find() {
        return exceptionCheckPlanMapper.findAll();
    }
}
