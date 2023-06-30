/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijacampi.GUI;

import ijacampi.Entities.Utilisateur;
import ijacampi.Entities.Commande;
import ijacampi.Entities.Equipement;
import ijacampi.Entities.LigneCommande;
import ijacampi.Services.CommandeService;
import ijacampi.Services.EquipementService;
import ijacampi.Services.LigneCommandeService;
import ijacampi.Tests.MyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.layout.Region;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author brahim
 */
public class StoreInterfaceController implements Initializable {
   private EquipementService es;
   private LigneCommandeService lcs;
   private Utilisateur camper=new Utilisateur();
   private LigneCommande LigneCommande;
    private static int current_id=0;
    private CommandeService cs;
    private static List panier=new ArrayList();
    private MyListener myListener;
    private Commande commande;
    @FXML
    private VBox chosenEquipementCard;
    @FXML
    private Label EqNameLable;
    @FXML
    private Label EqPriceLabel;
    @FXML
    private ImageView EquipementImg;
    @FXML
    private Label EqMarqLabel;
    @FXML
    private Label MarqLabelvalue;
    
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Button BtnCommander;
    @FXML
    private TextField quantiteTextField;
    @FXML
    private BorderPane bp;

    /**
     * Initializes the controller class.
     */
    private void setChosenEquipement(Equipement e) {
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        String colorCode = String.format("#%06x", rand_num);
        EqNameLable.setText(e.getNom());
        EqPriceLabel.setText(String.valueOf(e.getPrix()) + " " + "TND");
        MarqLabelvalue.setText(e.getMarque());
        chosenEquipementCard.setStyle("-fx-background-color:" + colorCode + ";\n"
                + "    -fx-background-radius: 30;");
    
    }
    private void loadPage(String page, Commande c) {
        /* FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EquipementFxml.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EquipementFxmlController equipemementController = fxmlLoader.getController();
                // itemController.setData(fruits.get(i),myListener);
                equipemementController.setData(equipements.getall().get(i), myListener);*/
        Parent root = null;
  FXMLLoader fxmlLoader = new FXMLLoader();
  ListCommandeController ListCommandeController =fxmlLoader.getController();
  
  fxmlLoader.setLocation(getClass().getResource(page+".fxml"));
  
        try {
            //ListCommandeController.SetData(c);
           // 
             ListCommandeController.SetData(c); 
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
               
        } catch (IOException ex) {
            ex.getMessage();
        }
       
        bp.setCenter(root);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // fruits.addAll(getData());
        EquipementService equipements = new EquipementService();
        if (equipements.getall().size() > 0) {
            //  setChosenFruit(fruits.get(0));
            setChosenEquipement(equipements.getall().get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Equipement e) {
                    setChosenEquipement(e);
                   StoreInterfaceController.current_id=e.getId();
                }
            };
        }
        
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < equipements.getall().size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EquipementFxml.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EquipementFxmlController equipemementController = fxmlLoader.getController();
                // itemController.setData(fruits.get(i),myListener);
                equipemementController.setData(equipements.getall().get(i), myListener);
                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void ajouterLigneCommande(ActionEvent event) {
        EquipementService es = new EquipementService();
        CommandeService cs =new CommandeService();
        LigneCommandeService lcs=new LigneCommandeService();
        Equipement e=es.getall().get(current_id);
        camper.setId(1);
      //  System.out.println(camper.getId());
      
       Date systemDate = Date.valueOf(java.time.LocalDate.now());
        Commande c=new Commande(camper,systemDate,"none",0f,"none");
        int id_commande = cs.add(c);
        c.setId(id_commande);
       LigneCommande lc=new LigneCommande(Integer.parseInt(quantiteTextField.getText()),e,c);
        System.out.println(lc.toString());
       lcs.Ajouter(lc);    
       this.commande=c;
       this.LigneCommande=lc;
    }

    @FXML
    private void ListCommande(MouseEvent event) {
        
    //EquipementFxmlController equipemementController = fxmlLoader.getController();                 
    //ListCommandeController.SetData(commande);
        System.out.println(commande.toString());
        loadPage("ListCommande",this.commande);
    //ListCommandeController ListCommandeController =fxmlLoader.getController();
    //ListCommandeController.SetData(this.commande);
    
    }

}
