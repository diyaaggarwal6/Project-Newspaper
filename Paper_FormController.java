package PaperMaster;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Paper_FormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnsave;

    @FXML
    private Button btnremove;

    @FXML
    private TextField txtrate;

    @FXML
    private ComboBox<String> combopaper;
    Connection con;
    PreparedStatement pst;
 
    @FXML
    void docombopaper(ActionEvent event) {
    	combopaper.getEditor().getText();
    }

    @FXML
    void dosave(ActionEvent event) {
    	try {
			pst=con.prepareStatement("insert into papers values(?,?)");
			pst.setString(1,combopaper.getEditor().getText());
			pst.setFloat(2,Float.parseFloat(txtrate.getText()));
			pst.executeUpdate();
			btnsave.setText("Saved");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void doupdate(ActionEvent event) {
    	try {
			pst=con.prepareStatement("update papers set rate=? where paper=?");
			pst.setFloat(1,Float.parseFloat(txtrate.getText()));
			pst.setString(2,combopaper.getEditor().getText());
			int count=pst.executeUpdate();
			if(count==0)
			{
				btnupdate.setText("Invalid");
			}
			else
			{
				btnupdate.setText("Updated");
			}
			
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    @FXML
    void doremove(ActionEvent event) {
    	try {
			pst=con.prepareStatement(" delete from papers where paper=?");
			pst.setString(1,combopaper.getEditor().getText());
			int count=pst.executeUpdate();
			if(count==0)
			{
				btnremove.setText("Invalid");
			}
			else
			{
				btnremove.setText("Removed");
			}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }


    @FXML
    void initialize() {
       
        ArrayList<String> paper=new ArrayList<String>(Arrays.asList("The Hindu","The Indian Express","Hindustan Times","The Statesman","The Economic Times","Dainik Jagran","Dainik Bhaskar","Punjab Kesari","Hindustan","Ajit","Jagbani","Punjabi Tribune","Punjabi Jagran"));
        combopaper.getSelectionModel().select(2);
        combopaper.getItems().addAll(paper);
        con=Connect.getConnection();
    }
    
}
