package javaproject;

/**
*
* @author Jay Dobson
*/

//declares generic interface class with bounded type
public interface Calculator<T extends Number> {

	double calculatorFees(T clubID);

}
