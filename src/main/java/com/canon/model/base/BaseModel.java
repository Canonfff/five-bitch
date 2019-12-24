package com.canon.model.base;

import java.time.LocalDate;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 14:21
 * @Description:
 */
public class BaseModel implements IModel {

    private static final long serialVersionUID = -3563121982067796479L;

    private LocalDate lastUpdateDate;

    private LocalDate creationDate;

    private Long lastUpdateBy;

    private Long creationBy;

    private Integer version;

    private Integer voidFlag;

    private Integer systemId;


    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    @Override
    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    @Override
    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Long getCreationBy() {
        return creationBy;
    }

    @Override
    public void setCreationBy(Long creationBy) {
        this.creationBy = creationBy;
    }

    public Integer getVersion() {
        return version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVoidFlag() {
        return voidFlag;
    }

    public void setVoidFlag(Integer voidFlag) {
        this.voidFlag = voidFlag;
    }

    public Integer getSystemId() {
        return systemId;
    }


    @Override
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }


}
