module ProjectNewsPaper {
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	requires java.sql;
	requires javafx.base;
	requires java.desktop;
	requires jdk.jdi;


exports Login1;
opens Login1 to javafx.graphics, javafx.fxml;

exports ForgotPassword;
opens ForgotPassword to javafx.graphics, javafx.fxml;

exports Signup;
opens Signup to javafx.graphics, javafx.fxml;

exports Developer;
opens Developer to javafx.graphics, javafx.fxml;
	
exports HawkerManager;
opens HawkerManager to javafx.graphics, javafx.fxml;

exports Dashboard;
opens Dashboard to javafx.graphics, javafx.fxml;

exports CustomerView;
opens CustomerView to javafx.graphics, javafx.fxml;

exports BillStatusChecker;
   opens BillStatusChecker to javafx.graphics, javafx.fxml;

exports Hawker_tableview ;
opens Hawker_tableview to javafx.graphics, javafx.fxml;

exports BillGenerator;
opens BillGenerator to javafx.graphics, javafx.fxml;

exports BillCollector;
opens BillCollector to javafx.graphics, javafx.fxml;

exports CustomerPanel;
opens CustomerPanel to javafx.graphics, javafx.fxml;
	
exports PaperMaster;
opens PaperMaster to javafx.graphics, javafx.fxml;

exports AreaMaster;
opens AreaMaster to javafx.graphics, javafx.fxml;

	opens application to javafx.graphics, javafx.fxml;
}

