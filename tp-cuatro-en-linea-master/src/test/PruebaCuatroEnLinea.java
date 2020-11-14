package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import juego.Casillero;
import juego.CuatroEnLinea;

import org.junit.Test;

public class PruebaCuatroEnLinea {

	private CuatroEnLinea juego;
    
    @Test
    public void crearConDimensionMinimaDe4Por4() {

    	juego = new CuatroEnLinea(4, 4, "Juan", "Pedro");
        
        assertEquals("filas", 4, juego.contarFilas());
        assertEquals("columnas", 4, juego.contarColumnas());
    }

    @Test
    public void crearCon7FilasPor8Columnas() {
        
        juego = new CuatroEnLinea(7, 8, "Rosario", "Pedro");
        
        assertEquals("filas", 7, juego.contarFilas());
        assertEquals("columnas", 8, juego.contarColumnas());
    }

    @Test(expected = Error.class)
    public void crearCon3FilasPor8ColumnasLanzaExcepcionPorqueTieneMenosDe4Filas() {
        
        new CuatroEnLinea(3, 8, "Juan", "Vale");
    }
    
    @Test(expected = Error.class)
    public void crearCon5FilasPor3ColumnasLanzaExcepcionPorqueTieneMenosDe4Columnas() {
        
        new CuatroEnLinea(5, 3, "Juan", "Carlos");
    }
    
    @Test
    public void inicialmenteTodosLosCasillerosEstanVacios() {
    	
    	juego = new CuatroEnLinea(5, 6, "Vale", "Rosario");
    	
    	asertarCasilleroVacioEnRango(1, 5, 1, 6);
    }

    @Test
    public void inicialmenteElJuegoNoTermino() {
        
    	juego = new CuatroEnLinea(4, 4, "Juan", "Vale");
        
        assertFalse("no terminó", juego.termino());
    }
    
    @Test
    public void inicialmenteElJuegoNoTieneGanador() {
        
    	juego = new CuatroEnLinea(4, 6, "Maria", "Laura");
        
        assertFalse("no hay ganador", juego.hayGanador());
        assertNull("no existe el ganador", juego.obtenerGanador());
    }
    
    @Test(expected = Error.class)
    public void obtenerFichaEnFila0LanzaExcepcionPorqueEstaFueraDelTablero() {
    	
    	juego = new CuatroEnLinea(4, 6, "Vero", "Laura");
    	
    	juego.obtenerCasillero(0, 3);
    }

    @Test(expected = Error.class)
    public void obtenerFichaEnColumna0LanzaExcepcionPorqueEstaFueraDelTablero() {
    	
    	juego = new CuatroEnLinea(8, 7, "Vero", "Laura");
    	
    	juego.obtenerCasillero(1, 0);
    }

    @Test(expected = Error.class)
    public void obtenerFichaEnFila9LanzaExcepcionPorqueEstaFueraDelTableroDe8Por7() {
    	
    	juego = new CuatroEnLinea(8, 7, "Vero", "Laura");
    	
    	juego.obtenerCasillero(9, 2);
    }

    @Test(expected = Error.class)
    public void obtenerFichaEnColumna7LanzaExcepcionPorqueEstaFueraDelTableroDe4Por6() {
    	
    	juego = new CuatroEnLinea(4, 6, "Julio", "Laura");
    	
    	juego.obtenerCasillero(4, 7);
    }
    
    @Test
    public void soltarPrimerFichaLlegaHastaLaUltimaFilaEnColumna3() {
    	
    	juego = new CuatroEnLinea(7, 6, "Maria", "Laura");
    	
    	juego.soltarFichaEnColumna(3);
    	
    	asertarFichaRojaEn(7, 3); 
    }
    
    @Test
    public void soltarPrimerFichaLlegaHastaLaUltimaFilaEnColumna1() {
    	
    	juego = new CuatroEnLinea(7, 6, "Maria", "Laura");
    	
    	juego.soltarFichaEnColumna(1);
    	
    	asertarFichaRojaEn(7, 1); 
    }

    @Test
    public void soltarPrimerFichaLlegaHastaLaUltimaFilaEnColumna6() {
    	
    	juego = new CuatroEnLinea(7, 6, "Juan", "Laura");
    	
    	juego.soltarFichaEnColumna(6);
    	
    	asertarFichaRojaEn(7, 6); 
    }
    
    @Test
    public void soltarSegundaFichaLlegaHastaLaUltimaFilaEnColumna4CuandoLaPrimeraEstaEnColumna6() {
    	
    	juego = new CuatroEnLinea(5, 8, "Maria", "Laura");
    	juego.soltarFichaEnColumna(6);
    	
    	juego.soltarFichaEnColumna(4);
    	
    	asertarFichaAmarillaEn(5, 4); 
    }
    
    @Test
    public void soltarSegundaFichaLlegaHastaLaUltimaFilaEnColumna1CuandoLaPrimeraEstaEnColumna9() {
    	
    	juego = new CuatroEnLinea(5, 9, "Maria", "Roberto");
    	juego.soltarFichaEnColumna(9);
    	
    	juego.soltarFichaEnColumna(1);
    	
    	asertarFichaAmarillaEn(5, 1); 
    }
    
