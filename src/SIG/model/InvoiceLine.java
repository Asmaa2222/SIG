package SIG.model;

public class InvoiceLine {
    private String itemName;
    private double itemPrice;
    private int count;

public InvoiceLine(String name, String price, String cnt)
{
    itemName=name;
    itemPrice=Double.parseDouble(price);
    count=Integer.parseInt(cnt);
}

    public double total()
    {
        return itemPrice*count;
    }


}

   /* public InvoiceLine(String item, String price, String c)
    {
        itemName=item;
        itemPrice=Double.parseDouble(price);
        count= Integer.parseInt(c);
    }*/

