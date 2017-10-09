package com.lvliang.learn.springboot.mybatis.model;

import java.util.Date;

public class TestMybatis {
    private Integer id;

    private String name;

    private Integer statusCode;

    private String statusName;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

	@Override
	public String toString() {
		return "TestMybatis [id=" + id + ", name=" + name + ", statusCode=" + statusCode + ", statusName=" + statusName
				+ ", updatetime=" + updatetime + "]";
	}
}