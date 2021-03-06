///////////////////////////////////////////////////////////////////
// Mappings class holds all the constants for all the mappings   //
// in the application.                                           //
//                                                               //
///////////////////////////////////////////////////////////////////

package prykhodko.learnSpring.util;

//Final keyword used to prevent the Mappings class from be extended.
public final class Mappings {

    // == Constants ==
    public static final String ITEMS = "items";
    public static final String ADD_PRODUCT= "addProduct";
    public static final String VIEW_PRODUCT = "viewProduct";
    public static final String DELETE_PRODUCT = "deleteProduct";


    /**
     * Private keyword used to prevent constructor from be instantiated
     * It also makes an app more secure.
     */
    private Mappings(){

    }
}
