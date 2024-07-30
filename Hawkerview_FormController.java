package Hawker_tableview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Hawkerview_FormController {
	PreparedStatement pst;
	Connection con;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnshowall;

    @FXML
    private TableView<HawkerBean> tblview;

    @FXML
    private ComboBox<String> comboarea;

    @FXML
    private Button btnfetcharea;
    
    @FXML
    private Button btnexcel;
    
    @FXML
    void doexcel(ActionEvent event) {
    	try {
			writeExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    void writeExcel() throws Exception {
        Writer writer = null;
        try {
        	File file = new File("Hw.csv");
        	writer = new BufferedWriter(new FileWriter(file));
            String text="Name,Contact,Address,Aadhar,Selected Areas\n";
            writer.write(text);
            for (HawkerBean p : List)
            {
    			text = p.getName()+ "," + p.getContact()+ "," + p.getAddress()+ "," + p.getAadhar()+ "," + p.getSelected()+"\n";
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
    void docomboarea(ActionEvent event) {
    	comboarea.getSelectionModel().getSelectedItem();
    }

    @FXML
    void dofetcharea(ActionEvent event) throws Exception {
    dofetch();
    }

    @FXML
    void doshowall(ActionEvent event) throws Exception {
    	doshow();
    }
    ObservableList<HawkerBean> List;
    void doshow() throws Exception
    {
    	List=FXCollections.observableArrayList();
    	try {
			pst=con.prepareStatement("select * from hawkers");
			ResultSet records=pst.executeQuery();
			while(records.next())
			{
				String hname=records.getString("name");
				String haddress=records.getString("address");
				String haadhar=records.getString("aadhar");
				String hcontact=records.getString("contact");
				String hselected=records.getString("selected");
				HawkerBean array=new HawkerBean(hname, haddress, haadhar, hcontact, hselected);
				List.add(array);
			}
			tblview.setItems(List);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
        
    void dofetch() throws Exception
    {       List=FXCollections.observableArrayList();
    	try {
    		pst=con.prepareStatement("select * from hawkers where selected like ? ");
    		   pst.setString(1,"%"+comboarea.getSelectionModel().getSelectedItem()+"%");
			ResultSet records=pst.executeQuery();
			if(records.next())
			{
				String hname=records.getString("name");
				String haddress=records.getString("address");
				String haadhar=records.getString("Aadhar");
				String hcontact=records.getString("contact");
				String hselected=records.getString("selected");
				HawkerBean array=new HawkerBean(hname, haddress, haadhar, hcontact, hselected);
				List.add(array);
			}
			tblview.setItems(List);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    
@SuppressWarnings("unchecked")
void addColoumns()
   {

		TableColumn<HawkerBean,String> namecol=new TableColumn<HawkerBean, String>("Name");
		namecol.setCellValueFactory(new PropertyValueFactory<HawkerBean, String>("name"));//field name in bean
		namecol.setMinWidth(50);
		
		TableColumn<HawkerBean,String> addresscol=new TableColumn<HawkerBean, String>("Address");
		addresscol.setCellValueFactory(new PropertyValueFactory<HawkerBean, String>("address"));//field name in bean
		addresscol.setMinWidth(250);
		
		TableColumn<HawkerBean,String> aadharcol=new TableColumn<HawkerBean,String>("Aadhar Number");
		aadharcol.setCellValueFactory(new PropertyValueFactory<HawkerBean,String>("aadhar"));//field name in bean
		aadharcol.setMinWidth(90);
		
		TableColumn<HawkerBean,String> contactcol=new TableColumn<HawkerBean,String>("Contact Number");
		contactcol.setCellValueFactory(new PropertyValueFactory<HawkerBean,String>("contact"));//field name in bean
		contactcol.setMinWidth(70);
		
		TableColumn<HawkerBean,String> selectedcol=new TableColumn<HawkerBean, String>("Selected");
		selectedcol.setCellValueFactory(new PropertyValueFactory<HawkerBean, String>("selected"));//field name in bean
		selectedcol.setMinWidth(250);
		
		tblview.getColumns().addAll(namecol,addresscol,aadharcol,contactcol,selectedcol);
   }
    @FXML
    void initialize() {
    	con=Connect.getConnection();
         addColoumns();
         getarea();
    }
}
