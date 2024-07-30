package BillGenerator;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Bill_FormController {
	Connection con;
	PreparedStatement pst;
	PreparedStatement pst1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnfetch;

    @FXML
    private Button btngenerator;

    @FXML
    private Button btnrecord;

    @FXML
    private DatePicker dateupto;

    @FXML
    private DatePicker datedos;

    @FXML
    private TextField txtamount;

    @FXML
    private TextField txtprice;

    @FXML
    private TextField txtmobile;

    @FXML
    void dobillgenerator(ActionEvent event) {
    	doprice();
    Period difference=Period.between(datedos.getValue(),dateupto.getValue());
    float bill=difference.getDays()*Float.parseFloat(txtprice.getText());
    float bill1=bill+difference.getMonths()*Float.parseFloat(txtprice.getText());
    //float bill2=difference.getYears()*Float.parseFloat(txtprice.getText());
    txtamount.setText(String.valueOf(bill1));
    btnrecord.setDisable(false);
    }
    @FXML
    void dofetch(ActionEvent event) {
    	float total=0;
    		String[] strprices;
    	try {
			pst=con.prepareStatement("select * from customers where mobile=?");
			pst.setString(1,txtmobile.getText());
			ResultSet records=pst.executeQuery();
			if(records.next())
			{
				datedos.setValue(records.getDate("dos").toLocalDate());
				strprices=records.getString("sel_price").split(",");
				for(String ref:strprices)
				{
					total+=Float.parseFloat(ref);
				}
				txtprice.setText(String.valueOf(total));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
    }

    @FXML
    void dorecord(ActionEvent event) {
    	try {
			pst=con.prepareStatement("insert into bills(mobile,dos,dupto,bill) values(?,?,?,?)");
			pst.setString(1,txtmobile.getText());
			pst.setDate(2,Date.valueOf(datedos.getValue()));
			pst.setDate(3,Date.valueOf(dateupto.getValue()));
			pst.setFloat(4,Float.parseFloat(txtamount.getText()));
			pst.executeUpdate();
			btnrecord.setText("Recorded");
			pst1=con.prepareStatement("update customers set dos=? where mobile=?");
			pst1.setDate(1,Date.valueOf(dateupto.getValue()));
			pst1.setString(2,txtmobile.getText());
			pst1.executeUpdate();
			
    	}
			    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			    }
    	
    }
    void doprice()
    {
    	try {
			pst=con.prepareStatement("");
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