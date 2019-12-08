package com.canon.model.base;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 14:26
 * @Description:
 */
public interface IModel extends Serializable {

    void setCreationDate(LocalDate creationDate);
    void setLastUpdateDate(LocalDate lastUpdateDate);
    void setLastUpdateBy(Long lastUpdateBy);
    void setCteationBy(Long cteationBy);
    void setVersion(Integer version);
    void setSystemId(Integer systemId);

}
