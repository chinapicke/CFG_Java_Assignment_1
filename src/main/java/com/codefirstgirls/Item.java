package com.codefirstgirls;

import java.text.DecimalFormat;

// class is public so that it can be globally accessed
public class Item {
//    attributes are private so only accessible within the class
    private String product;
    private String productType;
    double price;

    // constructor is public to allow creation of Item objects
    public Item(String product, String productType, double price) {
        this.product = product;
        this.productType = productType;
        this.price = price;
    }
//using void to display item as there is no return needed as it is just printing what is in each item object
    public void displayItem(){
        System.out.println("Product: " + product + "Type: " + productType + "Price: "+price);
    }

//    returns product so that it can be used in the print statement
    public String getProductName(){
        return product;
    }

    //    return a boolean of true/false, if quantity is 5 then return true
    public boolean isDiscountAvailable(int requestedQuantity){
        return requestedQuantity == 5;
    }
// if isDiscountAvailable === true, then provide user with 10% off their final price
//    used private so only this class has access to this method
    private double discountedPrice(int requestedQuantity){
        if (isDiscountAvailable(requestedQuantity)){
            System.out.println("Great offer- You just received 10% discount on your 5th item!");//            assigned total to a double so that math.round can be used to make the total into 2 decimal place
            return  makeCurrencyTwoDecimalPlace((price * 0.9) * requestedQuantity);
        }
        return makeCurrencyTwoDecimalPlace(price * requestedQuantity);
    }

//    get the total price of the amount for the item requested
    public double getTotalPrice(int requestedQuantity){
        return discountedPrice(requestedQuantity);
    }
// method to convert number to 2 decimal as Math method was rounding up or down
//    decimal format is a method that helps to format decimal numbers
    public double makeCurrencyTwoDecimalPlace(double value){
//        used # to show as a digit but used 00, # will show 0 as absent
        DecimalFormat decimal = new DecimalFormat("#.00");
        return Double.parseDouble(decimal.format(value));
    }

// testing to check that the class is correctly being made and what will be returned with isDiscountAvailable method
//    public static void main(String[] args) {
//        Item donutItem = new Item("Donut","Baked Good", 2.20);
//        System.out.println("Is discount available for 3 items? " + donutItem.isDiscountAvailable(3));
//        System.out.println("Is discount available for 6 items? " + donutItem.isDiscountAvailable(6));
//        System.out.println("Price for 1 item: " + donutItem.price);
//        System.out.println("Discounted price for 5 items: " + donutItem.discountedPrice(5));
//        System.out.println("Discounted price for 5 items: " + donutItem.discountedPrice(4));
//    }
}
