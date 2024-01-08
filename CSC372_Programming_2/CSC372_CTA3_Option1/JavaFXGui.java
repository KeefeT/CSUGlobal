package application;

import java.io.FileWriter;
import java.util.Calendar;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application  {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Thomas Keefe CTA3");
		
		//grid pane to hole everything
		GridPane gp = new GridPane();
		
		//menu items
		MenuItem menuItem1 = new MenuItem("Print date and time");
		MenuItem menuItem2 = new MenuItem("Save to logfile");
		MenuItem menuItem3 = new MenuItem("Change color");
		MenuItem menuItem4 = new MenuItem("Exit program");
		
		//menu
		Menu menu = new Menu("Options");
		menu.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);

		MenuBar menuBar = new MenuBar(menu);
		
		//label 
		Text text = new Text("Empty Text");
		
		//adding objects to grid pane
		gp.add(menuBar, 0, 0);
		gp.add(text, 0, 1);
		gp.setVgap(40);

		//setting the scene with the gridpane
		Scene scene = new Scene(gp, 350, 250);
		
		//putting it here so it runs once per execution
		Random random = new Random();
		//just so it's discernibly green
		float rand = random.nextFloat((float) .1, 1);
		Color randColor = new Color(0, rand, 0, .5);
		
		//action handler 1
		menuItem1.setOnAction(event -> {
			//not using date directly because it's deprecated
			Calendar cal = Calendar.getInstance();
			String date = cal.getTime().toString();
			System.out.println(date);
			text.setText(date);
		});
		
		//action handler 2
		menuItem2.setOnAction(event -> {
			//write to file (warning this writes to eclipse workspace project dir)
			String s = text.getText();
			FileWriter writer;
			try {			
				writer = new FileWriter("log.txt");
				writer.write(s);
				writer.close();
				text.setText("Successfully wrote: ' " + s + " ' to log.txt!");
			} catch (Exception e) {
				System.out.println("Error writing file");
				text.setText("Error writing file");
			}
		});
		
		//action handler 3
		menuItem3.setOnAction(event -> {
			//change background color
			gp.setBackground(new Background(new BackgroundFill(randColor, null, null)));
		});
		
		//action handler 4
		menuItem4.setOnAction(event -> {
			//close program
			Platform.exit();
		});

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}

