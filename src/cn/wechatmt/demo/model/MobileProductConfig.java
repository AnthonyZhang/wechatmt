package cn.wechatmt.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.wechatmt.common.model.AbstractModel;

@Entity
@Table(name = "tz_mobile_product_config")
public class MobileProductConfig extends AbstractModel {

    private static final long serialVersionUID = -6168043826915976527L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String standardConfig;

    private String intro;

    private String config;

    private int categoryId;

    
    private String createDate;

    private String updateDate;

    private int modifyUserId;

    private String configName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStandardConfig() {
        return standardConfig;
    }

    public void setStandardConfig(String standardConfig) {
        this.standardConfig = standardConfig;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(int modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

}
