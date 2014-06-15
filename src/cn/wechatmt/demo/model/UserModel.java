package cn.wechatmt.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import cn.wechatmt.common.model.AbstractModel;

@Entity
@Table(name = "tz_mobile_users")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserModel extends AbstractModel {

	private static final long serialVersionUID = 2704755025931257792L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	// @Pattern(regexp = "[A-Za-z0-9]{5,20}", message = "{username.illegal}")
	// //java validator验证（用户名字母数字组成，长度为5-10）
	private String account;

	private int tel;

	private int status;

	@NotEmpty(message = "{email.illegal}")
	@Email(message = "{email.illegal}")
	// 错误消息会自动到MessageSource中查找
	private String email;

	@Pattern(regexp = "[A-Za-z0-9]{5,20}", message = "{password.illegal}")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
