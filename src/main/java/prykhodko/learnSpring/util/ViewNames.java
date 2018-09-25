//////////////////////////////////////////////////////////////////////
// View class holds all the constants for all the views             //
// in the application.                                              //
//                                                                  //
// The code looks similar to the Mappings class, but the constants  //
// in Mapping and ViewName classes serve different purposes.        //
// Because requirements can often changes, either the mapping       //
// or the view name could possibly change in the future. If the     //
// same constant will be used for both the ViewName and Mapping     //
// changing the value of constant could generate errors. Therefore, //
// the better solution is to create the same constants in two       //
// different classes.                                               //
//                                                                  //
//////////////////////////////////////////////////////////////////////

package prykhodko.learnSpring.util;

public final class ViewNames {

    // == constants
    public static final String ITEMS_VIEW = "list_items"; //the name of jsp page should be here
    public static final String ADD_PRODUCT_VIEW = "add_product";
    public static final String HOME = "home_page";

    //==constructors ==
    private ViewNames(){}

}
