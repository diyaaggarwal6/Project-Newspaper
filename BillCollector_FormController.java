package BillCollector;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class BillCollector_FormController {
	PreparedStatement pst;
	Connection con;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtmobile;

    @FXML
    private TextField txtamount;

    @FXML
    private Button btnfetch;

    @FXML
    private Button btnpaid;

    @FXML
    private DatePicker datefrom;

    @FXML
    private DatePicker dateto;

    @FXML
    void dofetch(ActionEvent event) {
    	try {
			pst=con.prepareStatement("select * from bills where mobile=? and STATUS=0");
			pst.setString(1,txtmobile.getText());
			ResultSet records=pst.executeQuery();
			if(records.next())
			{
				datefrom.setValue(records.getDate("dos").toLocalDate());
				dateto.setValue(records.getDate("dupto").toLocalDate());
				float hamt=records.getFloat("bill");
				txtamount.setText(String.valueOf(hamt));
			}
			else
			{
				Alert alert1 = new Alert(AlertType.WARNING);
    	    	alert1.setTitle("Warning Message");
    	    	alert1.setContentText("Already Paid");
    	    	alert1.showAndWait();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void dopaid(ActionEvent event) {
    	try {
			pst=con.prepareStatement("update bills set STATUS=1 where mobile=? and STATUS=0");
			pst.setString(1,txtmobile.getText());
			pst.executeUpdate();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }

    @FXML
    void initialize() {
     con=Connect.getConnection();   
    }
}
