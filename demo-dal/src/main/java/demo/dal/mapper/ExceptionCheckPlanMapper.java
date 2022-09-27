package demo.dal.mapper;

import demo.dal.entity.ExceptionCheckPlan;
import demo.dal.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExceptionCheckPlanMapper {
    List<ExceptionCheckPlan> findAll();
}
