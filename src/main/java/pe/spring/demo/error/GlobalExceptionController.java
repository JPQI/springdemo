package pe.spring.demo.error;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import pe.spring.demo.dto.SpringDemoGenericException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView handleCustomException(SpringDemoGenericException ex) {

		ModelAndView model = new ModelAndView(ex.getVista());
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());

		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errMsg", "this is Exception.class");

		return model;

	}
	
}
