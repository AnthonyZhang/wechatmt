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

/**
 * 
 * @author king_zzh
 *
 */
@Entity
@Table(name = "tz_mobile_news")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MobileNews extends AbstractModel{

	private static final long serialVersionUID = 4350278753289946670L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	private String title;
	
	private String content;
	
	private String menuImg;
	
	private String intro;
	
	private String createDate;
	
	private String updateDate;
	
	private int modifyUserId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(int modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
