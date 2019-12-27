package com.canon.model.platform;


import java.io.Serializable;
import java.util.Date;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/9 16:22
 * @Description:
 */
public class IdCenter implements Serializable {

    private Long id;
    private String app;
    private String tableName;
    private Long cindex;
    private Date createtime;
    private Date updatetime;
    private String keypre;
    private Integer fstep;
    private Long dbid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getCindex() {
        return cindex;
    }

    public void setCindex(Long cindex) {
        this.cindex = cindex;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getKeypre() {
        return keypre;
    }

    public void setKeypre(String keypre) {
        this.keypre = keypre;
    }

    public Integer getFstep() {
        return fstep;
    }

    public void setFstep(Integer fstep) {
        this.fstep = fstep;
    }

    public Long getDbid() {
        return dbid;
    }

    public void setDbid(Long dbid) {
        this.dbid = dbid;
    }
}
