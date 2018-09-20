///////////////////////////////////////////////////////////////////////////////////
// ShoppingItemController contains request methods for the ShoppingItem class    //
//                                                                               //
///////////////////////////////////////////////////////////////////////////////////

package prykhodko.learnSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import prykhodko.learnSpring.model.ShoppingData;
import prykhodko.learnSpring.model.ShoppingItem;
import prykhodko.learnSpring.service.ShoppingService;
import prykhodko.learnSpring.util.AttributeNames;
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

    /**
     * Used HTTP POST method
     * The method will be called after we submit the form to automatically get the
     * object from the form we have to add the model attribute annotation to this
     * parameter. Spring MVC automatically bind the form data to our parameter
     * once we do that.
     *
     * @return redirect page
     */
    @PostMapping(Mappings.ADD_PRODUCT)
    //ModelAttribute name must match in both the controller and in the form
    public String processProduct(@ModelAttribute(AttributeNames.SHOPPING_ITEM) ShoppingItem shoppingItem){
        return "redirect:/" + Mappings.ITEMS; //to redirect the view to another url (product table)
                                              //also it's good to use redirect to an error page in
                                              // case if file upload wasn't successful.

    }

}
