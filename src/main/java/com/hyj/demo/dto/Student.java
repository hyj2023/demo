package com.hyj.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;


@Data
@Table(name = "student")
@ApiModel("附件表")
public class Student {
    /**
     * id
     */
    @Column(name = "id")
    @ApiModelProperty("id")
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @Column(name = "name")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    @Column(name = "age")
    private Integer age;

    /**
     * 信息
     */
    @ApiModelProperty("信息")
    @Column(name = "information")
    private String information;

    private String getNumber(){
        return "123";
    }

    private Student(String name) {
        this.name = name;
    }

    private Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
        System.out.println("1111");
    }
}

