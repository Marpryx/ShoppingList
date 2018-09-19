////////////////////////////////////////////////////////////////////
// ShoppingServiceImpl class represents the business logic        //
// of an application. It manipulates with the data, by            //
// adding removing, getting and updating products at the          //
// Shopping List.                                                 //
//                                                                //
////////////////////////////////////////////////////////////////////

package prykhodko.learnSpring.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import prykhodko.learnSpring.model.ShoppingData;
import prykhodko.learnSpring.model.ShoppingItem;

/**
 * We mark beans with @Service to indicate that it’s holding the business logic.
 * So there’s no any other specialty except using it in the service layer.
 */
@Service
public class ShoppingServiceImpl implements ShoppingService{

    //=== Fields ===
    @Getter //used instead of: public ShoppingData getData() {return null};
    private final ShoppingData data = new ShoppingData();


    //===Public methods ===

    /**
     * Adds items to the Shopping List
     * @param addProduct
     */
    @Override
    public void addProduct(ShoppingItem addProduct) {
        data.addItem(addProduct);

    }

    /**
     * Removes products from the Shopping List
     * @param id
     */
    @Override
    public void removeProduct(int id) {
        data.removeItem(id);

    }

    /**
     * Gets product with specific id from the Shopping List
     * @param id
     * @return
     */
    @Override
    public ShoppingItem getProduct(int id) {
        return data.getItem(id);
    }

    /**
     * Updates product with specific id in the Shopping List
     * @param updateProduct
     */
    @Override
    public void updateProduct(ShoppingItem updateProduct) {
        data.updateItem(updateProduct);
    }

}
