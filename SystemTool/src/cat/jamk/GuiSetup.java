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
        Scene scene = new Scene(root, 640, 480, Color.LIGHTGRAY);
        
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
            cpupage.setText("Cpu");
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
            gridpanestats.setAlignment(Pos.CENTER);
  
            //gridpanestats.setAlignment(Pos.CENTER);
            stats.setContent(gridpanestats);
            
        
            
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
            
            
            VBox statsbox1 = new VBox();
            statsbox1.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.DASHED,
                                                             null,new BorderWidths(3))));
            gridpanestats.add(statsbox1,0,1);
            gridpanestats.add(osText,0,2);
            gridpanestats.add(osOperatingSystem,0,3);
            gridpanestats.add(osVersion,0,4);
            gridpanestats.add(osArchitecture,0,5);
            gridpanestats.add(osUserName,0,6);
            gridpanestats.add(osUserLanguage,0,7);
            gridpanestats.add(osUserCountry,0,8);
            gridpanestats.add(osHomeFolder,0,9);
            
            gridpanestats.add(osOperatingSystemLabel,1,3);
            gridpanestats.add(osVersionLabel,1,4);
            gridpanestats.add(osArchitectureLabel,1,5);
            gridpanestats.add(osUserNameLabel,1,6);
            gridpanestats.add(osUserLanguageLabel,1,7);
            gridpanestats.add(osUserCountryLabel,1,8);
            gridpanestats.add(osHomeFolderLabel,1,9);
    
            gridpanestats.add(cpuText,0,11);
            gridpanestats.add(cpuArchitecture,0,12);
            gridpanestats.add(cpuIdentifier,0,13);
            gridpanestats.add(cpuNumberOfCores,0,14);
            gridpanestats.add(cpuFrequency,0,15);
            
            gridpanestats.add(cpuArchitectureLabel,1,12);
            gridpanestats.add(cpuIdentifierLabel,1,13);
            gridpanestats.add(cpuNumberOfCoresLabel,1,14);
            gridpanestats.add(cpuFrequencyLabel,1,15);
            
            
            gridpanestats.add(networkText,3,2);
            gridpanestats.add(networkComputerName,3,3);
            gridpanestats.add(networkUserDomain,3,4);
            gridpanestats.add(networkRoamingProfile,3,5);
            gridpanestats.add(networkMacAddress,3,6);
            gridpanestats.add(networkIpAddress,3,7);
            gridpanestats.add(networkInterfaceName,3,8);
            
            gridpanestats.add(networkComputerNameLabel,4,3);
            gridpanestats.add(networkUserDomainLabel,4,4);
            gridpanestats.add(networkRoamingProfileLabel,4,5);
            gridpanestats.add(networkMacAddressLabel,4,6);
            gridpanestats.add(networkIpAddressLabel,4,7);
            gridpanestats.add(networkInterfaceNameLabel,4,8);
            
            
            gridpanestats.add(ramText,3,11);
            gridpanestats.add(ramTotalSpace,3,12);
            gridpanestats.add(ramFreeSpace,3,13);
            
            gridpanestats.add(ramTotalSpaceLabel,4,12);
            gridpanestats.add(ramFreeSpaceLabel,4,13);
            
            
            
            gridpanestats.add(diskText,3,14);
            gridpanestats.add(diskTotalSpace,3,15);
            gridpanestats.add(diskFreeSpace,3,16);
            
            gridpanestats.add(diskTotalSpaceLabel,4,15);
            gridpanestats.add(diskFreeSpaceLabel,4,16);
            
            
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

