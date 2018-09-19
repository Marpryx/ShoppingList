///////////////////////////////////////////////////////////////////////////////////
// ShoppingItemController contains request methods for the ShoppingItem class    //
//                                                                               //
///////////////////////////////////////////////////////////////////////////////////

package prykhodko.learnSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import prykhodko.learnSpring.model.ShoppingData;
import prykhodko.learnSpring.service.ShoppingService;
import prykhodko.learnSpring.util.Mappings;
import prykhodko.learnSpring.util.ViewNames;

@Controller
public class ShoppingItemController {

    // === Fields ===
    private final ShoppingService shoppingService;

    // ===Constructors ===

    //@Autowired annotation allows Spring to resolve and inject
    // collaborating beans into your bean.
    //
    //The @Autowired annotation can be used on constructors.
    // In the constructor below, the annotation is used on a constructor,
    // an instance of ShoppingService is injected as an argument to the
    // constructor when ShoppingService is created:

    @Autowired
    public ShoppingItemController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }


    // == Model attributes ==

    // The @ModelAttribute is an annotation that binds a method parameter or
    // method return value to a named model attribute and then exposes it to
    // a web view.

    @ModelAttribute
    public ShoppingData shoppingData(){
        return shoppingService.getData(); //instead of returning new ShoppingData()
    }

    //== Handler methods ==
    //http://localhost:8080/shopping-list/items
    @GetMapping(Mappings.ITEMS)  //Annotation for mapping HTTP GET requests onto specific handler methods.
    public String items(){
        return ViewNames.ITEMS_VIEW;
    }

}