    @Test
    public void soltarSegundaFichaQuedaEncimaDeLaAnteriorCuandoLaPrimeraTambienEstaEnColumna4() {
    	
    	juego = new CuatroEnLinea(7, 6, "Maria", "Luis");
    	juego.soltarFichaEnColumna(4);
    	
    	juego.soltarFichaEnColumna(4);
    	
    	asertarFichaRojaEn(7, 4); 
    	asertarFichaAmarillaEn(6, 4); 
    }
    
    @Test
    public void soltarSegundaFichaQuedaEncimaDeLaAnteriorCuandoLaPrimeraTambienEstaEnColumna1() {
    	
    	juego = new CuatroEnLinea(7, 6, "Maria", "Laura");
    	juego.soltarFichaEnColumna(1);
    	
    	juego.soltarFichaEnColumna(1);
    	
    	asertarFichaRojaEn(7, 1); 
    	asertarFichaAmarillaEn(6, 1); 
    }
    
    @Test
    public void soltarTerceraFichaQuedaEncimaDeLaRojaAnteriorCuandoAmbasEstanEnColumna5() {
    	
    	juego = new CuatroEnLinea(7, 6, "Maria", "Laura");
    	juego.soltarFichaEnColumna(5);
    	juego.soltarFichaEnColumna(1);
    	
    	juego.soltarFichaEnColumna(5);
    	
    	asertarFichaRojaEn(7, 5); 
    	asertarFichaRojaEn(6, 5); 
    }
    
    @Test
    public void soltarCuartaFichaQuedaEncimaDeLaAmarillaAnteriorCuandoAmbasEstanEnColumna2() {
    	
    	juego = new CuatroEnLinea(8, 6, "Agus", "Leo");
    	juego.soltarFichaEnColumna(5);
    	juego.soltarFichaEnColumna(2);
    	juego.soltarFichaEnColumna(4);
    	
    	juego.soltarFichaEnColumna(2);
    	
    	asertarFichaAmarillaEn(8, 2); 
    	asertarFichaAmarillaEn(7, 2); 
    }
    
    @Test
    public void soltarCuartaFichaQuedaEncimaDeLasOtrasCuandoTodasEstanEnColumna4() {
    	
    	juego = new CuatroEnLinea(4, 4, "Fabi", "Andy");
    	juego.soltarFichaEnColumna(1);
    	juego.soltarFichaEnColumna(1);
    	juego.soltarFichaEnColumna(1);
    	
    	juego.soltarFichaEnColumna(1);
    	
    	asertarFichaAmarillaEn(1, 1); 
    }
    
    @Test
    public void soltarCuartaFichaQuedaEncimaDeLasOtrasCuandoTodasEstanEnColumna1() {
    	
    	juego = new CuatroEnLinea(4, 4, "Fabi", "Andy");
    	juego.soltarFichaEnColumna(4);
    	juego.soltarFichaEnColumna(4);
    	juego.soltarFichaEnColumna(4);
    	
    	juego.soltarFichaEnColumna(4);
    	
    	asertarFichaAmarillaEn(1, 4); 
    }
    
    @Test
    public void soltarFichasHastaCompletarElTablero() {
    	
    	juego = new CuatroEnLinea(4, 4, "Fabi", "Lucas");

    	fueronSoltadasFichasEnColumnas(1,2,3,4, 4,3,2,1, 1,2,3,4, 1,2,3,4);
    	
    	asertarFichaRojaEn(1, 1);
    	asertarFichaAmarillaEn(1, 2);
    	asertarFichaRojaEn(1, 3);
    	asertarFichaAmarillaEn(1, 4);
    }
    
    private void fueronSoltadasFichasEnColumnas(int... columnas) {

    	for (int columna : columnas) {
    		juego.soltarFichaEnColumna(columna);
    	}
    }
    
    private void asertarCasilleroEn(int fila, int columna, Casillero casillero) {
        
        assertEquals("casillero (" + fila + ", " + columna + ")", 
                     casillero, juego.obtenerCasillero(fila, columna));
    }
    
    private void asertarCasilleroEnRango(int filaDesde, int columnaDesde, 
    									int filaHasta, int columnaHasta, Casillero casillero) {

        for (int fila = filaDesde; fila <= filaHasta; fila++) {
            
            for (int columna = columnaHasta; columna <= columnaHasta; columna++) {
                
                asertarCasilleroEn(fila, columna, casillero);
            }
        }
    }
    
    private void asertarCasilleroVacioEnRango(int filaDesde, int filaHasta, 
    										int columnaDesde, int columnaHasta) {
        
        asertarCasilleroEnRango(filaDesde, columnaDesde, filaHasta, columnaHasta, Casillero.VACIO);
    }
    
    private void asertarFichaRojaEn(int fila, int columna) {
        
        asertarCasilleroEn(fila, columna, Casillero.ROJO);
    }
    
    private void asertarFichaAmarillaEn(int fila, int columna) {
        
        asertarCasilleroEn(fila, columna, Casillero.AMARILLO);
    }
}
