package com.spark.zwanandroid.model.beans;

/**
 * desc:区域对象
 *
 * @author Bian
 * create at 2019/1/4
 */
public class AreaEntity {

    /**
     * 区域编码
     */
    private String code;
    /**
     * 主键id
     */
    private int id;
    /**
     * 名称
     */
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
