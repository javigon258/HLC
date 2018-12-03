package com.example.javig.proyecto3_conecta4;

public class Game {

    int[][] table; //Tablero de juego
    int turno;

    static final int numeroF = 6; //Filas
    static final int numeroC = 7; //Columnas
    static final int vacio = 0; //Vacio
    static final int IA = 1; //Maquina
    static final int player = 2; //Jugador
    static final String IAWin = "1111"; //Gana la maquina
    static final String playerWin = "2222"; //Gana el jugador
    static final String PatternWin_1 = "222"; //Patron con el que casi ganas

    String estado = "play";
    String ganador = "";

    public Game(int player) {

        table = new int[numeroF][numeroC];
        setTurno(player);
        iniciarTable();
    }

    private void iniciarTable() {
        for (int i = 0; i < numeroF; i++) {
            for (int j = 0; j < numeroC; j++) {
                table[i][j] = vacio;
            }
        }
    }

    public int getTurno() {
        return turno;
    }

    private void setTurno(int turno) {
        this.turno = turno;
    }

    public void cambiarTurno() {

        if (getTurno() == player) {
            turno = IA;
        } else {
            turno = player;
        }
    }

    public boolean isVacio(int i, int j) {
        return table[i][j] == vacio;
    }

    public void setFicha(int i, int j) {
        table[i][j] = this.turno;
    }


    public String fila(int i) {

        String cadena = "";
        for (int j = 0; j < numeroC; j++) {
            cadena += table[i][j];
        }
        return cadena;
    }

    public String columna(int columna) {

        String cadena = "";
        for (int i = 0; i < numeroF - 1; i++) {
            for (int j = 0; j < numeroC; j++) {
                if (j == columna) {
                    cadena = "";
                    for (int k = 0; k < numeroF; k++) {
                        cadena += table[k][j];
                    }
                }
            }
        }
        return cadena;
    }

    public String diagIzq(int fila, int columna) {

        String cadena = "";
        for (int i = fila, j = columna; i < numeroF && j < numeroC; i++, j++) {
            cadena += table[i][j];
        }
        for (int i = fila - 1, j = columna - 1; j >= 0 && i >= 0; i--, j--) {
            cadena = table[i][j] + cadena;
        }
        return cadena;
    }

    public String diagDer(int fila, int columna) {

        String cadena = "";
        for (int i = fila, j = columna; i < numeroF && j >= 0; i++, j--) {
            cadena += table[i][j];
        }
        for (int i = fila - 1, j = columna + 1; j < numeroC && i >= 0; i--, j++) {
            cadena = table[i][j] + cadena;
        }
        return cadena;
    }

    public boolean comprobarPartida(int fila, int columna) {

        if (fila(fila).contains(playerWin) || columna(columna).contains(playerWin) || diagDer(fila, columna).contains(playerWin) || diagIzq(fila, columna).contains(playerWin)) {
            ganador = "player";
            return true;
        } else if (fila(fila).contains(IAWin) || columna(columna).contains(IAWin) || diagDer(fila, columna).contains(IAWin) || diagIzq(fila, columna).contains(IAWin)) {
            ganador = "IA";
            return true;
        }
        return false;
    }

    public int IApattern1(int columna) {

        String fila;
        int col;
        for (int i = 0; i < numeroF; i++) {
            fila = "";
            for (int j = 0; j < numeroF; j++) {
                fila += table[i][j];
                col = j;
                if (fila.contains(PatternWin_1) && col != (numeroC - 1) && table[i][col + 1] == vacio)
                    return col + 1;
                if (fila.contains(PatternWin_1) && (col - 3) >= 0 && table[i][col - 3] == vacio)
                    return col - 3;
            }
        }
        return columna;
    }

    public String mostrarTablero() {

        String cadena = "";
        for (int i = 0; i < numeroF; i++) {
            for (int j = 0; j < numeroC; j++) {
                cadena += table[i][j];
            }
        }
        return cadena;
    }

    public String tableToString() {

        String cadena = "";
        for (int i = 0; i < numeroF; i++) {
            for (int j = 0; j < numeroC; j++) {
                cadena += table[i][j];
            }
        }
        return cadena;
    }

    public void StringToTable(String cadena) {

        int contador = 0;
        for (int i = 0; i < numeroF; i++) {
            for (int j = 0; j < numeroC; j++) {
                table[i][j] = Integer.parseInt(cadena.substring(contador, contador + 1));
                contador++;
            }
        }
    }

}