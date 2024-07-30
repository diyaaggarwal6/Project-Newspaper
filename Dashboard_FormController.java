package Dashboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Dashboard_FormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ImageView develo;
    
    @FXML
    private Label develop;
    
    @FXML
    private ImageView logout;

    @FXML
    private Label logouts;
    
    @FXML
    void dologout(MouseEvent event) {
    	try{
    		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/Login1/Login1_Form.fxml"));
        	Parent root=(Parent)fxmlloader.load();
        	
        	Stage stage=new Stage();
        	stage.setScene(new Scene(root));
        	stage.show();
            
        	Scene scene1=(Scene)logout.getScene();
			scene1.getWindow().hide();

			Scene scene2=(Scene)logouts.getScene();
			scene2.getWindow().hide();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }

    @FXML
    void doareamaster(ActionEvent event) {
    	try{
    		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/AreaMaster/AreaMaster_Form.fxml"));
        	Parent root=(Parent)fxmlloader.load();
        	
        	Stage stage=new Stage();
        	stage.setScene(new Scene(root));
        	stage.show();

    		
			//to hide the opened window
			 
			  /* Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();
			 */

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }
    

    @FXML
    void dobillcollector(ActionEvent event) {
    	try{
    		
    		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/BillCollector/BillCollector_Form.fxml"));
        	Parent root=(Parent)fxmlloader.load();
        	
        	Stage stage=new Stage();
        	stage.setScene(new Scene(root));
        	stage.show();

    		
    		
			//to hide the opened window
			 
			  /* Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();
			 */

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

    }

    @FXML
    void dobillgenerator(ActionEvent event) {
    	try{
    		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/BillGenerator/Bill_Form.fxml"));
        	Parent root=(Parent)fxmlloader.load();
        	
        	Stage stage=new Stage();
        	stage.setScene(new Scene(root));
        	stage.show();

    		
			//to hide the opened window
			 
			  /* Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();
			 */

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


    }

    @FXML
    void dobillstatuschecker(ActionEvent event) {
    	try{
    		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/BillStatusChecker/BillStatusChecker_Form.fxml"));
        	Parent root=(Parent)fxmlloader.load();
        	
        	Stage stage=new Stage();
        	stage.setScene(new Scene(root));
        	stage.show();

    		
    		
			//to hide the opened window
			 
			  /* Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();
			 */

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


    }

    @FXML
    void dopapermaster(ActionEvent event) {
    	try{
    		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/PaperMaster/Paper_Form.fxml"));
        	Parent root=(Parent)fxmlloader.load();
        	
        	Stage stage=new Stage();
        	stage.setScene(new Scene(root));
        	stage.show();
    		
    		
    		
    		
			//to hide the opened window
			 
			  /* Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();
			 */

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    @FXML
    void dodeveloper(MouseEvent event) {
    	try{
    		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/Developer/Developer_Form.fxml"));
        	Parent root=(Parent)fxmlloader.load();
        	
        	Stage stage=new Stage();
        	stage.setScene(new Scene(root));
        	stage.show();
    		 Scene scene1=(Scene)develop.getScene();
			   scene1.getWindow().hide();
			   
			   Scene scene2=(Scene)develo.getScene();
			   scene2.getWindow().hide();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

@FXML
void docustomerpanel(MouseEvent event) {
	try{
		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/CustomerPanel/CustomerPanel_Form.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();
		
		
		//to hide the opened window
		 
		  /* Scene scene1=(Scene)btnComboApp.getScene();
		   scene1.getWindow().hide();
		 */

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}


}

@FXML
void docustomersview(MouseEvent event) {
	try{
		
		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/CustomerView/CustomerView_Form.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();
		
		
		//to hide the opened window
		 
		  /* Scene scene1=(Scene)btnComboApp.getScene();
		   scene1.getWindow().hide();
		 */

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}

@FXML
void dohawkermanager(MouseEvent event) {
	try{
		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/HawkerManager/HawkersManager_Form.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();
		
		//to hide the opened window
		 
		  /* Scene scene1=(Scene)btnComboApp.getScene();
		   scene1.getWindow().hide();
		 */

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}

@FXML
void dohawkersview(MouseEvent event) {
	try{
		FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/Hawker_tableview/Hawkerview_Form.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();
		
		
		
		//to hide the opened window
		 
		  /* Scene scene1=(Scene)btnComboApp.getScene();
		   scene1.getWindow().hide();
		 */

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
    @FXML
    void initialize() {
    	

    }
}


