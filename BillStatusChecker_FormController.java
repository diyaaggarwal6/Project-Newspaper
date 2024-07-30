package BillStatusChecker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class BillStatusChecker_FormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton radpaid;

    @FXML
    private ToggleGroup bill;

    @FXML
    private RadioButton raddue;

    @FXML
    private Button btncustomers;

    @FXML
    private Button btnshowall;
    
    @FXML
    private Button btnexcel;

    @FXML
    private TableView<BillBean> tblview;

    @FXML
    void dogetcustomers(ActionEvent event) {
    	if(radpaid.isSelected())
    	{
    		dopaid();
    	}
    	else
    	{
    		dodue();
    	}

    }

    @FXML
    void dobtnexcel(ActionEvent event) {
    	try {
			writeExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doshowall(ActionEvent event) {
    	doshow();
    }
    PreparedStatement pst;
    Connection con;
    ObservableList<BillBean>List;
    void doshow()
    {
    	List=FXCollections.observableArrayList();
    	try {
			pst=con.prepareStatement("select * from bills");
			ResultSet records=pst.executeQuery();
			while(records.next())
			{
				String hmobile=records.getString("mobile");
				LocalDate hdos=records.getDate("dos").toLocalDate();
				LocalDate hdupto=records.getDate("dupto").toLocalDate();
				Float hbill=records.getFloat("bill");
				Integer hstatus=records.getInt("STATUS");
				BillBean array=new BillBean(hmobile,hdos,hdupto,hbill,hstatus);
				List.addAll(array);
			}
			tblview.setItems(List);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    void dopaid()
    {
    	List=FXCollections.observableArrayList();
    	try {
			pst=con.prepareStatement("select * from bills where STATUS=1");
			ResultSet records=pst.executeQuery();
			while(records.next())
			{
				String hmobile=records.getString("mobile");
				LocalDate hdos=records.getDate("dos").toLocalDate();
				LocalDate hdupto=records.getDate("dupto").toLocalDate();
				Float hbill=records.getFloat("bill");
				Integer hstatus=records.getInt("STATUS");
				BillBean array=new BillBean(hmobile,hdos,hdupto,hbill,hstatus);
				List.addAll(array);
			}
			tblview.setItems(List);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	}
    void dodue()
    {
    	List=FXCollections.observableArrayList();
    	try {
			pst=con.prepareStatement("select * from bills where STATUS=0");
			ResultSet records=pst.executeQuery();
			while(records.next())
			{
				String hmobile=records.getString("mobile");
				LocalDate hdos=records.getDate("dos").toLocalDate();
				LocalDate hdupto=records.getDate("dupto").toLocalDate();
				Float hbill=records.getFloat("bill");
				Integer hstatus=records.getInt("STATUS");
				BillBean array=new BillBean(hmobile,hdos,hdupto,hbill,hstatus);
				List.addAll(array);
			}
			tblview.setItems(List);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    @SuppressWarnings("unchecked")
	void addcoloumns()
    {
    	TableColumn<BillBean,String> mobilecol=new TableColumn<BillBean, String>("Mobile");
		mobilecol.setCellValueFactory(new PropertyValueFactory<BillBean, String>("mobile"));//field name in bean
		mobilecol.setMinWidth(100);
		
		TableColumn<BillBean,LocalDate> datescol=new TableColumn<BillBean,LocalDate>("Date of Start");
		datescol.setCellValueFactory(new PropertyValueFactory<BillBean,LocalDate>("dos"));//field name in bean
		datescol.setMinWidth(100);
		
		TableColumn<BillBean,LocalDate> dateucol=new TableColumn<BillBean,LocalDate>("Date Upto");
		dateucol.setCellValueFactory(new PropertyValueFactory<BillBean,LocalDate>("dupto"));//field name in bean
		dateucol.setMinWidth(100);
		
		TableColumn<BillBean,Float> billcol=new TableColumn<BillBean,Float>("Bill");
		billcol.setCellValueFactory(new PropertyValueFactory<BillBean,Float>("bill"));//field name in bean
		billcol.setMinWidth(100);
		
		TableColumn<BillBean,Integer> statuscol=new TableColumn<BillBean,Integer>("Status");
		statuscol.setCellValueFactory(new PropertyValueFactory<BillBean,Integer>("status"));//field name in bean
		statuscol.setMinWidth(30);
		
		tblview.getColumns().addAll(mobilecol,datescol,dateucol,billcol,statuscol);
    }
    void writeExcel() throws Exception {
        Writer writer = null;
        try {
        	File file = new File("BSC.csv");
            writer = new BufferedWriter(new FileWriter(file));
            String text="Mobile,Bill,Date of Start,Date Upto,Status\n";
            writer.write(text);
            for (BillBean p : List)
            {
    			text = p.getMobile()+ "," + p.getBill()+ "," + p.getDos()+ "," + p.getDupto()+ "," + p.getStatus()+"\n";
                writer.write(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
           
            writer.flush();
             writer.close();
        }
    }
    @FXML
    void initialize() {
    	con=Connect.getConnection();
    	addcoloumns();
    }
}
