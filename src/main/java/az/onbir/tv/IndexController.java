package az.onbir.tv;

import az.onbir.tv.dao.ManDao;
import az.onbir.tv.entity.Man;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class IndexController {
    private final ManDao manDao;

    public IndexController(ManDao manDao) {
        this.manDao = manDao;
    }

    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("mans", (List<Man>) manDao.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/search")
    public ModelAndView search(ModelAndView modelAndView, @RequestParam String info) {
        modelAndView.addObject("mans", (List<Man>)manDao.findAllByInfoContaining(info));
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
