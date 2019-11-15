package pe.spring.demo.controller;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.spring.demo.services.IProductService;

@Controller
public class InventoryController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private IProductService productManager;
    
    /*@RequestMapping(value="/hello2.htm")
    public String handleRequest(Model model) {
        String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);
		
		model.addAttribute("now", now);
		model.addAttribute("products", this.productManager.listar());
		
        return "hello";
    }*/
}
