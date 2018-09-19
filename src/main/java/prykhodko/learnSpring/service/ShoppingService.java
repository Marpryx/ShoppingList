///////////////////////////////////////////////////////////
//                                                       //
// ShoppingService interface contains default methods,   //
// that can be implemented in other classes:             //
//      - addProduct                                     //
//      - removeProduct                                  //
//      - getProduct                                     //
//      - updateProduct                                  //
//      - getData                                        //
//                                                       //
//                                                       //
///////////////////////////////////////////////////////////

package prykhodko.learnSpring.service;

import prykhodko.learnSpring.model.ShoppingData;
import prykhodko.learnSpring.model.ShoppingItem;

public interface ShoppingService {

    void addProduct(ShoppingItem product);
    void removeProduct(int id);
    ShoppingItem getProduct(int id);
    void updateProduct(ShoppingItem product);
    ShoppingData getData();
}
