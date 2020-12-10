package juego;

/**
 * Juego Cuatro en Linea
 * 
 * Reglas:
 * 
 * 		...
 *
 */
public class CuatroEnLinea {
	private boolean turno = true;
	
	String nombreJugadorRojo = "Rojo";
	String nombreJugadorAmarillo = "Amarillo";
	
	int columnaUltimaFicha;
	int filaUltimaFicha;
	
	private Casillero[][] tablero;
	

	/**
	 * pre : 'filas' y 'columnas' son mayores o iguales a 4. post: empieza el
	 * juego entre el jugador que tiene fichas rojas, identificado como
	 * 'jugadorRojo' y el jugador que tiene fichas amarillas, identificado como
	 * 'jugadorAmarillo'. Todo el tablero esta vacio.
	 * 
	 * @param filas
	 *            : cantidad de filas que tiene el tablero.
	 * @param columnas
	 *            : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo
	 *            : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo
	 *            : nombre del jugador con fichas amarillas.
	 */
	public CuatroEnLinea(int filas, int columnas, String jugadorRojo,
			String jugadorAmarillo) {
		tablero = new Casillero[esValido(filas)][esValido(columnas)];
		todosVacios();

		nombreJugadorRojo = jugadorRojo;
		nombreJugadorAmarillo = jugadorAmarillo;

	}

	/**
	 * post: devuelve la cantidad maxima de fichas que se pueden apilar en el
	 * tablero.
	 */
	public int contarFilas() {
		return tablero.length;
	}

	/**
	 * post: devuelve la cantidad maxima de fichas que se pueden alinear en el
	 * tablero.
	 */
	public int contarColumnas() {

		return tablero[0].length;
	}

	/**
	 * pre : fila esta en el intervalo [1, contarFilas()], columnas esta en el
	 * intervalo [1, contarColumnas()]. post: indica que ocupa el casillero en
	 * la posicion dada por fila y columna.
	 * 
	 * @param fila
	 *            : numero de fila solicitado
	 * @param columna
	 *            : numero de columna solicitado
	 */
	public Casillero obtenerCasillero(int fila, int columna) {
		condicionParafila(fila);
		condicionParaColumna(columna);

		return tablero[fila - 1][columna - 1];
	}

	/**
	 * pre : el juego no termino, columna esta en el intervalo [1,
	 * contarColumnas()] y aun queda un Casillero.VACIO en la columna indicada.
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna
	 *            : numero de columna en la que se quiere soltar ficha
	 */
	public void soltarFichaEnColumna(int columna) {

		condicionParaColumna(columna);
		comprobarSiElJuegoTermino();

		int i = 0;

		while (i < contarFilas() && tablero[i][columna - 1] == Casillero.VACIO) {
			i++;
		}

		if ((i - 1) >= 0) {
			if (turno == true) {
				tablero[i - 1][columna - 1] = Casillero.ROJO;
				turno = false;
			} else {
				tablero[i - 1][columna - 1] = Casillero.AMARILLO;
				turno = true;
			}
		} else {
			throw new Error("La columna ya esta llena, intente con otra");

		}
		columnaUltimaFicha = columna - 1;
		filaUltimaFicha = i - 1;

	}

	/**
	 * post: indica si el juego termino porque uno de los jugadores gano o no
	 * existen casilleros vacios.
	 */

	public boolean termino() {

		return hayGanador() || noHayCasillerosLibres();
	}

	/**
	 * post: indica si el juego termino y tiene un ganador.
	 */
	public boolean hayGanador() {

		return hayGanadorPorDiagonalIzquierdaADerecha()
				|| hayGanadorPorDiagonalDerechaAIzquierda()
				|| hayGanadorPorColumna() || hayGanadorPorFila();
	}

	/**
	 * pre : el juego termino. post: devuelve el nombre del jugador que gano el
	 * juego.
	 */
	public String obtenerGanador() {
		String ganador = null;
		if (termino() && hayGanador()) {
			if (!turno) {
				ganador = nombreJugadorRojo;
			} else {
				ganador = nombreJugadorAmarillo;
			}

		}
		return ganador;
	}

	// METODOS PRIVADOS

