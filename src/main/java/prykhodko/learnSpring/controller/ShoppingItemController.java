///////////////////////////////////////////////////////////////////////////////////
// ShoppingItemController contains request methods for the ShoppingItem class    //
//                                                                               //
///////////////////////////////////////////////////////////////////////////////////

package prykhodko.learnSpring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import prykhodko.learnSpring.model.ShoppingData;
import prykhodko.learnSpring.model.ShoppingItem;
import prykhodko.learnSpring.service.ShoppingService;
import prykhodko.learnSpring.util.AttributeNames;
import prykhodko.learnSpring.util.Mappings;
import prykhodko.learnSpring.util.ViewNames;

@Slf4j
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
     * Edits an item from the List.
     * It used @GetMapping annotation since we need to execute the get HTTP request
     * instead of POST HTTP request
     * Displayed the form (show item view)
     * @param model
     * @return
     */

    @GetMapping(Mappings.ADD_PRODUCT)
    //The model can supply attributes used for rendering views.
    public String addEditProduct(@RequestParam(required=false, defaultValue = "-1") int id,
                                    Model model){
        log.info("Editing product id = {}", id );
        ShoppingItem item = shoppingService.getProduct(id);
        if(item == null){
            item = new ShoppingItem("", "", 0, 0.00);
        }

        model.addAttribute(AttributeNames.SHOPPING_ITEM, item);
        return ViewNames.ADD_PRODUCT_VIEW;
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
    public String processProduct(@ModelAttribute(AttributeNames.SHOPPING_ITEM) ShoppingItem item){

      //  log.info("ShoppingItem from form = {}", item);

        if(item.getId() == 0){
            shoppingService.addProduct(item);
        }else{
            shoppingService.updateProduct(item);
        }

       // shoppingService.addProduct(item);
        return "redirect:/" + Mappings.ITEMS; //to redirect the view to another url (product table)
                                              //also it's good to use redirect to an error page in
                                              // case if file upload wasn't successful.

        //Used in case of editing a product
        //If id == 0, there is a new product, otherwise
    }

    /**
     * Deletes a product from the list and redirect
     * to the page with all products.
     * @param id used to delete product with the specific id
     * @return the page with the all products on it http://localhost:8080/shopping-list/items
     */

    @GetMapping(Mappings.DELETE_PRODUCT)
    public String deleteProduct(@RequestParam int id){
        log.info("Deleting product with id={}", id);
        shoppingService.removeProduct(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    /**
     * Views choosen item from the list
     * @param id used to view product with the specific id
     * @param model
     * @return the page with the single product on it http://localhost:8080/shopping-list/viewProduct?id=3
     */
    @GetMapping(Mappings.VIEW_PRODUCT)
    public String viewItem(@RequestParam int id, Model model){
        ShoppingItem item = shoppingService.getProduct(id);
        model.addAttribute(AttributeNames.SHOPPING_ITEM, item);
        return ViewNames.VIEW_SINGLE_PRODUCT;

    }

}
