////////////////////////////////////////////////////////////////////////////////////////
//                                                                                    //
// ShoppingData class represents a data source (simulate in-memory-build database).   //
// All the data will be stored by using the List.                                     //
//                                                                                    //
////////////////////////////////////////////////////////////////////////////////////////

package prykhodko.learnSpring.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import lombok.NonNull;

public class ShoppingData {

    //== fields ==
    private static int idValue = 1; // to increment an id of the item

    private final List<ShoppingItem> items = new ArrayList<>();

    //== constructors ==
    public ShoppingData(){

        //some data to check the result
        addItem(new ShoppingItem("Milk", "Fat 3.2%", 2, 3.67 ));
        addItem(new ShoppingItem("Salad", "Green", 2, 1.63 ));
        addItem(new ShoppingItem("Shrimps", "Not China", 4, 9.99 ));
        addItem(new ShoppingItem("Potatoes", "White or Yellow", 2, 2.67 ));
        addItem(new ShoppingItem("Bread", "Multigrain", 3, 2.99 ));


    }

    // == public methods ==

    /**
     * Gets items from the List
     * @return unmodifiableList because we don't need List to be modified other that these methods
     * unmodifiableList doesn't support any modifications. If other classes try to modify List returned
     * by the getItem method than UnsupportedOperationException will be through.
     */
    public List<ShoppingItem> getItems(){
        return Collections.unmodifiableList(items); //
    }

    /**
     * Adds items to the List
     */
    public void addItem(@NonNull ShoppingItem toAddItem){

// Better solution in this case is using the @NotNull instead of writing the code below
//        if(toAddItem == null){
//            throw new NullPointerException("toAddItem is a required parameter");
//        }

        toAddItem.setId(idValue);
        items.add(toAddItem);
        idValue++; //after adding each item we need to increment id
    }


    /**
     * Removes item from the List by using the id parameter, to find the item in the List,
     * and removing it bu using the ListIterator.
     *
     * The iterator helps the loop through the list and manipulate at the same time until we reach
     * the item we need to remove. Once we found the item, we can use Iterator to remove it.
     */
    public void removeItem(int id){
        ListIterator<ShoppingItem> iterator = items.listIterator();

        while(iterator.hasNext()){
            ShoppingItem item = iterator.next(); //method next used to get the data from the iterator

            if(item.getId() == id){
                iterator.remove();
                break; //break the loop in case if item was found and removed
            }
        }

    }

    /**
     * Gets an item from the List by using the id parameter
     * @param id
     * @return
     */
    public ShoppingItem getItem(int id){
        for(ShoppingItem item : items){
            if(item.getId() == id){
                return item;
            }
        }

        return null; //if item doesn't exist we just return null
    }

    public void updateItem(@NonNull ShoppingItem itemToUpdate){
        ListIterator<ShoppingItem> iterator = items.listIterator();

        while(iterator.hasNext()){ //to loop through each item
            ShoppingItem item = iterator.next(); //method next used to get the data from the iterator

         if(item.equals(itemToUpdate)){ // two items can be equal if both have the same id value
         iterator.set(itemToUpdate);
         break;
         }

        }
    }
}
