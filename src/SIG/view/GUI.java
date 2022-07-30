package SIG.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class GUI extends JFrame implements ActionListener {
    private JPanel frame;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JTable table1;
    private JButton createInvoice;
    private JButton deleteInvoice;
    private JTable table2;
    private JButton saveBtn;
    private JButton cancelBtn;
    private JLabel invoiceNumber;
    private JLabel num;
    private JLabel invoiceDate;
    private JTextField date;
    private JLabel customerName;
    private JTextField name;
    private JLabel invoiceTotal;
    private JLabel total;
    private JLabel items;
    private JMenuBar menuBar;
    private JMenu menu;
    private JLabel tablename;
    private JPanel leftRightPanel;
    private JPanel secRightPanel;
    private JMenuItem loadFile;
    private JMenuItem saveFile;
    private String []table1header={"No.","Date","Customer","Total"};
    private String[][] table1rec={
            {"","","",""},
            {"","","",""},
            {"","","",""},
            {"","","",""}
    };





    private String[] table2header={"No.","Item Name","Item Price","Count","Item Total"};
    private String[][] table2rec={
            {"","","","",""},
            {"","","","",""},
            {"","","","",""},
            {"","","","",""},
    } ;


    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }
    DefaultTableModel model = new DefaultTableModel(table1rec,table1header);

    public GUI() {
        super("Sales Invoice Generator");

        setSize(1630, 1080);
        setLocation(50, 50);
        setSize(new Dimension(1024, 800));
        this.setLayout(new BorderLayout());
        this.setVisible(true);


        frame=new JPanel(); //the biggest panel that contained the other panels
        frame.setLayout(new GridLayout(1,2));
        leftPanel=new JPanel();
        rightPanel=new JPanel();
        rightPanel.setLayout(new GridLayout(3,1));
        //contained in the right panel:
        leftRightPanel=new JPanel();
        secRightPanel=new JPanel();
        leftRightPanel.setLayout(new GridLayout(4,2));


        String userName= customerName.getText();
        String invDate=invoiceDate.getText();


        //menubar
        menuBar=new JMenuBar();
        menu=new JMenu("File");
        loadFile=new JMenuItem("Load File",'L');
        saveFile=new JMenuItem("Save File",'S');
        saveFile.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.ALT_DOWN_MASK));
        menu.add(loadFile);
        menu.addSeparator();
        menu.add(saveFile);
        menuBar.add(menu);
        menuBar.setBounds(0, 0, 1630, 19);
        setMenuBar(menuBar);
        this.add(menuBar);

        //to perform operations after clicking on these items
        loadFile.addActionListener(this);
        loadFile.setActionCommand("lf");
        saveFile.addActionListener(this);
        saveFile.setActionCommand("sf");


        tablename=new JLabel("Invoices Table");
        table1=new JTable(table1rec,table1header);


        //to enable selecting a row
        ListSelectionModel cellSelectionModel = table1.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        String selectedData = null;




        table1.setBounds(400,1000,400,400);
        leftPanel.add(tablename);
        leftPanel.add(new JScrollPane(table1));




        createInvoice=new JButton("Create New Invoice");

        leftPanel.add(createInvoice);
        createInvoice.addActionListener(this);
        createInvoice.setActionCommand("c");
        deleteInvoice=new JButton("Delete Invoice");
        leftPanel.add(deleteInvoice);
        deleteInvoice.addActionListener(this);
        deleteInvoice.setActionCommand("d");

        invoiceNumber=new JLabel("Invoice Number");
        num=new JLabel("24");

        customerName=new JLabel("Customer Name");
        name=new JTextField();

        invoiceDate=new JLabel("Invoice Date");

        date=new JTextField();
        total=new JLabel("358.85");

        //Adding UI components to the panels
     leftRightPanel.add(invoiceNumber);
     leftRightPanel.add(num);

     leftRightPanel.add(invoiceDate);
     leftRightPanel.add(date);

     leftRightPanel.add(customerName);
     leftRightPanel.add(name);

     leftRightPanel.add(invoiceTotal);
     leftRightPanel.add(total);

     rightPanel.add("Right",leftRightPanel);

        table2=new JTable(table2rec,table2header);
        rightPanel.add(new JScrollPane(table2));


        saveBtn=new JButton("Save");

        saveBtn.addActionListener(this);
        saveBtn.setActionCommand("s");

        cancelBtn=new JButton("Cancel");

        cancelBtn.addActionListener(this);
        cancelBtn.setActionCommand("n");

        secRightPanel.add(saveBtn);
        secRightPanel.add(cancelBtn);
rightPanel.add(secRightPanel);
        frame.add(leftPanel);
        frame.add(rightPanel);
this.add(frame);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    private void setMenuBar(JMenuBar menuBar) {
    }

    public static void main (String[]args){
            GUI fr = new GUI();
            fr.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        // conditions
        switch(e.getActionCommand()){
            case "lf": //loadFile in menu bar
loadfile();
                break;
            case "sf": //saveFile in menu bar
                savef();

                break;
            case "c":
                createNewInvoice();
                break;
            case "d": //delete invoice
                delete();
                break;
            case "s": //save button
                savebutton();
                break;
            case "cn"://cancel button
                JOptionPane.showMessageDialog(null, "you canceled the changes", "Cancel button", JOptionPane.INFORMATION_MESSAGE);
                break;

        }


    }
    private void loadfile() {
    }
    private void savef(){}
    private void savebutton(){

    }
    private void createNewInvoice(){
          model.insertRow(table1.getRowCount(),new Object[]{"","","",""});
    }


    private void openFile(){
        JFileChooser fc=new JFileChooser();
        fc.showOpenDialog(this);
    }
    private void saveContent(){

    }
   private void delete()
    {
        // check for selected row first
        int[] selectedRows = getTable1().getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                table1.remove(selectedRows[i]);
            }
        }
    }


}




