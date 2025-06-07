/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_simuladorBancario
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.simuladorBancario.mundo;

import java.util.ArrayList;
import java.util.ArrayList; // Se importa el ArrayList para almacenar los saldos mensuales
/**
 * Clase que representa la cuenta de ahorro de un cliente.
 */
public class CuentaAhorros
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Saldo actual de la cuenta de ahorro.
     */
    private double saldo;
    

    /**
     * Interés mensual que paga la cuenta de ahorro.
     */
    private double interesMensual;
    
    /**
     * Lista que almacena el saldo del mes actual. 
     */
    private ArrayList<Double> saldosMensuales = new ArrayList<>(); // objeto para alamcenar el saldo de la cuenta cada en los diferentes meses
    
    /**
     * Lista que almacena las transacciones realizadas durante el mes actual.
     */
    private ArrayList<String> transaccionesMensuales = new ArrayList<>(); // objeto que alamcena las transacciones mensuales
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa la cuenta de ahorro con el interés mensual que paga el banco. <br>
     * <b>post: </b> Se inicializó el saldo en 0 y el interés mensual en 0.006.
     */
    public CuentaAhorros( )
    {
        saldo = 0;
        interesMensual = 0.006;
    }

    /**
     * Retorna el saldo del cliente. <br>
     * @return Saldo de la cuenta de ahorros.
     */
    public double darSaldo( )
    {
        return saldo;
    }

    /**
     * Retorna el interés mensual. <br>
     * @return Interés mensual de la cuenta de ahorros.
     */
    public double darInteresMensual( )
    {
        return interesMensual;
    }

    /**
     * Consigna un monto de dinero en la cuenta del cliente. <br>
     * <b>post: </b> El saldo se incrementó en el monto de dinero ingresado. <br>
     * @param pMonto Monto de dinero a consignar en la cuenta. pMonto > 0.
     */
    public void consignarMonto( double pMonto )
    {
        saldo = saldo + pMonto;
        registrarSaldo();
        transaccionesMensuales.add("Consignación: $" + String.format("%.2f", pMonto));
    }

    /**
     * Retira un monto de dinero de la cuenta de ahorros. <br>
     * <b>post: </b> El saldo se redujo en el valor dado.
     * @param pMonto Monto de dinero a retirar de la cuenta de ahorros. pMonto > 0.
     */
    public void retirarMonto( double pMonto )
    {
        saldo = saldo - pMonto;
        registrarSaldo();
        transaccionesMensuales.add("Retiro: $" + String.format("%.2f", pMonto));
    }

    /**
     * Actualiza el saldo de la cuneta de ahorros sumándole los intereses (ha pasado un mes). <br>
     * <b>post: </b> El saldo actual se actualizó aplicando el porcentaje de interés mensual respectivo.
     */
    public void actualizarSaldoPorPasoMes( )
    {
    	double interes = saldo  * interesMensual;
        saldo = saldo + interes;
        registrarSaldo(); // utilizamos el metodo para agregar el saldo actual
        transaccionesMensuales.add("Interés mensual aplicado: $" + String.format("%.2f", interes));
    }
    
    public double calcularPromedio(int mesInicio, int mesFin)
    {
        double suma = 0.0;
        int cantidadMeses = 0;

        for (int i = mesInicio - 1; i < mesFin && i < saldosMensuales.size(); i++) {
            suma += saldosMensuales.get(i);
            cantidadMeses++;
        }

        return cantidadMeses > 0 ? suma / cantidadMeses : 0.0;
    }
    
    
    /**
     * Retorna un resumen de las transacciones realizadas en el mes actual.
     * @return Cadena con el resumen de transacciones.
     */
    public String resumenTransacciones()
    {
        if (transaccionesMensuales.isEmpty()) {
            return "No se han realizado transacciones este mes.";
        }

        StringBuilder resumen = new StringBuilder();
        for (String transaccion : transaccionesMensuales) {
            resumen.append(transaccion).append("\n");
        }
        return resumen.toString();
    }

    /**
     * Limpia la lista de transacciones del mes actual.
     */
    public void limpiarTransacciones()
    {
        transaccionesMensuales.clear(); // para eliminar todos elementos de la transacción actual antes de que pase al siguiente mes
    }
     
    /**
     * Agregar el saldo del mes actual.
     */
    
    public void registrarSaldo() {
        saldosMensuales.add(saldo); // Guarda el saldo actual al final de la listaAdd commentMore actions
    }
    
    
    
    
    /**
     * Simula el saldo que tendría esta cuenta dentro de cierta cantidad de meses, sin afectar el saldo real.
     * @param meses Número de meses en el futuro a simular. Debe ser >= 0.
     * @return Saldo simulado dentro de los meses especificados.
     */
    public double simularSaldoMeses(int meses)
    {
        double saldoSimulado = saldo;
        for (int i = 0; i < meses; i++) {
            saldoSimulado += saldoSimulado * interesMensual;
        }
        return saldoSimulado;
    }
}