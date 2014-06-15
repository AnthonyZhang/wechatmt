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

import cn.wechatmt.common.Constants;
import cn.wechatmt.common.pagination.Page;
import cn.wechatmt.common.web.support.editor.DateEditor;
import cn.wechatmt.demo.model.MobileProductCategory;
import cn.wechatmt.demo.model.MobileUsers;
import cn.wechatmt.demo.service.IProductCategoryService;

@Controller
@RequestMapping(value = "/productCategory")
public class ProductCategoryController {

    @Autowired
    @Qualifier("productCategoryService")
    private IProductCategoryService productCategoryService;
    public SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/toAdd", method = { RequestMethod.GET })
    public ModelAndView toAdd(Model model, HttpServletRequest reques, @RequestParam(value = "parentCategoryId", required = false, defaultValue = "") String parentCategoryId) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("parentCategoryId", parentCategoryId);
        System.out.println(parentCategoryId);
        mav.setViewName("backend/productCategory/add");
        return mav;
    }

    @RequestMapping(value = "/{id}/toUpdate", method = { RequestMethod.GET })
    public ModelAndView toUpdate(Model model, @PathVariable Integer id) {
        MobileProductCategory category = productCategoryService.get(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("category", category);
        mav.setViewName("backend/productCategory/update");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(MobileProductCategory category, @RequestParam("newsImg") MultipartFile mFile, HttpServletRequest request) {
        String imagespath = uploadFile(mFile, request);
        System.out.println(category.getParentCategoryId());
        if (category.getParentCategoryId() == 0) {
//            category.setParentCategoryId(0);
            category.setCategoryLevel(1);
        } else {
            category.setCategoryLevel(2);
        }
        System.out.println(category.getCategoryLevel());
        category.setCreateDate(dataFormat.format(new Date()));
        category.setUpdateDate(dataFormat.format(new Date()));
        category.setMenuImg(imagespath);
        MobileUsers user = (MobileUsers)request.getSession().getAttribute("user");
        category.setModifyUserId(user.getId());
        productCategoryService.save(category);

        return "redirect:/productCategory/list";
    }

    @RequestMapping(value = "/list", method = { RequestMethod.GET })
    public String list(HttpServletRequest request, Model model) {
        int parentCategoryId = ServletRequestUtils.getIntParameter(request, "parentCategoryId", 0);
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        Integer id = ServletRequestUtils.getIntParameter(request, "id", -1);
        boolean pre = ServletRequestUtils.getBooleanParameter(request, "pre", false);
        System.out.println(pre);
        Page<MobileProductCategory> page = null;
        if (id > 0) {
            if (pre) {
                page = productCategoryService.pre(id, pn, Constants.DEFAULT_PAGE_SIZE, parentCategoryId);
            } else {
                page = productCategoryService.next(id, pn, Constants.DEFAULT_PAGE_SIZE, parentCategoryId);
            }
        } else {
            page = productCategoryService.next(0, pn, Constants.DEFAULT_PAGE_SIZE, parentCategoryId);
        }
        request.setAttribute("page", page);
        return "backend/productCategory/list";
    }

    @RequestMapping(value = "/{id}/update", method = { RequestMethod.POST })
    public String update(Model model, @ModelAttribute("productCategory") @Valid MobileProductCategory category, @RequestParam("newsImg") MultipartFile mFile, HttpServletRequest request) {
        String imagespath = uploadFile(mFile, request);
        if ("" != imagespath) {
            category.setMenuImg(imagespath);
        }

        category.setUpdateDate(dataFormat.format(new Date()));
        productCategoryService.update(category);
        return "redirect:/productCategory/list";
    }

    @RequestMapping(value = "/{id}/delete", method = { RequestMethod.GET })
    public String delete(@PathVariable Integer id) {
        productCategoryService.delete(id);
        return "redirect:/productCategory/list";
    }

    private String uploadFile(MultipartFile mFile, HttpServletRequest request) {
        String imagespath = "";
        if (!mFile.isEmpty()) {
            String rndFilename = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
            String fileName = mFile.getOriginalFilename();
            String ext = fileName.substring(fileName.lastIndexOf("."));
            rndFilename = rndFilename + ext;
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
