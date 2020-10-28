package az.onbir.tv;

import az.onbir.tv.dao.ManDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class IndexController {
    private final ManDao manDao;

    public IndexController(ManDao manDao) {
        this.manDao = manDao;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("mans", manDao.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/search")
    public ModelAndView search(ModelAndView modelAndView, @RequestParam String info) {
        modelAndView.addObject("mans", manDao.findAllByInfoContaining(info));
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
