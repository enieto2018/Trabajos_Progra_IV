package com.edu.utp.isc.cursojee.calculadora.numero;

/**
 *
 * @author DiazOspina
 */
public abstract class NumeroCalculadora extends Number {

    private int base;

    /**
     *
     */
    protected String valor;

    /**
     *
     * @param base
     */
    public NumeroCalculadora(int base) {
        this.base = base;
    }

    /**
     *
     * @param valor
     * @param base
     */
    public NumeroCalculadora(String valor, int base) {
        setValor(valor);
        this.base = base;
    }

    /**
     *
     * @param valor
     * @throws NumberFormatException
     */
    public final void setValor(String valor) throws NumberFormatException {
        validar(valor);
        this.valor = valor;
    }

    /**
     *
     * @param numero
     * @throws NumberFormatException
     * @throws IllegalArgumentException
     */
    public abstract void validar(String numero) throws NumberFormatException, IllegalArgumentException;
    
    /**
     *
     * @param numero
     * @return
     * @throws IllegalArgumentException
     */
    public NumeroCalculadora deNumber(Number numero) throws IllegalArgumentException {
        if (numero == null) {
            throw new IllegalArgumentException("El numero dado no ha sido inicializado");
        }
        setValor(Long.toString(numero.longValue(), base).toUpperCase());
        return this;
    }

    /**
     *
     * @return
     * @throws NumberFormatException
     * @throws IllegalArgumentException
     */
    public Number aNumber() throws NumberFormatException, IllegalArgumentException {
        if (valor == null) {
            throw new IllegalArgumentException("El numero dado no ha sido inicializado");
        }
        return Long.parseLong(valor, base);
    }

    @Override
    public int intValue() {
        return aNumber().intValue();
    }

    @Override
    public long longValue() {
        return aNumber().longValue();
    }

    @Override
    public float floatValue() {
        return aNumber().floatValue();
    }

    @Override
    public double doubleValue() {
        return aNumber().doubleValue();
    }

    @Override
    public String toString() {
        return valor;
    }

}
