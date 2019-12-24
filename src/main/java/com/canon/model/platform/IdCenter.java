package com.canon.model.platform;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/9 16:22
 * @Description:
 */
@Entity
@Table(name = "t_idcenter")
public class IdCenter implements Serializable {

    @Id
    private Long id;
    private String app;
    private String tableName;
    private Long cindex;
    private LocalDate createtime;
    private LocalDate updatetime;
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

    public LocalDate getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDate createtime) {
        this.createtime = createtime;
    }

    public LocalDate getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDate updatetime) {
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