	/**
	 * post: Analiza si el "numeroCandidato" es menor que 4 y mayor que 15, si
	 * NO lo es, lo toma como valido y sino lo descarta.
	 * 
	 * @param numeroCandidato
	 *            : numero candidato a columnas y filas maxima
	 * @return devuelve numeroCandidato si cumple la condicion
	 */
	private int esValido(int numeroCandidato) {
		if (numeroCandidato < 4 || numeroCandidato > 15) {
			throw new Error("El numero de columnas y filas"
					+ " deben ser mayor de 4 y menor de 15");
		}
		return numeroCandidato;
	}

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
	 * Pre : Fila debe estar en el intervalo [1 ; contarFilas()] Post : Analiza
	 * si el numero de fila se pasa del rango establecido, si es asi lanza un
	 * error.
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
	 * Pre : Columna debe estar en el intervalo [1 ; contarColumnas()] Post :
	 * Analiza si el numero de columna se pasa del rango establecido, si es asi
	 * lanza un error.
	 * 
	 * @param columna
	 *            : numero de columna solicitada
	 */
	private void condicionParaColumna(int columna) {
		if (columna < 1 || columna > tablero[0].length) {
			throw new Error("La columna que esta buscando no existe");
		}
	}

	/**
	 * Post : Analiza si el metodo termino() es igual a true, si es asi, lanza
	 * un error.
	 */
	private void comprobarSiElJuegoTermino() {
		if (termino()) {
			throw new Error(
					"El juego ha finalizado, empieza una nueva partida.");
		}
	}

	/**
	 * post: indica si queda algun casillero libre o el tablero esta lleno.
	 */
	private boolean noHayCasillerosLibres() {
		int i = 0;
		while (i < contarColumnas() && tablero[0][i] != Casillero.VACIO) {
			i++;
		}

		return i == contarColumnas();
	}

	/**
	 * Post : Analiza horizontalmente si las fichas contiguas distintas a VACIO
	 * suman 4.
	 * 
	 * @return devuelve True si fichasContiguas es igual a 4
	 */
	private boolean hayGanadorPorFila() {

		int fichasContiguas = 0;

		int columna = 0;

		while (fichasContiguas < 4 && columna < contarColumnas()) {

			if (tablero[filaUltimaFicha][columna] == tablero[filaUltimaFicha][columnaUltimaFicha]
					&& tablero[filaUltimaFicha][columna] != Casillero.VACIO) {

				fichasContiguas++;

			} else {

				fichasContiguas = 0;

			}

			columna++;

		}

		return fichasContiguas == 4;

	}

	/**
	 * Post : Analiza verticalmente si las fichas contiguas distintas a VACIO
	 * suman 4.
	 * 
	 * @return devuelve True si fichasContiguas es igual a 4
	 */

	private boolean hayGanadorPorColumna() {

		int fichasContiguas = 0;

		int fila = contarFilas() - 1;

		while (fichasContiguas < 4 && fila >= 0
				&& tablero[fila][columnaUltimaFicha] != Casillero.VACIO) {

			if (tablero[fila][columnaUltimaFicha] == tablero[filaUltimaFicha][columnaUltimaFicha]) {

				fichasContiguas++;

			} else {

				fichasContiguas = 0;

			}

			fila--;

		}

		return fichasContiguas == 4;

	}

	/**
	 * Post : Analiza si las fichas contiguas en diagonal(izquierda a derecha)
	 * distintas a VACIO suman 4.
	 * 
	 * @return devuelve True si fichasContiguas es igual a 4
	 */
	private boolean hayGanadorPorDiagonalIzquierdaADerecha() {

		int fichasContiguas = 0;

		int fila = filaUltimaFicha;
		int columna = columnaUltimaFicha;

		if (tablero[filaUltimaFicha][columnaUltimaFicha] != Casillero.VACIO) {

			while (fila > 0 && columna > 0) {
				fila--;
				columna--;
			}

			while (fichasContiguas < 4 && fila < contarFilas()
					&& columna < contarColumnas()) {

				if (tablero[fila][columna] == tablero[filaUltimaFicha][columnaUltimaFicha]) {

					fichasContiguas++;

				} else {

					fichasContiguas = 0;

				}

				fila++;
				columna++;

			}
		}

		return fichasContiguas == 4;

	}

	/**
	 * Post : Analiza si las fichas contiguas en diagonal(derecha a izquierda)
	 * distintas a VACIO suman 4.
	 * 
	 * @return devuelve True si fichasContiguas es igual a 4
	 */
	private boolean hayGanadorPorDiagonalDerechaAIzquierda() {

		int fichasContiguas = 0;

		int fila = filaUltimaFicha;
		int columna = columnaUltimaFicha;

		if (tablero[filaUltimaFicha][columnaUltimaFicha] != Casillero.VACIO) {

			while (fila > 0 && columna < contarColumnas() - 1) {
				fila--;
				columna++;
			}

			while (fichasContiguas < 4 && fila < contarFilas() && columna > -1) {

				if (tablero[fila][columna] == tablero[filaUltimaFicha][columnaUltimaFicha]) {

					fichasContiguas++;

				} else {

					fichasContiguas = 0;

				}

				fila++;
				columna--;

			}
		}

		return fichasContiguas == 4;

	}


}
