package CustomerPanel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CustomerPanel_FormController {
	Connection con;
	PreparedStatement pst;
	String strofpprs="";
	String strofprices="";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtcname;

    @FXML
    private TextArea txtaddress;

    @FXML
    private DatePicker datestart;

    @FXML
    private Button btnsave;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnleft;

    @FXML
    private Button btnfetch;

    @FXML
    private ComboBox<String> comboarea;

    @FXML
    private ComboBox<String> combohawker;

    @FXML
    private ListView<Float> listprices;

    @FXML
    private ListView<Float> listselectedprice;

    @FXML
    private ListView<String> listselectedpaper;

    @FXML
    private ListView<String> listpapers;

    @FXML
    private TextField txtcontact;
   
    @FXML
    private Button btnprocess;
    
    @FXML
    void dofillselection(ActionEvent event) {
    	ObservableList<String> selpprs=listpapers.getSelectionModel().getSelectedItems();
    	for(String refselpprs:selpprs)
    	{
    		if(listselectedpaper.getItems().indexOf(refselpprs)==-1)
    		{
    			listselectedpaper.getItems().add(refselpprs);
    		}
    	}
    	listselectedpaper.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	ObservableList<Integer> selindex=listpapers.getSelectionModel().getSelectedIndices();
    	for(int ind:selindex)
    	{
    		float p=listprices.getItems().get(ind);
    		if(listselectedprice.getItems().indexOf(p)==-1)
    		{
    			listselectedprice.getItems().add(p);
    		}
    	}
    }

    void getarea()
    {
    	if(comboarea==null)
    		return;
    	ArrayList<String> areahaw=new ArrayList<String>();
    	try {
			pst=con.prepareStatement("select distinct area from areas");
			ResultSet records=pst.executeQuery();
			while(records.next())
			{
				String area=records.getString("area");
				areahaw.add(area);
			}
			comboarea.getItems().addAll(areahaw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void docombohawker(ActionEvent event) {
    combohawker.getItems().clear();
    System.out.println("abc");
 try {  
	 pst=con.prepareStatement("select name from hawkers where selected like ? ");
   pst.setString(1,"%"+comboarea.getSelectionModel().getSelectedItem()+"%");
	 ResultSet records=pst.executeQuery();
    while(records.next())
    {
    
    			combohawker.getItems().add(records.getString("name"));
    	}
    
    }
    catch(SQLException e)
    {
    	e.printStackTrace();
    }
}
    
    @FXML
    void doremoveselection(MouseEvent event) {
     listselectedprice.getItems().remove(listselectedpaper.getSelectionModel().getSelectedIndex());
     listselectedpaper.getItems().remove(listselectedpaper.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void btnsave(ActionEvent event) {
    	try {
    		pst=con.prepareStatement("insert into customers values(?,?,?,?,?,?,?,?)");
			pst.setString(1,txtcname.getText());
			pst.setString(2,txtaddress.getText());
			pst.setString(3,comboarea.getSelectionModel().getSelectedItem());
			pst.setString(4,combohawker.getSelectionModel().getSelectedItem());
			pst.setString(5, txtcontact.getText());
			ObservableList<String>  selpapers=listselectedpaper.getItems();
			for(String strref:selpapers)
			{
				strofpprs=strofpprs+strref+",";
			}
			pst.setString(6,strofpprs);
			ObservableList<Float>  selprices=listselectedprice.getItems();
			for(Float ref:selprices)
			{
				strofprices=strofprices+String.valueOf(ref)+",";
			}
			pst.setString(7,strofprices);
			pst.setDate(8,Date.valueOf(datestart.getValue()));
			pst.executeUpdate();
			btnsave.setText("Saved");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void dobtnupdate(ActionEvent event) {
    	try {
			pst=con.prepareStatement("update customers set cname=?,address=?,area=?,hawkers=?,sel_papers=?,sel_price=?,dos=? where mobile=?");
			pst.setString(8, txtcontact.getText());
			pst.setString(1,txtcname.getText());
			pst.setString(2,txtaddress.getText());
			pst.setString(3,comboarea.getSelectionModel().getSelectedItem());
			pst.setString(4,combohawker.getSelectionModel().getSelectedItem());
			ObservableList<String> selpprs=listselectedpaper.getItems();
			for(String strref: selpprs)
			{
				strofpprs=strofpprs+strref+",";
			}
			pst.setString(5, strofpprs);
			ObservableList<Float>  selprices=listselectedprice.getItems();
			for(Float ref:selprices)
			{
				strofprices=strofprices+String.valueOf(ref)+",";
			}
			pst.setString(6,strofprices);
			pst.setDate(7,Date.valueOf(datestart.getValue()));
			
			int count=pst.executeUpdate();
			if(count==0)
			{
				btnupdate.setText("Invalid");
			}
			else
				btnupdate.setText("Updated");
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doleft(ActionEvent event) {
    	try {
			pst=con.prepareStatement("delete from customers where mobile=?");
			pst.setString(1,txtcontact.getText());
			int count=pst.executeUpdate();
			if(count==0)
			{
				btnleft.setText("Invalid");
			}
			else
				btnleft.setText("Lefted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void dofetch(ActionEvent event) {
    	try {
			pst=con.prepareStatement("select * from customers where mobile=?");
			pst.setString(1,txtcontact.getText());
			ResultSet records=pst.executeQuery();
			if(records.next()==true)
			{
				txtcname.setText(records.getString("cname"));
				txtaddress.setText(records.getString("address"));
				comboarea.getSelectionModel().select(records.getString("area"));
				combohawker.getSelectionModel().select(records.getString("hawkers"));
				datestart.setValue(records.getDate("dos").toLocalDate());
				String strary[]=records.getString("sel_papers").split(",");
				for(String strref:strary)
				{
					listselectedpaper.getItems().add(strref);
				}
				String floatary[]=records.getString("sel_price").split(",");
				for(String floatref:floatary)
				{
					listselectedprice.getItems().add(Float.parseFloat(floatref));
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    void fillpapers()
    {
    	try {
    			pst=con.prepareStatement("select * from papers");
    			ResultSet pprsrecord=pst.executeQuery();
    	    	while(pprsrecord.next()==true)
    	    	{
    	    		
    	    		listpapers.getItems().add(pprsrecord.getString("paper"));
    	    		listprices.getItems().add(pprsrecord.getFloat("rate"));
    	    		
    	    	}

    			listpapers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    			
    	    }
        	catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
    @FXML
    void initialize() {
        con=Connect.getConnection();
       fillpapers();
       getarea();
        
        
    }
}
