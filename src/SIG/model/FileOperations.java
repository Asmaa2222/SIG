package SIG.model;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileOperations {

    static ArrayList<InvoiceHeader> readFile() throws IOException {

        ArrayList<InvoiceHeader> invoice = new ArrayList<>();
        ArrayList<InvoiceLine>invline=new ArrayList<>();
        String file1 = "src/SIG/model/InvoiceHeader.csv";
        String file2="src/SIG/model/InvoiceLine.csv";
        String line = "";
        String line2="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                InvoiceHeader invoicehead = createInvoiceHeader(row);
                invoice.add(invoicehead);
                while((line2=br2.readLine())!=null) {
                    String[] row2 = line.split(",");
                    InvoiceLine ln= createLine(row2);
                    if(row2[0]==row[0])
                        invoicehead.setData(ln);
                }

            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File is not found", "Error",JOptionPane.ERROR_MESSAGE);

            e.printStackTrace();
        }
return invoice;

    }
    void writeFile(ArrayList<InvoiceHeader> f) throws IOException {
        try{
        ArrayList<InvoiceHeader> arrList = new ArrayList<InvoiceHeader>();
        FileOutputStream fos = new FileOutputStream("output");

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new Object()); // write MenuArray to ObjectOutputStream
            oos.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Wrong Format", "Error",JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();
        }


    }

    private static InvoiceHeader createInvoiceHeader(String[] invData) {
        String n = invData[0];
        String date = invData[1];
        String name = invData[2];
        return new InvoiceHeader(n, date, name);

    }
    private static InvoiceLine createLine(String[] invD)
    {
         String i= invD[1];
        String p=invD[2];
       String c=invD[3];
       return new InvoiceLine(i,p,c);
    }

    public static void main(String[] args) throws IOException {


        ArrayList <InvoiceHeader> headers = readFile();

for (InvoiceHeader d : headers) {

    System.out.print("Invoice" + d.getInvoiceNum() + "\n Invoice" + d.getInvoiceDate() + " " + d.getCustomerName() +
            "\n" + d.getdata());


}

}}