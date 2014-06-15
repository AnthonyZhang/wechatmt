package cn.wechatmt.demo.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.wechatmt.common.pagination.Page;
import cn.wechatmt.common.web.support.editor.DateEditor;
import cn.wechatmt.demo.model.MobileNews;
import cn.wechatmt.demo.model.MobileUsers;
import cn.wechatmt.demo.service.INewsService;

@Controller
@RequestMapping(value = "/news")
public class NewsController {

	@Autowired
	@Qualifier("newsService")
	private INewsService newsService;
	public SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@RequestMapping(value = "/toAdd", method = { RequestMethod.GET })
	public String toAdd(Model model) {
		return "backend/News/add";
	}
	
	@RequestMapping(value = "/{id}/toUpdate", method = { RequestMethod.GET })
	public ModelAndView toUpdate(Model model, @PathVariable Integer id) {
		MobileNews news = newsService.get(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("news", news);
		mav.setViewName("backend/News/update");
		return mav;
	}
	
	@RequestMapping(value = "/add",  method = RequestMethod.POST)
	public String add(MobileNews news, Model model, @RequestParam("newsImg") MultipartFile mFile, HttpServletRequest request) {
		String imagespath = uploadFile(mFile, request);
		
		MobileUsers user = (MobileUsers)request.getSession().getAttribute("user");
		
		news.setCreateDate(dataFormat.format(new Date()));
		news.setUpdateDate(dataFormat.format(new Date()));
		news.setMenuImg(imagespath);
		if (null != user) {
			news.setModifyUserId(user.getId());
		}
		newsService.save(news);
		
		return "redirect:/news/list";
	}
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String list(HttpServletRequest request, Model model) {

		int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
		Integer id = ServletRequestUtils.getIntParameter(request, "id", -1);
		boolean pre = ServletRequestUtils.getBooleanParameter(request, "pre",
				false);
		Page<MobileNews> page = null;
		if (id > 0) {
			if (pre) {
				page = newsService.pre(id, pn);
			} else {
				page = newsService.next(id, pn);
			}
		} else {
			page = newsService.listAll(pn);
		}
		request.setAttribute("page", page);
		return "backend/News/list";
	}
	
	@RequestMapping(value = "/{id}/update", method = { RequestMethod.POST })
	public String update(Model model, @ModelAttribute("news") @Valid MobileNews news, @RequestParam("newsImg") MultipartFile mFile, HttpServletRequest request) {
		String imagespath = uploadFile(mFile, request);
		if("" != imagespath){
			news.setMenuImg(imagespath);
		}
		MobileUsers user = (MobileUsers)request.getSession().getAttribute("user");
		if (null != user) {
			news.setModifyUserId(user.getId());
		}
		news.setUpdateDate(dataFormat.format(new Date()));
		newsService.update(news);
		return "redirect:/news/list";
	}

	@RequestMapping(value = "/{id}/delete", method = { RequestMethod.GET })
	public String delete(@PathVariable Integer id) {
		newsService.delete(id);
		return "redirect:/news/list";
	}
	
	private String uploadFile(MultipartFile mFile, HttpServletRequest request){
		String imagespath = "";
		if (!mFile.isEmpty()) {
			String rndFilename = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
			String fileName = mFile.getOriginalFilename();  
		    String ext = fileName.substring(fileName.lastIndexOf("."));  
		    rndFilename = rndFilename+ext;
			imagespath = "uploadfile" + "/" + rndFilename;
            // 获得服务器上传目录
            String dir = request.getSession().getServletContext().getRealPath("uploadfile");
 
            InputStream in;
            OutputStream fileout;
			try {
				 // 获得输入流
				in = mFile.getInputStream();
				fileout = new FileOutputStream(dir + File.separator + rndFilename);
	            int c = 0;
	            byte[] buffer = new byte[1024];
	            while ((c = in.read(buffer, 0, 1024)) != -1) {
	 
	                fileout.write(buffer, 0, c);
	 
	            }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return imagespath;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

}
