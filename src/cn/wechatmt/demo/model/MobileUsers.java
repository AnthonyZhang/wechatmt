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
@Table(name = "tz_mobile_users", schema = "dbo")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MobileUsers extends AbstractModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1141219731069901611L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	private String account;
	
	private String password;
	
	private int status;
	
	private String email;
	
	private String tel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
