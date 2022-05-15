package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ArrayD;

public class Main extends Application{

	public static void main(String[] args) {
		
		try {
			String path = "data//data.csv";
			File archivos = new File(path);
			FileInputStream a = new FileInputStream(archivos);
			InputStreamReader b = new InputStreamReader(a);
			BufferedReader c = new BufferedReader(b);
			String lin = "";
			String data = "";
			lin = c.readLine();
			while ((lin = c.readLine()) != null) {
				data += lin + ",";
			}
			String[] datos = data.split(",");
			for (int i = 0; i < datos.length; i++) {
				System.out.println(datos[i]);
				if(i % 2 == 0) {
					ArrayD.X.add(Double.parseDouble(datos[i]));
				}else {
					String[] split2 = datos[i].split("\\;");
					System.out.println(split2[i]);
				}
			}
			a.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
		Parent parent = loader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}

}