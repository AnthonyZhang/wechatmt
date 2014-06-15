package cn.wechatmt.demo.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.wechatmt.common.pagination.Page;
import cn.wechatmt.common.web.support.editor.DateEditor;
import cn.wechatmt.demo.model.MobileProductConfig;
import cn.wechatmt.demo.model.MobileUsers;
import cn.wechatmt.demo.service.IProductsService;

@Controller
@RequestMapping(value = "/productConfig")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private IProductsService productService;
    public SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/toAdd", method = { RequestMethod.GET })
    public ModelAndView toAdd(Model model, @RequestParam(value = "categoryId", required = false, defaultValue = "") String parentCategoryId) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("categoryId", parentCategoryId);
        mav.setViewName("backend/productConfig/add");
        return mav;
    }

    @RequestMapping(value = "/{id}/toUpdate", method = { RequestMethod.GET })
    public ModelAndView toUpdate(Model model, @PathVariable Integer id) {
        MobileProductConfig productConfig = productService.get(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("productConfig", productConfig);
        mav.setViewName("backend/productConfig/update");
        return mav;
    }
    @RequestMapping(value = "/{id}/testJson", method = { RequestMethod.POST})
    public void testJson(Model model, @PathVariable Integer id,HttpServletRequest request) {
        System.out.println(ServletRequestUtils.getStringParameter(request, "entity", "default"));
        String object = (String) request.getAttribute("entity");
        System.out.println(object);
        System.out.println(JSONObject.fromObject(object));
        MobileProductConfig productConfig = productService.get(id);
        model.addAttribute("productConfig", productConfig);
        model.addAttribute("back/productConfig/update");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(MobileProductConfig config, Model model, HttpServletRequest request) {
        MobileUsers user = (MobileUsers)request.getSession().getAttribute("user");
        config.setModifyUserId(user.getId());
        config.setCreateDate(dataFormat.format(new Date()));
        config.setUpdateDate(dataFormat.format(new Date()));
        
        productService.save(config);
        
        return "redirect:/productConfig/list";
    }

    @RequestMapping(value = "/list", method = { RequestMethod.GET })
    public String list(HttpServletRequest request, Model model) {
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        Integer id = ServletRequestUtils.getIntParameter(request, "id", -1);
        boolean pre = ServletRequestUtils.getBooleanParameter(request, "pre", false);
        Page<MobileProductConfig> page = null;
        if (id > 0) {
            if (pre) {
                page = productService.pre(id, pn);
            } else {
                page = productService.next(id, pn);
            }
        } else {
            page = productService.listAll(pn);
        }
        request.setAttribute("page", page);
        return "backend/productConfig/list";
    }

    @RequestMapping(value = "/{id}/update", method = { RequestMethod.POST })
    public String update(Model model, MobileProductConfig productConfig, HttpServletRequest request) {
        MobileUsers user = (MobileUsers)request.getSession().getAttribute("user");
        productConfig.setModifyUserId(user.getId());
        productConfig.setUpdateDate(dataFormat.format(new Date()));
        
        productService.merge(productConfig);
        return "redirect:/productConfig/list";
    }

    @RequestMapping(value = "/{id}/delete", method = { RequestMethod.GET })
    public String delete(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/productConfig/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

}
