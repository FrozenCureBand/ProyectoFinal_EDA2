import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.txt.TXTParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
public class UneParserController implements Initializable{

	public static File Sltd_File;
	public static InputStream is;
	
	@FXML
	FileChooser fileChooser = new FileChooser();
	
	@FXML
    private TextField root_file;

    @FXML
    private Button Chooser;

    @FXML
    private Button search;

    @FXML
    private Button Index;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private TableView<String> index_Table;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt", "*.pdf"));
		
	}
    
	@FXML
	public void onClick(ActionEvent event) {
		
	    try {
	    	
	    	File file = fileChooser.showOpenDialog(null);
		    
		    root_file.setText(file.getPath().toString());
		    
		    Sltd_File = file;
		    
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "No Selected File");
			
		}
	    
	}
	
	
	@FXML
	private void StartIndex(ActionEvent event) throws IOException,SAXException, TikaException {
		
	      BodyContentHandler handler = new BodyContentHandler();
	      Metadata metadata = new Metadata();
	      FileInputStream inputstream = new FileInputStream(Sltd_File);
	      ParseContext pcontext=new ParseContext();
	      
	      TXTParser  TexTParser = new TXTParser();
	      TexTParser.parse(inputstream, handler, metadata,pcontext);
	      System.out.println("Contents of the document:" + handler.toString());
	      System.out.println("Metadata of the document:");
	      String[] metadataNames = metadata.names();
	      
	      for(String name : metadataNames) {
	         System.out.println(name + " : " + metadata.get(name));
	      }
		
	      
		}
		
    }
	

 



