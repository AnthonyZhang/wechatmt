package cn.wechatmt.common.model;

import cn.wechatmt.common.service.ICommonService;
import cn.wechatmt.common.util.SpringContextUtil;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class AbstractModel implements java.io.Serializable {

	private static final long serialVersionUID = 2035013017939483936L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public void save() {
		ICommonService commonService = SpringContextUtil
				.getBean("CommonService");
		commonService.save(this);
	}

	public void delete() {
		ICommonService commonService = SpringContextUtil
				.getBean("CommonService");
		commonService.deleteObject(this);
	}

	public void update() {
		ICommonService commonService = SpringContextUtil
				.getBean("CommonService");
		commonService.update(this);
	}
}
