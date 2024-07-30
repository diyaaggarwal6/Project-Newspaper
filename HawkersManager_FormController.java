package HawkerManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class HawkersManager_FormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnregister;

    @FXML
    private Button btnfetch;

    @FXML
    private Button btnleft;

    @FXML
    private Button btnchange;

    @FXML
    private Button btnbrowse;

    @FXML
    private ComboBox<String> comboname;

    @FXML
    private TextArea txtaddress;

    @FXML
    private TextField txtcontact;

    @FXML
    private TextField txtaadhar;

    @FXML
    private ComboBox<String> comboarea;

    @FXML
    private TextField txtselected;

    @FXML
    private ImageView hawkerimage;
    Connection con;
    PreparedStatement pst;
    String filepath;
    @FXML
    void dobrowser(ActionEvent event) {
    	FileChooser chooser=new FileChooser();
    	chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("*.*", "*.*")
                );
    	File file=chooser.showOpenDialog(null);
        filepath = file.getAbsolutePath();
    	
    	try {
    		hawkerimage.setImage(new Image(new FileInputStream(file)));
		} 
    	catch (FileNotFoundException e) {	e.printStackTrace();}



    }

    @FXML
    void docomboname(ActionEvent event) {
    	comboname.getEditor().getText();
    	
    }
 
    @FXML
    void docomboarea(ActionEvent event) {
    	comboarea.getSelectionModel().getSelectedItem();
    	}
    void getarea()
    {
    	if(comboarea==null)
    		return;
    	ArrayList<String> areahaw=new ArrayList<String>();
    	try {
			pst=con.prepareStatement("select distinct area from areas");
			ResultSet records=pst.executeQuery();
			areahaw.add("area");
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
    void dofetch(ActionEvent event) {
    	try {
    		
			pst=con.prepareStatement("select * from hawkers where name=?");
			pst.setString(1,comboname.getEditor().getText());
			ResultSet records=pst.executeQuery();
			if(records.next()==true)
			{
			String hname=records.getString("name");
			String haddress=records.getString("address");
			String haadhar=records.getString("Aadhar");
			String hcontact=records.getString("contact");
			String harea=records.getString("selected");
			String hpic=records.getString("pic");
			comboname.getEditor().setText(hname);
			txtaddress.setText(haddress);
			txtaadhar.setText(haadhar);
			txtcontact.setText(hcontact);
			txtselected.setText(harea);
			File file=new File(hpic);
			try {
	    		hawkerimage.setImage(new Image(new FileInputStream(file)));
	    	}
	    	catch(FileNotFoundException e)
	    	{
	    		e.printStackTrace();
	    	}
			btnregister.setDisable(true);
			btnchange.setDisable(false);
			}
			else
			{
				btnfetch.setText("Invalid");
			}
    	}
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void doleft(ActionEvent event) {

		try {
			pst=con.prepareStatement("delete from hawkers where name=?");
			pst.setString(1,comboname.getEditor().getText());
			int count=pst.executeUpdate();
			if(count==0)
			{
				btnleft.setText("Invalid");
			}
			else
			{
				btnleft.setText("Lefted");
		    }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnchange.setDisable(true);
		btnregister.setDisable(true);
    }

    @FXML
    void doregister(ActionEvent event) {
    	try {
			pst=con.prepareStatement("insert into hawkers values(?,?,?,?,?,?)");
			pst.setString(1,comboname.getEditor().getText());
			pst.setString(2,txtaddress.getText());
			pst.setString(3,txtaadhar.getText());
			pst.setString(4,txtcontact.getText());
			pst.setString(5,txtselected.getText());
			pst.setString(6,String.valueOf(filepath));
			
			pst.executeUpdate();
			btnregister.setText("Registered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	btnchange.setDisable(true);
		btnleft.setDisable(true);
    }
    @FXML
    void dochange(ActionEvent event) {
    	try {
			pst=con.prepareStatement("update hawkers set address=?,Aadhar=?,contact=?,selected=? where name=?");
			pst.setString(1,txtaddress.getText());
			pst.setString(2,txtaadhar.getText());
			pst.setString(3,txtcontact.getText());
			pst.setString(4,txtselected.getText());
			pst.setString(5,comboname.getEditor().getText());
			int count=pst.executeUpdate();
			if(count==0)
				btnchange.setText("Invalid");
			else
				btnchange.setText("Changed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	btnleft.setDisable(true);
		btnregister.setDisable(true);
    }

    void fillname()
    {
    	if(comboname==null)
    		return;
    	ArrayList<String> cname=new ArrayList<String>(Arrays.asList());
    	try {
			pst=con.prepareStatement("select distinct name from hawkers" );
			ResultSet records=	pst.executeQuery();
			
			while(records.next())//checks more records
			{
				String hawname=records.getString("name");
				cname.add(hawname);
			}
			comboname.getItems().addAll(cname);
			
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    String str="";
    @FXML
    void doselected(ActionEvent event)
    {
    	str=str+comboarea.getSelectionModel().getSelectedItem()+",";
    	txtselected.setText(str);
    }
   
    
    @FXML
    void initialize() {
    	con=Connect.getConnection();
    	getarea();
    	fillname();
    	
    }
}
