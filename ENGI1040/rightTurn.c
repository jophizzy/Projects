/** I N C L U D E S **********************************************************/
#include <p18f4550.h>															// PIC Controller header file
#include <adc.h>																// ADC library functions
#include <xlcd.h>																// LCD library functions
#include <delays.h>																// Delay library functions
#include <stdio.h>																// Standard IO functions
#include <stdlib.h>																// Standard library functions


/** V A R I A B L E S ********************************************************/
#pragma idata

int stepMotor3 = 4;																// Array index for motor 2.

char motor[8] = {0b10101010,													// An array of characters which contains the output sequence for the motors
               	0b10001000,
               	0b10011001,
               	0b00010001,
				0b01010101,
				0b01000100,
				0b01100110,
				0b00100010};


/** P R I V A T E  P R O T O T Y P E S ***************************************/

void rotatethirdmotorCW(void);
void rotatethirdmotorCCW(void);

/**V E C T O R  R E M A P P I N G*********************************************/

extern void _startup (void);
#pragma code _RESET_INTERRUPT_VECTOR = 0x000800
void  _reset (void){
	_asm goto _startup _endasm
}

#pragma code _HIGH_INTERRUPT_VECTOR = 0x000808
void _high_ISR (void){
	;
}

#pragma code _LOW_INTERRUPT_VECTOR = 0x000818
void _low_ISR (void){
	;
}

#pragma code

/** D E C L A R A T I O N S **************************************************/


/** U S E R  A P I ***********************************************************/

/******************************************************************************
 * Function:        main
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          None
 *
 * Side Effects:    None
 *
 * Overview:        main entry point 
 * Note:            None
 *****************************************************************************/

void main(void){
int i=0;	
	// control loop

	for(i=0;i<400;i++)
	{
	rotatethirdmotorCCW();
	}
	for(i=0;i<400;i++)
	{
	rotatethirdmotorCW();
	}

	return;
}





/******************************************************************************
 * Function:        rotatethirdmotorCW
 *
 * PreCondition:    None
 *
 * Input:           None 
 *
 * Output:          sequence for correct motor operation 
 *
 * Side Effects:    None
 *
 * Overview:        This function rotates the motor one step
 *
 * Note:            None
 *****************************************************************************/

void rotatethirdmotorCW(void){				

		stepMotor3 = ++stepMotor3;												// Increment the array index for motor 2
		if(stepMotor3>7)														// If the array index is out of range the reset it to 0
			stepMotor3=0;							
		TRISB &= 0xf0;															// Set the lower 4 bits of port B as outputs
        LATB |= ((motor[stepMotor3]>>4)&0x0f);									// Output the motor step sequence to the lower 4 bits of port B
	Delay1KTCYx(50);															// Changing the argument in the delay function will change the speed at which the motor rotates. Delay equals 1000 x 50 x 1/12 = 4.167 ms
	LATB = 0x00;																// Set all port B to 0	

}

/******************************************************************************
 * Function:        rotatethirdmotorCCW
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          sequence for correct motor operation 
 *
 * Side Effects:    None
 *
 * Overview:        This function rotates the motor one step
 *
 * Note:            None
 *****************************************************************************/

void rotatethirdmotorCCW(void){										
		stepMotor3--;															// Decrement the array index for motor 2
		if(stepMotor3<0)														// If the array index is out of range the reset it to 7
			stepMotor3=7;
		TRISB &= 0xf0;															// Set the lower 4 bits of port B as outputs
        LATB |= ((motor[stepMotor3]>>4)&0x0f);									// Output the motor step sequence to the lower 4 bits of port B
	Delay1KTCYx(50);															// Changing the argument in the delay function will change the speed at which the motor rotates. Delay equals 1000 x 50 x 1/12 = 4.167 ms
	LATB = 0x00;																// Set all port B to 0	
}