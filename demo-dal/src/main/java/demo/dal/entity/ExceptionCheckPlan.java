package demo.dal.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExceptionCheckPlan implements Serializable {
    private Long id;
    private String title;
    private String content;
}
