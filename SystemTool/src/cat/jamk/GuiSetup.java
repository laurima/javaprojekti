import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GuiSetup extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cerberus - System Tool");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.WHITE);

        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
            Tab overview = new Tab();
            overview.setText("Overview");
            GridPane gridpaneoverview = new GridPane();
            gridpaneoverview.getChildren().add(new Label("Frontpage"));
            gridpaneoverview.setAlignment(Pos.CENTER);
            overview.setContent(gridpaneoverview);
            
            
            Label overviewtext = new Label("Overview stats");
            overview.setContent(overviewtext);
            
            HBox piecharthbox = new HBox();
            piecharthbox.setPrefWidth(100);
            overview.setContent(piecharthbox);
            GridPane.setHalignment(piecharthbox, HPos.LEFT);
            
            ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
            new PieChart.Data("Grapefruit", 13),
            new PieChart.Data("Oranges", 25),
            new PieChart.Data("Plums", 10),
            new PieChart.Data("Pears", 22),
            new PieChart.Data("Apples", 30));
            final PieChart chart = new PieChart(pieChartData);
            chart.setTitle("Imported Fruits");
            piecharthbox.getChildren().addAll(chart);
            
            Tab cpupage = new Tab();
            cpupage.setText("Cpu");
            GridPane gridpanecpu = new GridPane();
            gridpanecpu.getChildren().add(new Label("Cpu page"));
            gridpanecpu.setAlignment(Pos.TOP_RIGHT);
            cpupage.setContent(gridpanecpu);
            
            
            Tab stats = new Tab();
            stats.setText("Stats");
            GridPane gridpanestats = new GridPane();
            gridpanestats.getChildren().add(new Label("Stats page"));
            gridpanestats.setAlignment(Pos.CENTER);
            stats.setContent(gridpanestats);
            
            
            tabPane.getTabs().add(overview);
            tabPane.getTabs().add(cpupage);
            tabPane.getTabs().add(stats);
            
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}