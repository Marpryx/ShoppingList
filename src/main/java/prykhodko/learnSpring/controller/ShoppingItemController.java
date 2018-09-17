///////////////////////////////////////////////////////////////////////////////////
// ShoppingItemController contains request methods for the ShoppingItem class    //
//                                                                               //
///////////////////////////////////////////////////////////////////////////////////

package prykhodko.learnSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import prykhodko.learnSpring.model.ShoppingData;
import prykhodko.learnSpring.util.Mappings;
import prykhodko.learnSpring.util.ViewNames;

@Controller
public class ShoppingItemController {

    // == Model attributes ==

    // The @ModelAttribute is an annotation that binds a method parameter or
    // method return value to a named model attribute and then exposes it to
    // a web view.

    @ModelAttribute
    public ShoppingData shoppingData(){
        return new ShoppingData();
    }

    //== Handler methods ==
    //http://localhost:8080/shopping-list/items
    @GetMapping(Mappings.ITEMS)  //Annotation for mapping HTTP GET requests onto specific handler methods.
    public String items(){
        return ViewNames.ITEMS;
    }

}
