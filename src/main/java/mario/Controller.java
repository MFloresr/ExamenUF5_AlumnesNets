package mario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import jdk.internal.util.xml.impl.Input;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    @FXML
    private Button btnclase;
    @FXML
    private Button btnscanner;
    @FXML
    private ListView listasucios;
    @FXML
    private ListView listalimpios;
    @FXML
    private CheckBox checkbox;
    @FXML
    private Label idclase;
    //private ObservableList<String> items = FXCollections.observableArrayList ();
    //private File fichero = new File (".","fichero.txt");
    Clase aula=new Clase();
    Alert alert = new Alert(Alert.AlertType.WARNING);

    //aqui abrimos el fichero txt
    @FXML
    public void CargarClase(Event event){
        FileChooser fichero= new FileChooser();
        fichero.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        File archivoEscogido = fichero.showOpenDialog(null);
        System.out.println(archivoEscogido);
        try {
            FileReader fr=new FileReader(archivoEscogido);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            int contador =0;
            //aqui procesamos esos alumnmos
            ArrayList<String> alumnos=new ArrayList<String>();
            while((linea=br.readLine())!=null){
                if(!linea.contains("-")){
                    if (contador==0){
                        aula.setClase(linea);
                    }else{
                        alumnos.add(linea);
                    }
                }
                contador=contador+1;
            }

            for(int i = 0 ;i<alumnos.size();i++){
                System.out.println(alumnos.get(i));
            }
            aula.setAlumnos(alumnos);
            idclase.setText(aula.getClase());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //aqui nos conectamos al servidor para coger los datos de las personas con quien compararemos posteriormente
    @FXML
    public void ComprovarScanner(Event event){
        try {
            org.jsoup.nodes.Document doc = Jsoup.connect("http://192.168.0.19:4567/resultat").get();
            Elements noms = doc.select("resultat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}