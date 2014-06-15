package cn.wechatmt.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.wechatmt.common.model.AbstractModel;

@Entity
@Table(name = "tz_mobile_product_category")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MobileProductCategory extends AbstractModel {
	
	private static final long serialVersionUID = 3418693870879277845L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	private String name;
	
	private String description;
	
	private String menuImg;
	
	private String intro;
	
	private String createDate;
	
	private String updateDate;
	
	private int parentCategoryId;
	
	private int categoryLevel;
	
	private int modifyUserId;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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

	public int getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(int parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public int getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

    public int getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(int modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

}
