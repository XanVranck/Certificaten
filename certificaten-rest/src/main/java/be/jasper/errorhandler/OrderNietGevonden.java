package be.jasper.errorhandler;

import static java.lang.String.format;

/**
 * Created by xanv on 16/07/2017.
 */
public class OrderNietGevonden extends RuntimeException{
    public OrderNietGevonden(int orderId){
        super(format("Order met id %d niet gevonden", orderId));
    }
}
