package com.example.tacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.example.tacos.Ingredient.Type;

/**
 * @Author moon
 * @Date 2023/4/6 22:15
 * @Description 程序清单2.4
 */
// 比如a组件用log4j，
// b组件用logback，但是一个应用突然ab组件都要用，
// 但是日志不一样岂不是很麻烦，这时候就要用Slf4j了
@Slf4j
@Controller
@RequestMapping("/design")
// 表明在这个类中稍后放到模型模型里面的TacoOrder对象应该在会话中一直保持
// 这一点非常重要，因为创建taco也是创建订单的第一步，而我们创建的订单需要在会话中保存，这样能够使其跨多个请求。
@SessionAttributes("tacoOrder")
public class DesignTacoController {
    //这个方法也会在请求处理的时候被调用，
    // 构建一个包含Ingredient的配料列表并将其放到模型中。
    // 现在，这个列表是硬编码的。
    @ModelAttribute
    //Ingredients   材料
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase());
            filterByType(ingredients, type);
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    //修饰showDesignForm()方法的@GetMapping注解对类级别的@RequestMapping进行了细化。
    // @GetMapping结合类级别的@RequestMapping，
    // 指明当接收到对“/design”的HTTP GET请求时，
    // Spring MVC将会调用showDesignForm()来处理请求。
    @GetMapping
    public String showDesignForm() {
        //返回了一个值为“design”的String，这是视图的逻辑名称，用来向浏览器渲染模型。
        return "design";
    }

    //根据配料类型过滤列表
    //配料类型的列表会以属性的形式添加到Model对象上，并传递给showDesignForm()方法。
    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x->x.getType().equals(type)).collect(Collectors.toList());
    }
}
