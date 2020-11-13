package dad.AdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
	
	private Label texto; //para texto
	private TextField cuadroTexto; //para cuadro de texto
	private Button boton;
	int intentos = 0;
	int numero = (int) (Math.random()*(100-1)+1); //genera numeros del 1 al 100
	Alert alert = new Alert(AlertType.INFORMATION);
	Alert warning = new Alert(AlertType.WARNING);
	Alert error = new Alert(AlertType.ERROR);

	@Override
	public void start(Stage primaryStage) throws Exception {
		texto = new Label("Introduce un numero del 1 al 100");
		cuadroTexto = new TextField();
		cuadroTexto.setMaxWidth(150); //150 es lo normal
		cuadroTexto.setPromptText("0"); //para que se vea algo dentro del cuadro de texto
		boton = new Button("Comprobar"); //podemos hacer que dandole al enter directamente 
										// pinche el boton boton.setdefault...
		boton.setOnAction(e -> onComprobarAction(e)); //ejecuta la funcion cada vez que pulsas el boton
		
		VBox root = new VBox();  //caja donde metemos todo
		root.getChildren().addAll(texto, cuadroTexto, boton);
		root.setAlignment(Pos.CENTER); //setAlignment es para poner las posiciones de cualquier elemento
		
		Scene scene = new Scene(root, 480, 320); //caja mas su tamaño
		
		primaryStage.setTitle("AdivinApp"); //nombre de arriba de la caja
		primaryStage.setScene(scene); //mostrar caja
		primaryStage.show();
		

	}
	
	public void onComprobarAction (ActionEvent e) {
		
		int n = Integer.parseInt(cuadroTexto.getText()); //para recoger los datos
		
		alert.setTitle("AdivinApp");
		alert.setHeaderText("Has ganado");
		
		warning.setTitle("AdivinApp");
		warning.setHeaderText("¡Has fallado!");
		
		error.setTitle("AdivinApp");
		error.setHeaderText("Error");
		
		try {
			if (n < 1 || n > 100) {
				intentos++;
				error.setContentText("El número introducido no es valido");
				error.showAndWait();
				} else if (numero == n){
					intentos ++;
					alert.setContentText("Solo has necesitado "+intentos+" intentos");
					alert.showAndWait();
					numero = (int) (Math.random()*(100-1)+1);
					}else if(n > numero) {
						intentos++;
						warning.setContentText("El numero a adivinar es menos que "+n);
						warning.showAndWait();
					}else if(n < numero) {
						intentos++;
						warning.setContentText("El numero a adivinar es mayor que "+n);
						warning.showAndWait();
					}
		}catch(NumberFormatException a){
		
		}
		
	}

	public static void main(String[] args) {
		
		launch(args); //lanza aplicacion

	}

}
