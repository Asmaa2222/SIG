package SIG.model;

//called InvoiceHeader which contains the following fields: invoiceNum, invoiceDate, customerName, ArrayList<InvoiceLines>

import java.util.ArrayList;

public class InvoiceHeader {
  //  public static String csv;
    private int invoiceNum;
    private String invoiceDate;
    private String customerName;
    //private InvoiceLine[]ArrayList;
    ArrayList<InvoiceLine> Data = new ArrayList<>();

public InvoiceHeader(String n, String date, String name)
{
    invoiceNum=Integer.parseInt(n);
    invoiceDate=date;
    customerName=name;

}


    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<InvoiceLine> getData() {
        return Data;
    }

    public void setData(InvoiceLine data) {
    Data.add(data);
    }

    public ArrayList getdata() {
    return Data;
    }
}
