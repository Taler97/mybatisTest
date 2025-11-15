package org.example.unity;

import lombok.*;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或

// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

@Data
@Builder
public class Teacher{
    private Integer id;
    private String name;
    private String addr;
    private Integer age;
    private String job;
    private Integer sal;

}