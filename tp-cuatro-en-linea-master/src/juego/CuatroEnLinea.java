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
	 * post: Analiza si el "numeroCandidato" es mayor que 3 y menor que 99, si lo es,
	 * 		 lo toma como valido y sino lo descarta.
	 */
	private int esValido(int numeroCandidato){
		if(numeroCandidato < 3 || numeroCandidato > 99){
			throw new Error("El numero de columnas y filas"
					+ " deben ser mayor de 3 y menor de 100");
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
	 * pre : fila está en el intervalo [1, contarFilas()],
	 * 		 columnas está en el intervalo [1, contarColumnas()].
	 * post: indica qué ocupa el casillero en la posición dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	
	
	public Casillero obtenerCasillero(int fila, int columna) {

		if (fila < 1 || fila > tablero.length || columna < 1
				|| columna > tablero[0].length) {
			throw new Error("El casillero que está buscando no existe");
		}

		return tablero[fila - 1][columna - 1];

	}
	
	public void todosVacios(){
		for(int i = 0; i < tablero.length; i++){
			for(int j = 0; j < tablero[i].length; j++)
				tablero[i][j] = Casillero.VACIO;
		}
	}
	
	/**
	 * pre : el juego no terminó, columna está en el intervalo [1, contarColumnas()]
	 * 		 y aún queda un Casillero.VACIO en la columna indicada. 
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna
	 */
	public void soltarFichaEnColumna(int columna) {
		
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
		Error ColumnaCompleta = new Error("La columna ya esta llena, intente con otra");
		throw ColumnaCompleta;
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
