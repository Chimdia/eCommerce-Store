package model;


public class Cart extends Products{
    private int quantity;

        public  Cart(int quantity){
         this.quantity=quantity;
    }


    public  Cart() {
        super();
    }

    @Override
    public int getProductQuantity() {
        return quantity;
    }

    @Override
    public void setProductQuantity(int productQuantity) {
        this.quantity = productQuantity;
    }
}
