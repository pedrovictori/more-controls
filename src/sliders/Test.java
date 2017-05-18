package sliders;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class Test extends Application {
	
	@Override
	public void start(Stage stage) {
		
		try {
			LabelledSlider sl = new LabelledSlider(0, 10, 5);
			stage.setScene(new Scene(sl));
			stage.setTitle("Custom Control");
			stage.setWidth(300);
			stage.setHeight(200);
			stage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
