package CustomerView;

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

public class CustomerView_FormController {
	Connection con;
	PreparedStatement pst;
	ObservableList<CustomerBean> List;
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboarea;

    @FXML
    private ComboBox<String> combopaper;

    @FXML
    private TableView<CustomerBean> tblview;

    @FXML
    private Button btngetall;

    @FXML
    private Button btnexcel;

    @FXML
    private Button btnfarea;

    @FXML
    private Button btnfpaper;

    @FXML
    void docomboarea(ActionEvent event) {
    	comboarea.getSelectionModel().getSelectedItem();
    }
    @FXML
    void docombopaper(ActionEvent event) {
    	combopaper.getSelectionModel().getSelectedItem();
    }

    @FXML
    void doexcel(ActionEvent event) {
    	try {
			writeExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void dofarea(ActionEvent event) {
    	doareas();
    }

    @FXML
    void dofpaper(ActionEvent event) {
    	dopapers();
    }
    void doareas()
    {
    	List=FXCollections.observableArrayList();
    	try {
			pst=con.prepareStatement("select * from customers where area like ? ");
			pst.setString(1,"%"+comboarea.getSelectionModel().getSelectedItem()+"%");
			ResultSet records=pst.executeQuery();
			if(records.next())
			{
				String name=records.getString("cname");
				String caddress=records.getString("address");
				String cmobile=records.getString("mobile");
				String cpapers=records.getString("sel_papers");
				String cprice=records.getString("sel_price");
				LocalDate cdos=records.getDate("dos").toLocalDate();
				CustomerBean array=new CustomerBean(name, cmobile, caddress, cpapers, cprice, cdos);
				List.add(array);
			}
			tblview.setItems(List);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    void dopapers()
    {

    	List=FXCollections.observableArrayList();
    	try {
			pst=con.prepareStatement("select * from customers where sel_papers like ? ");
			pst.setString(1,"%"+combopaper.getSelectionModel().getSelectedItem()+"%");
			ResultSet records=pst.executeQuery();
			if(records.next())
			{
				String name=records.getString("cname");
				String caddress=records.getString("address");
				String cmobile=records.getString("mobile");
				String cpapers=records.getString("sel_papers");
				String cprice=records.getString("sel_price");
				LocalDate cdos=records.getDate("dos").toLocalDate();
				CustomerBean array=new CustomerBean(name, cmobile, caddress, cpapers, cprice, cdos);
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
    	ArrayList<String> carea=new ArrayList<String>();
    	try {
			pst=con.prepareStatement("select distinct area from areas");
			ResultSet records=pst.executeQuery();
			while(records.next())
			{
				String csarea=records.getString("area");
				carea.add(csarea);
			}
			comboarea.getItems().addAll(carea);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    void getpapers()
    {

    	ArrayList<String> cpapers=new ArrayList<String>();
    	try {
			pst=con.prepareStatement("select distinct paper from papers");
			ResultSet records=pst.executeQuery();
			while(records.next())
			{
				String cspaper=records.getString("paper");
				cpapers.add(cspaper);
			}
			combopaper.getItems().addAll(cpapers);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    void dogetall(ActionEvent event) {
    	doall();
    }
    void doall()
    {
    	List=FXCollections.observableArrayList();
    	try {
			pst=con.prepareStatement("select * from customers");
			ResultSet records=pst.executeQuery();
			while(records.next())
			{
				String name=records.getString("cname");
				String caddress=records.getString("address");
				String cmobile=records.getString("mobile");
				String cpapers=records.getString("sel_papers");
				String cprice=records.getString("sel_price");
				LocalDate cdos=records.getDate("dos").toLocalDate();
				CustomerBean array=new CustomerBean(name, cmobile, caddress, cpapers, cprice, cdos);
				List.add(array);
			}
			tblview.setItems(List);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @SuppressWarnings("unchecked")
	void addcoloumn()
    {
    	TableColumn<CustomerBean,String> namecol=new TableColumn<CustomerBean, String>("Name");
		namecol.setCellValueFactory(new PropertyValueFactory<CustomerBean, String>("cname"));//field name in bean
		namecol.setMinWidth(50);
		
		TableColumn<CustomerBean,String> addresscol=new TableColumn<CustomerBean, String>("Address");
		addresscol.setCellValueFactory(new PropertyValueFactory<CustomerBean, String>("address"));//field name in bean
		addresscol.setMinWidth(300);
		
		TableColumn<CustomerBean,String> contactcol=new TableColumn<CustomerBean,String>("Contact No.");
		contactcol.setCellValueFactory(new PropertyValueFactory<CustomerBean,String>("mobile"));//field name in bean
		contactcol.setMinWidth(80);
		
		TableColumn<CustomerBean,String> selpaperscol=new TableColumn<CustomerBean,String>("Selected Papers");
		selpaperscol.setCellValueFactory(new PropertyValueFactory<CustomerBean,String>("sel_papers"));//field name in bean
		selpaperscol.setMinWidth(300);
		
		TableColumn<CustomerBean,String> sel_pricecol=new TableColumn<CustomerBean, String>("Selected Price");
		sel_pricecol.setCellValueFactory(new PropertyValueFactory<CustomerBean, String>("sel_price"));//field name in bean
		sel_pricecol.setMinWidth(80);
		
		TableColumn<CustomerBean,LocalDate> doscol=new TableColumn<CustomerBean,LocalDate>("Date of Start");
		doscol.setCellValueFactory(new PropertyValueFactory<CustomerBean,LocalDate>("dos"));//field name in bean
	    doscol.setMinWidth(50);
		
		tblview.getColumns().addAll(namecol,addresscol,contactcol,selpaperscol,sel_pricecol,doscol);
    }
    void writeExcel() throws Exception {
        Writer writer = null;
        try {
        	File file = new File("CV.csv");
            writer = new BufferedWriter(new FileWriter(file));
            String text="Name,Mobile,Address,SelectedPapers,SelectedPrice\n";
            writer.write(text);
            for (CustomerBean p : List)
            {
    			text = p.getCname()+ "," + p.getMobile()+ "," + p.getAddress()+ "," + p.getSel_papers()+ "," + p.getSel_price()+"\n";
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
       getarea();
       getpapers();
       addcoloumn();
    }
}
