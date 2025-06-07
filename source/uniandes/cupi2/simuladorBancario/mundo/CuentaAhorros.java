/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_simuladorBancario
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.simuladorBancario.mundo;

import java.util.ArrayList;

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
     * Inter�s mensual que paga la cuenta de ahorro.
     */
    private double interesMensual;
    
    private ArrayList<Double> saldosMensuales = new ArrayList<>();

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa la cuenta de ahorro con el inter�s mensual que paga el banco. <br>
     * <b>post: </b> Se inicializ� el saldo en 0 y el inter�s mensual en 0.006.
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
     * Retorna el inter�s mensual. <br>
     * @return Inter�s mensual de la cuenta de ahorros.
     */
    public double darInteresMensual( )
    {
        return interesMensual;
    }

    /**
     * Consigna un monto de dinero en la cuenta del cliente. <br>
     * <b>post: </b> El saldo se increment� en el monto de dinero ingresado. <br>
     * @param pMonto Monto de dinero a consignar en la cuenta. pMonto > 0.
     */
    public void consignarMonto( double pMonto )
    {
        saldo = saldo + pMonto;
        registrarSaldo();
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
    }

    /**
     * Actualiza el saldo de la cuneta de ahorros sum�ndole los intereses (ha pasado un mes). <br>
     * <b>post: </b> El saldo actual se actualiz� aplicando el porcentaje de inter�s mensual respectivo.
     */
    public void actualizarSaldoPorPasoMes( )
    {
        saldo = saldo + ( saldo * interesMensual );
        registrarSaldo();
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
    
    
  

    
    public void registrarSaldo() {
        saldosMensuales.add(saldo); // Guarda el saldo actual al final de la listaAdd commentMore actions
    }
    
    
    
    
    /**
     * Simula el saldo que tendr�a esta cuenta dentro de cierta cantidad de meses, sin afectar el saldo real.
     * @param meses N�mero de meses en el futuro a simular. Debe ser >= 0.
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