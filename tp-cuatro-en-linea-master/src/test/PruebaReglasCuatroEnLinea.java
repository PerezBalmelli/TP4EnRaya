package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import juego.CuatroEnLinea;

public class PruebaReglasCuatroEnLinea {

	private CuatroEnLinea juego;
@Test
	public void noGananLasRojasConFila6Desde1Hasta4PorqueBloqueronLasAmarillas() {
		
		juego = new CuatroEnLinea(6, 5, "Fabi", "Lucas");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);

		juego.soltarFichaEnColumna(4);

		asertarQueNoHayGanadorAun();
	}
	
	@Test
	public void gananRojasConFila6Desde1Hasta4() {
		
		juego = new CuatroEnLinea(6, 5, "Fabi", "Lucas");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(3);

		juego.soltarFichaEnColumna(4);

		asertarQueElGanadorEs("Fabi");
	}
	
	@Test
	public void gananAmarillasConFila5Desde2Hasta3() {
		
		juego = new CuatroEnLinea(6, 5, "Fabi", "Lucas");
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(2);
		
		juego.soltarFichaEnColumna(5);

		asertarQueElGanadorEs("Lucas");
	}
	
	@Test
	public void noGananLasRojasConColumna5PorqueBloqueronLasAmarillas() {
		
		juego = new CuatroEnLinea(6, 10, "Leo", "Lucas");
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(7);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(7);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(5);

		juego.soltarFichaEnColumna(5);

		asertarQueNoHayGanadorAun();
	}

	@Test
	public void gananRojasConColumna3Desde1Hasta4() {
		
		juego = new CuatroEnLinea(7, 9, "Agus", "Fabi");
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);

		juego.soltarFichaEnColumna(3);

		asertarQueElGanadorEs("Agus");
	}
	
	@Test
	public void gananAmarillasConColumna2Desde2Hasta5() {
		
		juego = new CuatroEnLinea(7, 9, "Vero", "Fabi");
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);

		juego.soltarFichaEnColumna(2);

		asertarQueElGanadorEs("Fabi");
	}
	
	
	@Test
	public void gananRojasConDiagonalDesdeFila1HastaFila4() {
		
		juego = new CuatroEnLinea(5, 5, "Gabi", "Lucas");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(5);
		
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);

		juego.soltarFichaEnColumna(4);

		asertarQueElGanadorEs("Gabi");
	}
	
	@Test
	public void aunNoGananRojasConDiagonalDesdeFila4HastaFila2() {
		
		juego = new CuatroEnLinea(5, 5, "Fer", "Nico");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(3);

		juego.soltarFichaEnColumna(2);

		asertarQueNoHayGanadorAun();
	}
	
	@Test
	public void gananRojasConDiagonalDesdeFila4HastaFila1() {
		
		juego = new CuatroEnLinea(5, 5, "Fer", "Nico");
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(5);
		juego.soltarFichaEnColumna(4);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);
		juego.soltarFichaEnColumna(1);
		juego.soltarFichaEnColumna(3);
		juego.soltarFichaEnColumna(2);

		juego.soltarFichaEnColumna(2);

		asertarQueElGanadorEs("Fer");
	}
	
	@Test
	public void gananRojasConDiagonalDesdeColumna6Fila6HastaColumna3Fila3() {
		
		juego = new CuatroEnLinea(7, 7, "Jime", "Nico");
		fueronSoltadasFichasEnColumnas(2,4,5,3,5,6,6,3,3,4,5,4,2,2,3,5,4,5,6,6,5,4);

		juego.soltarFichaEnColumna(3);
		
		asertarQueElGanadorEs("Jime");
	}

	@Test
	public void gananRojasConDiagonalDesdeColumna4Fila7HastaColumna7Fila4() {
		
		juego = new CuatroEnLinea(7, 9, "Marce", "Nati");
		fueronSoltadasFichasEnColumnas(3,7,4,5,2,1,5,4,3,4,2,6,8,6,3,3,2,2,4,5,6,7,8,7);

		juego.soltarFichaEnColumna(7);
		
		asertarQueElGanadorEs("Marce");
	}
	
	@Test
	public void empatanEnTableroDe5Por6() {
		juego = new CuatroEnLinea(5, 6, "Jime", "Nico");
		fueronSoltadasFichasEnColumnas(1,2,3,4,5,6,6,5,4,3,2,1,6,5,4,3,2,1,1,2,3,4,5,6,1,2,3,4,5);
		juego.soltarFichaEnColumna(6);
		asertarQueEmpataron();
	}

         @Test
	public void empatanEnTableroDe7Por7(){
		juego = new CuatroEnLinea(7, 7, "Nati", "Fabi");
		fueronSoltadasFichasEnColumnas(1,4,7,1,2,3,2,5,6,1,3,3,4,5,2,2,1,4,5,7,3,7,7,4,
				6,5,4,5,3,5,5,6,6,7,2,1,3,3,2,6,6,1,2,1,7,7,4,4,6);
		asertarQueEmpataron();
	}
	
	@Test
	public void empatanEnTableroDe4Por4() {
		juego = new CuatroEnLinea(4, 4, "Nati", "Fabi");
		fueronSoltadasFichasEnColumnas(1,2,3,4,4,3,2,1,4,3,2,1,4,3,2);
		juego.soltarFichaEnColumna(1);
		asertarQueEmpataron();
	}
	
	private void asertarQueEmpataron() {
		
		assertTrue("terminó", juego.termino());
		assertFalse("no hay ganador", juego.hayGanador());
		assertNull("ganador", juego.obtenerGanador());
	}
	
	private void asertarQueElGanadorEs(String ganadorEsperado) {
		
		assertTrue("terminó", juego.termino());
		assertTrue("hay ganador", juego.hayGanador());
		assertEquals("ganador", ganadorEsperado, juego.obtenerGanador());
	}
	
	private void asertarQueNoHayGanadorAun() {
		
		assertFalse("terminó", juego.termino());
		assertFalse("no hay ganador", juego.hayGanador());
		assertNull("ganador", juego.obtenerGanador());
	}
	
    private void fueronSoltadasFichasEnColumnas(int... columnas) {

    	for (int columna : columnas) {
    		juego.soltarFichaEnColumna(columna);
    	}
    }

}
