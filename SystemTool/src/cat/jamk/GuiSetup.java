package cat.jamk;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GuiSetup extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }


    
    @Override
    public void start(Stage primaryStage) {
        
        
        
        // Threads
        VisualizationThread visual = new VisualizationThread("Visualization");
        AnalyzingThread analytics = new AnalyzingThread("Analyzation");
                
        visual.start();
        analytics.start();

        primaryStage.setTitle("Cerberus - System Tool");
        Group root = new Group();
        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add
        (GuiSetup.class.getResource("mainstyle.css").toExternalForm());
        
        // Default sulkemisoperaatio, tappaa threadit ikkunan sulkiessa        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {                
                System.exit(0);
            }
        });
    
        // Käyttäjän lisääminen
        userRegister();

        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        
        Cpu cpu = new Cpu();
        Ram ram = new Ram();
        OperatingSystem operatingsystem = new OperatingSystem();
        Network network = new Network();
        Disk disk = new Disk(); 
        
        Tab overview = new Tab();
        overview.setText("Overview");
        
        SplitPane splitpaneoverview = new SplitPane();
        overview.setContent(splitpaneoverview);
        
        GridPane gridpaneoverview = new GridPane();
        gridpaneoverview.setHgap(10);
        gridpaneoverview.setVgap(10);
        gridpaneoverview.setPadding(new Insets(0, 10, 0, 10));
        gridpaneoverview.setAlignment(Pos.CENTER);
        
        
        Text frontSystemSpec = new Text("System Specifications");
        Text frontOs = new Text("OS");
        Text frontUser = new Text("User");
        Text frontCpu = new Text("Cpu");
        Text frontRam = new Text("Ram");
        Text frontDisk = new Text("C disk");
            
        Label frontOsLabel = new Label(operatingsystem.getOS() + " ver " +operatingsystem.getOsVersion());
        Label frontUserLabel = new Label(operatingsystem.getUsername());
        Label frontCpuLabel = new Label(cpu.getArchitecture() + " @ " + cpu.getFrequency() + " Hz" );
        Label frontRamLabel = new Label(String.valueOf(ram.getTotalRam()) + " Gt");
        Label frontDiskLabel = new Label(String.valueOf(disk.getTotalSpace()) +  " Gt");
        
        gridpaneoverview.add(frontSystemSpec,3,0);
        gridpaneoverview.add(frontOs,3,1);
        gridpaneoverview.add(frontUser,3,2);
        gridpaneoverview.add(frontCpu,3,3);
        gridpaneoverview.add(frontRam,3,4);
        gridpaneoverview.add(frontDisk,3,5);
        
        gridpaneoverview.add(frontOsLabel,4,1);
        gridpaneoverview.add(frontUserLabel,4,2);
        gridpaneoverview.add(frontCpuLabel,4,3);
        gridpaneoverview.add(frontRamLabel,4,4);
        gridpaneoverview.add(frontDiskLabel,4,5);

        HBox piecharthbox = new HBox();
        splitpaneoverview.getItems().add(gridpaneoverview);
        splitpaneoverview.getItems().add(piecharthbox);
            
            CpuChart cpuchart = new CpuChart();
            GridPane.setHalignment(piecharthbox, HPos.LEFT);

            
            final PieChart chart = new PieChart(cpuchart.getPieChartData());  
            chart.setTitle("Cpu"); 
         
         piecharthbox.getChildren().addAll(chart);   
            
            Tab cpupage = new Tab();
            cpupage.setText("Processes");
            GridPane gridpanecpu = new GridPane();
            gridpanecpu.setAlignment(Pos.CENTER);
            cpupage.setContent(gridpanecpu);
            
            TableView table = new TableView();
            TableColumn nameCol = new TableColumn("Application");
            TableColumn usageCol = new TableColumn("Process usage");
        
            table.getColumns().addAll(nameCol, usageCol);
            
            VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(table);
            gridpanecpu.add(vbox,0,0);
            
            
            
            
            Tab stats = new Tab();
            stats.setText("Stats");
            GridPane gridpanestats = new GridPane();
            GridPane gridpanestatsleft = new GridPane();
            GridPane gridpanestatsright = new GridPane();
            gridpanestats.setAlignment(Pos.CENTER);
  
            //gridpanestats.setAlignment(Pos.CENTER);
            stats.setContent(gridpanestats);
            gridpanestats.add(gridpanestatsleft, 0, 1);
            gridpanestats.add(gridpanestatsright, 3, 1);
            
            
        
            
            Layers layer = new Layers();
            
            Text osText = new Text("Operating System");
            Text osOperatingSystem = new Text("Operating System");
            Text osVersion = new Text("OS Version");
            Text osArchitecture = new Text("Architecture");
            Text osUserName = new Text("User name");
            Text osUserLanguage = new Text("User Language");
            Text osUserCountry = new Text("User Country");
            Text osHomeFolder = new Text("Home Folder");
            
            Label osVersionLabel = new Label(layer.getOperatingversion());
            Label osOperatingSystemLabel = new Label(layer.getOperatingsystem());
            Label osArchitectureLabel = new Label(layer.getOperatingarchitecture());
            Label osUserNameLabel = new Label(layer.getOperatingusername());
            Label osUserLanguageLabel = new Label(layer.getOperatinguserlanguage());
            Label osHomeFolderLabel = new Label(layer.getOperatinghomefolder()); 
            Label osUserCountryLabel = new Label(layer.getOperatingusercounry()); 
            
            
            Text cpuText = new Text("Cpu");
            Text cpuArchitecture = new Text("Architecture");
            Text cpuIdentifier = new Text("Identifier");
            Text cpuNumberOfCores = new Text("Number of Cores");
            Text cpuFrequency = new Text("Frequency");

            Label cpuArchitectureLabel = new Label(layer.getCpuarchitecture());
            Label cpuIdentifierLabel = new Label(layer.getCpuidentifier());
            Label cpuNumberOfCoresLabel = new Label(layer.getCpunumberofcores());
            Label cpuFrequencyLabel = new Label(layer.getCpufrequency() + " Hz");
            
            Text networkText = new Text("Network");
            Text networkComputerName = new Text("Computer Name");
            Text networkUserDomain = new Text("User Domain");
            Text networkRoamingProfile = new Text("Roaming Profile");
            Text networkMacAddress = new Text("Mac Address");
            Text networkIpAddress = new Text("Ip Address");
            Text networkInterfaceName = new Text("Interface Name");
            
            Label networkComputerNameLabel = new Label(layer.getNetworkcomputername());
            Label networkUserDomainLabel = new Label(layer.getNetworkuserdomain());
            Label networkRoamingProfileLabel = new Label(layer.getNetworkroamingprofile());
            Label networkMacAddressLabel = new Label(layer.getNetworkmacaddress());
            Label networkIpAddressLabel = new Label(layer.getNetworkipaddress());
            Label networkInterfaceNameLabel = new Label(layer.getNetworkinterfacename());
            
            Text ramText = new Text("Ram");
            Text ramTotalSpace = new Text("Total ram");
            Text ramFreeSpace = new Text("Free ram");

            Label ramTotalSpaceLabel = new Label(layer.getRamtotalspace() + " Gt");
            Label ramFreeSpaceLabel = new Label(layer.getRamfreespace() + " Gt");
            
            Text diskText = new Text("C disk");
            Text diskTotalSpace = new Text("Total Space");
            Text diskFreeSpace = new Text("Free Space");
            
            Label diskTotalSpaceLabel = new Label(disk.getTotalSpace() + " Gt");
            Label diskFreeSpaceLabel = new Label(disk.getFreeSpace() + " Gt");

            gridpanestatsright.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,
                                                             null,new BorderWidths(1))));
            gridpanestatsleft.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,
                                                             null,new BorderWidths(1))));
            
            gridpanestatsleft.add(osText,0,2);
            gridpanestatsleft.add(osOperatingSystem,0,3);
            gridpanestatsleft.add(osVersion,0,4);
            gridpanestatsleft.add(osArchitecture,0,5);
            gridpanestatsleft.add(osUserName,0,6);
            gridpanestatsleft.add(osUserLanguage,0,7);
            gridpanestatsleft.add(osUserCountry,0,8);
            gridpanestatsleft.add(osHomeFolder,0,9);
            
            gridpanestatsleft.add(osOperatingSystemLabel,1,3);
            gridpanestatsleft.add(osVersionLabel,1,4);
            gridpanestatsleft.add(osArchitectureLabel,1,5);
            gridpanestatsleft.add(osUserNameLabel,1,6);
            gridpanestatsleft.add(osUserLanguageLabel,1,7);
            gridpanestatsleft.add(osUserCountryLabel,1,8);
            gridpanestatsleft.add(osHomeFolderLabel,1,9);
    
            gridpanestatsleft.add(cpuText,0,11);
            gridpanestatsleft.add(cpuArchitecture,0,12);
            gridpanestatsleft.add(cpuIdentifier,0,13);
            gridpanestatsleft.add(cpuNumberOfCores,0,14);
            gridpanestatsleft.add(cpuFrequency,0,15);
            
            gridpanestatsleft.add(cpuArchitectureLabel,1,12);
            gridpanestatsleft.add(cpuIdentifierLabel,1,13);
            gridpanestatsleft.add(cpuNumberOfCoresLabel,1,14);
            gridpanestatsleft.add(cpuFrequencyLabel,1,15);
            
            
            gridpanestatsright.add(networkText,3,2);
            gridpanestatsright.add(networkComputerName,3,3);
            gridpanestatsright.add(networkUserDomain,3,4);
            gridpanestatsright.add(networkRoamingProfile,3,5);
            gridpanestatsright.add(networkMacAddress,3,6);
            gridpanestatsright.add(networkIpAddress,3,7);
            gridpanestatsright.add(networkInterfaceName,3,8);
            
            gridpanestatsright.add(networkComputerNameLabel,4,3);
            gridpanestatsright.add(networkUserDomainLabel,4,4);
            gridpanestatsright.add(networkRoamingProfileLabel,4,5);
            gridpanestatsright.add(networkMacAddressLabel,4,6);
            gridpanestatsright.add(networkIpAddressLabel,4,7);
            gridpanestatsright.add(networkInterfaceNameLabel,4,8);
            
            
            gridpanestatsright.add(ramText,3,11);
            gridpanestatsright.add(ramTotalSpace,3,12);
            gridpanestatsright.add(ramFreeSpace,3,13);
            
            gridpanestatsright.add(ramTotalSpaceLabel,4,12);
            gridpanestatsright.add(ramFreeSpaceLabel,4,13);
            
            
            
            gridpanestatsright.add(diskText,3,14);
            gridpanestatsright.add(diskTotalSpace,3,15);
            gridpanestatsright.add(diskFreeSpace,3,16);
            
            gridpanestatsright.add(diskTotalSpaceLabel,4,15);
            gridpanestatsright.add(diskFreeSpaceLabel,4,16);
            
            
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
    
    
    // Tsekataan onko käyttäjä jo databasessa ja jos ei niin lisätään.
    private void userRegister() {
        MysqlHandler handler = new MysqlHandler();        
        if (handler.isConnection()) {
            Network nw = new Network();
            if (!(nw.getMacAddress().equals(""))) {
                if (!(handler.isUserInDB(nw.getMacAddress()))) {
                    OperatingSystem os = new OperatingSystem();
                    handler.insertNewUser(nw.getMacAddress(), nw.getComputerName(), os.getUsername(), os.getUserCountry(), os.getUserLanguage());
                }
            }
        }
    }
    
}

