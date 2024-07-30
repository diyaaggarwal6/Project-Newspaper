package AreaMaster;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class AreaMaster_FormController {
	PreparedStatement pst;
	Connection con;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnsave;

    @FXML
    private Button btndelete;

    @FXML
    private ComboBox<String> comboarea;

    @FXML
    void docomboarea(ActionEvent event) {
    	comboarea.getEditor().getText();
    }

    @FXML
    void dosave(ActionEvent event) {
    	try {
			pst=con.prepareStatement("insert into areas values(?)");
			pst.setString(1,comboarea.getEditor().getText());
			pst.executeUpdate();
			btnsave.setText("Saved");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void dodelete(ActionEvent event) {
    	try {
    		pst=con.prepareStatement("delete from areas where area=?");
			pst.setString(1,comboarea.getEditor().getText());
			pst.executeUpdate();
			btndelete.setText("Deleted");
			btnsave.setDisable(true);
			//btnupdate.setDisable(true);
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

    }
    void fillareas()
    {
    	ArrayList<String> hcarea=new ArrayList<String>();
    	try {
			pst=con.prepareStatement("select distinct area from areas");
			ResultSet records=pst.executeQuery();
			hcarea.add("area");
			while(records.next())
			{
				String areaa=records.getString("area");
				hcarea.add(areaa);
			}
			comboarea.getItems().addAll(hcarea);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    @FXML
    void initialize() {
    	con=Connect.getConnection();
    	fillareas();
    }
}
