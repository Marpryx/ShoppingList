///////////////////////////////////////////////////////////////
//
//
////////////////////////////////////////////////////////////////

package prykhodko.learnSpring.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Data generates all the boilerplate that is normally associated
// with simple POJOs (Plain Old Java Objects) and beans: getters for
// all fields, setters for all non-final fields, and appropriate toString,
// equals and hashCode implementations that involve the fields of the
// class, and a constructor that initializes all final fields, as well as
// all non-final fields with no initializer that have been marked with
// @NonNull, in order to ensure the field is never null.
// https://projectlombok.org/features/Data


// With the @Data annotation Equals and HashCode methods will be generated
// automatically for the all fields, but we need only for id field.
// To overcome the issue we can add @EqualsAndHashCode and specify the required
//field


@Data
@EqualsAndHashCode(of = "id") //To specify multiply fields { "","" ,"" ,"" } should be used, just declare as an array
public class ShoppingItem {

    // === Fields ===
    private int id;
    private String item;
    private String details;
    private int amount;
    private double price;

    // === Constructors ===
    public ShoppingItem(String item, String details, int amount, double price) {
        this.item = item;
        this.details = details;
        this.amount = amount;
        this.price = price;
    }

    //To open structure window: View/Tool Windows/Structure


}
