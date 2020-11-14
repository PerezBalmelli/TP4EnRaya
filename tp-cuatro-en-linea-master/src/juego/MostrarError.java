package juego;

import java.lang.Thread.UncaughtExceptionHandler;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Captura errores en tiempo de ejecución y muestra una ventana con el detalle.
 */
public class MostrarError implements UncaughtExceptionHandler {
	
	@Override
	public void uncaughtException(Thread hilo, Throwable error) {

		Stage escenario = new Stage();
		
		Text mensaje = new Text(error.getMessage());
		
		BorderPane panel = new BorderPane();
		panel.setPadding(new Insets(10,20,20,10));
		panel.setCenter(mensaje);

		Scene escena = new Scene(panel);

		escenario.setScene(escena);
		escenario.setResizable(false);
		escenario.setTitle("Error");
		escenario.show();
	}

}
