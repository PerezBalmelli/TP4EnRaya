package juego;

/**
 * Juego Cuatro en Lí­nea
 * 
 * Reglas:
 * 
 * 		...
 *
 */
public class CuatroEnLinea {
	private boolean turno = true;
	
	private Casillero[][] tablero;
	

	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4.
	 * post: empieza el juego entre el jugador que tiene fichas rojas, identificado como 
	 * 		 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 		 'jugadorAmarillo'. 
	 * 		 Todo el tablero está vacío.
	 * 
	 * @param filas : cantidad de filas que tiene el tablero.
	 * @param columnas : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo : nombre del jugador con fichas amarillas.
	 */
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo, String jugadorAmarillo) {
		tablero = new Casillero[esValido(filas)][esValido(columnas)];
		todosVacios();
		
	}
	
		/**
	 * post: Analiza si el "numeroCandidato" es menor que 4 y mayor que 15, si
	 * NO lo es, lo toma como valido y sino lo descarta.
	 * 
	 * @param numeroCandidato
	 *            : numero candidato a columnas y filas máxima
	 * @return devuelve numeroCandidato si cumple la condición
	 */
	private int esValido(int numeroCandidato) {
		if (numeroCandidato < 4 || numeroCandidato > 15) {
			throw new Error("El numero de columnas y filas"
					+ " deben ser mayor de 4 y menor de 15");
		}
		return numeroCandidato;
	}
	
	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden apilar en el tablero.
	 */
	public int contarFilas() {
		return tablero.length;
	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden alinear en el tablero.
	 */
	public int contarColumnas() {
		
		return tablero[0].length;
	}

		/**
	 * pre : fila está en el intervalo [1, contarFilas()], columnas está en el
	 * intervalo [1, contarColumnas()]. post: indica qué ocupa el casillero en
	 * la posición dada por fila y columna.
	 * 
	 * @param fila
	 *            : número de fila solicitado
	 * @param columna
	 *            : número de columna solicitado
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		condicionParafila(fila);
		condicionParaColumna(columna);

		return tablero[fila - 1][columna - 1];

		/**
	 * Post: Genera que todos los casilleros se inicialicen en VACIO
	 */
	private void todosVacios() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++)
				tablero[i][j] = Casillero.VACIO;
		}
	}
		
		/**
	 * Post : Analiza si el número de fila sobrepasa la cantidad de filas
	 * máximas que tiene el tablero
	 * 
	 * @param fila
	 *            : número de fila solicitada
	 */
	private void condicionParafila(int fila) {
		if (fila < 1 || fila > tablero.length) {
			throw new Error("La fila que está buscando no existe");
		}
	}

	/**
	 * Post : Analiza si el número de columna sobrepasa la cantidad de columnas
	 * máximas que tiene el tablero
	 * 
	 * @param columna
	 *            : número de columna solicitada
	 */
	private void condicionParaColumna(int columna) {
		if (columna < 1 || columna > tablero[0].length) {
			throw new Error("La columna que está buscando no existe");
		}
	}

	
	/**
	 * pre : el juego no terminó, columna está en el intervalo [1, contarColumnas()]
	 * 		 y aún queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna : número de columna en la que se quiere soltar ficha
	 */
	public void soltarFichaEnColumna(int columna) {
	condicionParaColumna(columna);	
	int i= 0;	
	
	while(i < contarFilas() && tablero[i][columna -1] == Casillero.VACIO){
		i++;
	}
	if((i-1) >=0){
		if(turno == true){
			tablero[i-1][columna-1] = Casillero.ROJO;
			turno = false;
		} else{
			tablero[i-1][columna-1] = Casillero.AMARILLO;
			turno = true;
		}
	} else {
		throw new Error("La columna ya esta llena, intente con otra");
	
	}
		
	}
	
	/**
	 * post: indica si el juego terminó porque uno de los jugadores
	 * 		 ganó o no existen casilleros vacíos.
	 */
	public boolean termino() {
		
		return false;
	}

	/**
	 * post: indica si el juego terminó y tiene un ganador.
	 */
	public boolean hayGanador() {
		
		return false;
	}

	/**
	 * pre : el juego terminó.
	 * post: devuelve el nombre del jugador que ganó el juego.
	 */
	public String obtenerGanador() {
		
		return null;
	}
}
