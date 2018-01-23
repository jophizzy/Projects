/** I N C L U D E S **********************************************************/
#include <p18f4550.h>								// PIC Controller header file
#include <adc.h>									// ADC library functions
#include <xlcd.h>									// LCD library functions
#include <delays.h>									// Delay library functions
#include <stdio.h>									// Standard IO functions
#include <stdlib.h>									// Standard library functions


/** V A R I A B L E S ********************************************************/
#pragma idata

int stepMotor1 = 4;									// Array index for motor 1.
int stepMotor2 = 4;									// Array index for motor 2.
int stepMotor3 = 4;
char motor[8] = {0b10101010,						// An array of characters which contains the output sequence for the motors
               	0b10001000,
               	0b10011001,
               	0b00010001,
				0b01010101,
				0b01000100,
				0b01100110,
				0b00100010};

																// Array index for motor 2.


/** P R I V A T E  P R O T O T Y P E S ***************************************/

void rotateCW(int motorNum);						// Function for rotating a motor one step in the clockwise direction
void rotateCCW(int motorNum);						// Function for rotating a motor one step in the counterclockwise direction
int  readFrontSensor(void);							// Function to read the front sensor
int  readLeftSensor(void);                          // Function to read the left sensor
int  readRightSensor(void);                         // Function to read the right sensor
void followLeftWall( int sensor, int tol);           // Function to follow the wall on the left
void followRightWall(int sensor, int tol);          // Function to follow the wall on the right
void followLeftWallIt(int dist, int tol);           // Function to follow the wall on the left a given distance
void followRightWallIt(int dist, int tol);          // Function to follow the wall on the right a given distance
void goForward(void);							     	// Function to go forward by 1 step
void goForwardx(int stepNum);                       // Function to go forward by a given number of steps
void goBackward();                                  // Function to go backward by 1 step
void goBackwardx(int stepNum);                      // Function to go backward by a given number of steps
void turnRight(int stepNum);						// Function to turn right
void turnLeft(int stepNum);                         // Function to turn Left
void goForwardR(void);
void goForwardL(void);
void goForwardF(void);
void followRightWallF(int sensor, int tol);
void followLeftWallF(int sensor, int tol);
void goForwardFastF(void);
void followRightWallR(int sensor, int tol);
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

void main(void)
{
    int leftSensor = 0;
    int frontSensor = 0;							// Variable to store front sensor value
    int rightSensor = 0;
   

	rightSensor = readRightSensor();
    frontSensor = readFrontSensor();
    leftSensor = readLeftSensor();
  
    OpenADC(ADC_FOSC_32 & ADC_RIGHT_JUST & ADC_12_TAD, ADC_CH0 & ADC_INT_OFF & ADC_VREFPLUS_VDD & ADC_VREFMINUS_VSS, 12);
    OpenADC(ADC_FOSC_32 & ADC_RIGHT_JUST & ADC_12_TAD, ADC_CH1 & ADC_INT_OFF & ADC_VREFPLUS_VDD & ADC_VREFMINUS_VSS, 12);
	OpenADC(ADC_FOSC_32 & ADC_RIGHT_JUST & ADC_12_TAD, ADC_CH2 & ADC_INT_OFF & ADC_VREFPLUS_VDD & ADC_VREFMINUS_VSS, 12);
    
    while(1)
    {
	rightSensor = readRightSensor();
    frontSensor = readFrontSensor();
    leftSensor = readLeftSensor();

    turnRight(235);
	goForwardL();
	goForwardx(200);
    followRightWall(120,350);
	goForwardx(300);
	turnLeft(235);

 
    //enters box
	goForwardx(500);
    followRightWallF(120,350);
    turnLeft(245);	
    followRightWallR(120,350);
	turnRight(210);

    //enters opponents zone
    goForwardFastF();
    turnRight(235);
    turnRight(235);
    goForwardFastF();
    turnRight(235);
    followLeftWallF(120,350);
    turnLeft(245);
    turnLeft(245);
    goForwardF();
    turnRight(235);

    //exits box
    followLeftWall(120,350);
    goForwardF();
    turnRight(240);
    followLeftWallF(120,350);
    turnRight(235);
    goForwardx(1000);
    turnRight(235);
    turnRight(235);
    followRightWallF(120,350);
    turnLeft(245);
    followRightWallF(120,350);
    turnLeft(235);
    followRightWallIt(22,350);
    turnLeft(235);
    turnLeft(235);
    followLeftWall(120,350);
    goForwardF();
while(1){}
}

}	

/******************************************************************************
 * Function:        followLeftWall
 *
 * PreCondition:    None
 *
 * Input:           sensor: the left sensor value required to exit the function.
 *                  tol: the minimum left sensor value for which the robot would move forward in a straight line.
 *
 * Output:          follow the wall on the left
 *
 * Side Effects:    None
 *
 * Overview:        follows the left wall until the front sensor reads a certain value
 *
 * Note:            None
 *****************************************************************************/

void followLeftWall( int sensor, int tol){

	
	int frontSensor;
	int leftSensor;
    int rightSensor;
    leftSensor = readLeftSensor();
	rightSensor = readRightSensor();
    frontSensor = readFrontSensor();
	while(1)
    {
				
		if(leftSensor > tol+65)//65
		{ 
            turnRight(12);
		    goForwardx(35);	
		}
		else if(leftSensor < tol)
		{ 
            turnLeft(12); 
			goForwardx(35);
		}
		else
		{
			goForwardx(20);
		}
		frontSensor = readFrontSensor();
        rightSensor= readRightSensor();
        leftSensor = readLeftSensor();   
		
        if (leftSensor < 200 || rightSensor < 200)
        {
	     
             	break;
		}                                
                      

    if(frontSensor > 450){
                             turnLeft(235);
                             turnLeft(235);
				              break;
						}	   

}
return;	
}

/******************************************************************************
 * Function:        followLeftWallIt
 *
 * PreCondition:    None
 *
 * Input:           dist – the distance, or number of times the robot executes the loop.
 *                  tol: the minimum left sensor value for which the robot would move forward in a straight line.
 *
 * Output:          follows the wall on the left a given distance
 *
 * Side Effects:    None
 *
 * Overview:        follows the left wall a given distance
 *
 * Note:            None
 *****************************************************************************/

void followLeftWallIt (int dist, int tol){
	int i=0;
	int leftSensor ;
	int rightSensor ;

	while (i < dist)
    {		
    	leftSensor = readLeftSensor();
		if(leftSensor > tol+100)
		{
            turnRight(30);
			goForwardx(50);
		}
		if(leftSensor < tol)
		{
            turnLeft(30);
			goForwardx(50);
		}
		else
		{
		    goForwardx(50);
		}
		rightSensor = readRightSensor();
		i++;
	}
return;
}

/******************************************************************************
 * Function:        followRightWall
 *
 * PreCondition:    None
 *
 * Input:           sensor: the front sensor value required to exit the function.
 *                  tol: the minimum right sensor value for which the robot would move forward in a straight line.
 *
 * Output:          follow the wall on the right
 *
 * Side Effects:    None
 *
 * Overview:        follows the right wall until the front sensor reads a certain value
 *
 * Note:            None
 *****************************************************************************/

void followRightWall(int sensor, int tol){
	int frontSensor = readFrontSensor();
	int rightSensor = readRightSensor() ;
    int leftSensor = readLeftSensor();
	while(1)
    {
		rightSensor = readRightSensor();		
		if(rightSensor > tol+65)//65
		{ 
            turnLeft(15);
		    goForwardx(35);	
		}
		else if(rightSensor < tol)
		{ 
            turnRight(15); 
			goForwardx(35);
		}
		else
		{
			goForwardx(20); //20
		}
        	frontSensor = readFrontSensor();
            rightSensor= readRightSensor();
            leftSensor = readLeftSensor();
		
     

        if (leftSensor < 200 || rightSensor < 200)
        {

	break;}                                
  if(frontSensor>450){
                             turnRight(235);
                             turnRight(235);
				              break;
						}	   
} 
return;	
}

/******************************************************************************
 * Function:        followRightWallIt
 *
 * PreCondition:    None
 *
 * Input:           dist – the distance, or number of times the robot executes the loop.
 *                  tol: the minimum right sensor value for which the robot would move forward in a straight line.
 *
 * Output:          follows the wall on the right a given distance
 *
 * Side Effects:    None
 *
 * Overview:        follows the right wall a given distance
 *
 * Note:            None
 *****************************************************************************/

void followRightWallIt (int dist, int tol){
	int i=0;
	int leftSensor ;
	int rightSensor ;

	while (i<dist)
    {		
    	rightSensor = readRightSensor();
		if(rightSensor > tol+100)
		{
            turnLeft(30);
			goForwardx(20);
		}
		if(rightSensor < tol)
		{
            turnRight(30);
			goForwardx(20);
		}
		else
		{
		    goForwardx(50);
		}
rightSensor = readRightSensor();
		i++;
	}
return;
}

/******************************************************************************
 * Function:        readFrontSensor
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          value read from front sensor, 10 bits
 *
 * Side Effects:    None
 *
 * Overview:        This function reads the front sensor which is hooked up with
 *					channel 0 of the ADC of the PIC
 *
 * Note:            None
 *****************************************************************************/

int readFrontSensor(void){

	SetChanADC(ADC_CH0);							// Set the analog input to A0
	ConvertADC();									// Start the conversion
	while(BusyADC());								// Wait until the conversion is finished
	return ReadADC();								// Store the value from the conversion 
}

/******************************************************************************
 * Function:        readLeftSensor
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          value read from left sensor, 10 bits
 *
 * Side Effects:    None
 *
 * Overview:        This function reads the left sensor which is hooked up with
 *					channel 1 of the ADC of the PIC
 *
 * Note:            None
 *****************************************************************************/

int readLeftSensor(void){

	SetChanADC(ADC_CH1);							// Set the analog input to A1
	ConvertADC();									// Start the conversion
	while(BusyADC());								// Wait until the conversion is finished
	return ReadADC();								// Store the value from the conversion 
}

/******************************************************************************
 * Function:        readRightSensor
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          value read from front sensor, 10 bits
 *
 * Side Effects:    None
 *
 * Overview:        This function reads the right sensor which is hooked up with
 *					channel 2 of the ADC of the PIC
 *
 * Note:            None
 *****************************************************************************/

int readRightSensor(void){

	SetChanADC(ADC_CH2);							// Set the analog input to A2
	ConvertADC();									// Start the conversion
	while(BusyADC());								// Wait until the conversion is finished
	return ReadADC();								// Store the value from the conversion 
} 

/******************************************************************************
 * Function:        goForward
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          None
 *
 * Side Effects:    None
 *
 * Overview:        This function moves the robot 1 step forward 
 *
 * Note:            None
 *****************************************************************************/

void goForward(void){

	rotateCCW(2);									// Rotate motor two step
	rotateCW(1);    								// Rotate motor one step
	
	Delay1KTCYx(40);								// Changing the argument in the delay function will change the speed at which the motor rotates. Delay equals 1000 x 50 x 1/12 = 4.167 ms
	LATD = 0x00;									// Set all port D to 0	
}

/******************************************************************************
 * Function:        goForwardx
 *
 * PreCondition:    None
 *
 * Input:           the number of steps to be moved forward.
 *
 * Output:          none
 *
 * Side Effects:    None
 *
 * Overview:        moves the robot forward a given number of steps
 *
 * Note:            None
 *****************************************************************************/

void goForwardx( int stepNum){
	int i=0;
	while( i < stepNum){
		goForward();
		i++;
	}
return;
}


/******************************************************************************
 * Function:        turnRight
 *
 * PreCondition:    None
 *
 * Input:           stepNum: Number of steps to make for turning right
 *
 * Output:          None
 *
 * Side Effects:    None
 *
 * Overview:        This function make the robot to turn right by making certain
 *					number of steps which is indicated by the input
 *
 * Note:            None
 *****************************************************************************/

void turnRight(int stepNum){
	
	int i = 0;

	while(i<stepNum){
		rotateCW(2);								// Rotate motor two step
		rotateCW(1);								// Rotate motor one step
		Delay1KTCYx(50);							// Changing the argument in the delay function will change the speed at which the motor rotates. Delay equals 1000 x 50 x 1/12 = 4.167 ms
		i++;
		LATD = 0x00;								// Set all port D to 0	
	    LATB = 0x00;
}

	return;
}

/******************************************************************************
 * Function:        turnLeft
 *
 * PreCondition:    None
 *
 * Input:           stepNum: Number of steps to make for turning left
 *
 * Output:          None
 *
 * Side Effects:    None
 *
 * Overview:        This function make the robot to turn left by making certain
 *					number of steps which is indicated by the input
 *
 * Note:            None
 *****************************************************************************/

void turnLeft(int stepNum){
	
	int i = 0;

	while(i<stepNum){
		rotateCCW(2);								// Rotate motor two step
rotateCCW(1);								// Rotate motor one step
		Delay1KTCYx(50);							// Changing the argument in the delay function will change the speed at which the motor rotates. Delay equals 1000 x 50 x 1/12 = 4.167 ms
		i++;
		LATD = 0x00;								// Set all port D to 0	
        LATB = 0x00;
	}

	return;
}

/******************************************************************************
 * Function:        rotateCW
 *
 * PreCondition:    None
 *
 * Input:           motorNum - determines which motor, 
 *					motor[] - an array which contains output sequence for the motors
 *
 * Output:          sequence for correct motor operation 
 *
 * Side Effects:    None
 *
 * Overview:        This function rotates the motor one step
 *
 * Note:            NOT REQUIRED TO KNOW THE INNER WORKINGS OF THIS FUNCTION
 *****************************************************************************/

void rotateCW(int motorNum){				
	if(motorNum==1){
		stepMotor1 = ++stepMotor1;					// Increment the array index for motor 1
		if(stepMotor1>7)							// If the array index is out of range the reset it to 0	
			stepMotor1=0;
		TRISD &= 0x0f;								// Set the upper 4 bits of port D as outputs
        LATD |= ((motor[stepMotor1]<<4)&0xf0);		// Output the motor step sequence to the upper 4 bits of port D
	}else{
		stepMotor2 = ++stepMotor2;					// Increment the array index for motor 2
		if(stepMotor2>7)							// If the array index is out of range the reset it to 0
			stepMotor2=0;							
		TRISD &= 0xf0;								// Set the lower 4 bits of port D as outputs
        LATD |= ((motor[stepMotor2]>>4)&0x0f);		// Output the motor step sequence to the lower 4 bits of port D
	}
}

/******************************************************************************
 * Function:        rotateCCW
 *
 * PreCondition:    None
 *
 * Input:           motorNum - determines which motor, 
 *					motor[] - an array which contains output sequence for the motors
 *
 * Output:          sequence for correct motor operation 
 *
 * Side Effects:    None
 *
 * Overview:        This function rotates the motor one step
 *
 * Note:            NOT REQUIRED TO KNOW THE INNER WORKINGS OF THIS FUNCTION
 *****************************************************************************/

void rotateCCW(int motorNum){										
	if(motorNum==1){															
		stepMotor1--;								// Decrement the array index for motor 1
		if(stepMotor1<0)							// If the array index is out of range the reset it to 7														
			stepMotor1=7;														
		TRISD &= 0x0f;								// Set the upper 4 bits of port D as outputs
        LATD |= ((motor[stepMotor1]<<4)&0xf0);		// Output the motor step sequence to the upper 4 bits of port D
	}else{
		stepMotor2--;								// Decrement the array index for motor 2
		if(stepMotor2<0)							// If the array index is out of range the reset it to 7
			stepMotor2=7;
		TRISD &= 0xf0;								// Set the lower 4 bits of port D as outputs
        LATD |= ((motor[stepMotor2]>>4)&0x0f);		// Output the motor step sequence to the lower 4 bits of port D
	}
}

/******************************************************************************
 * Function:        goForwardR
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          None
 *
 * Side Effects:    None
 *
 * Overview:        This function moves the robot 1 step forward 
 *
 * Note:            None
 *****************************************************************************/
void goForwardR(void){
					   int rightSensor;
		               rightSensor = readRightSensor();
				       while(rightSensor < 200){
											     goForward();
												 rightSensor = readRightSensor();
	                                            }      
												 goForwardx(100);                           
         			   return;
             }	


/******************************************************************************
 * Function:        goForwardL
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          None
 *
 * Side Effects:    None
 *
 * Overview:        This function moves the robot 1 step forward 
 *
 * Note:            None
 *****************************************************************************/
void goForwardL(void){
					   int leftSensor;
		               leftSensor = readLeftSensor();
				       while(leftSensor < 200){
											     goForward();
												 leftSensor = readLeftSensor();
	                                            }   
				                	goForwardx(100);							                              
                       return;      
				}

/******************************************************************************
 * Function:        goForwardF
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          None
 *
 * Side Effects:    None
 *
 * Overview:        This function moves the robot 1 step forward 
 *
 * Note:            None
 *****************************************************************************/
void goForwardF(void){
					   int frontSensor;
		               frontSensor = readFrontSensor();
				       while(frontSensor < 450){
											     goForward();
												 frontSensor = readFrontSensor();
	                                              
												}                                 
                                    
									return;      
				}		             	             

/******************************************************************************
 * Function:        goForwardFastF
 *
 * PreCondition:    None
 *
 * Input:           None
 *
 * Output:          None
 *
 * Side Effects:    None
 *
 * Overview:        This function moves the robot 1 step forward 
 *
 * Note:            None
 *****************************************************************************/
void goForwardFastF(void){
					   int frontSensor;
		               frontSensor = readFrontSensor();
				       while(frontSensor < 450){
											    rotateCCW(2);									// Rotate motor two step
	                                            rotateCW(1);    								// Rotate motor one step
	
                                               	Delay1KTCYx(35);								// Changing the argument in the delay function will change the speed at which the motor rotates. Delay equals 1000 x 50 x 1/12 = 4.167 ms
	                                            LATD = 0x00;									// Set all port D to 0	
												frontSensor = readFrontSensor();
	                                              
												}                                 
                                    
									return;      
				}



/******************************************************************************
 * Function:        followRightWall
 *
 * PreCondition:    None
 *
 * Input:           sensor: the front sensor value required to exit the function.
 *                  tol: the minimum right sensor value for which the robot would move forward in a straight line.
 *
 * Output:          follow the wall on the right
 *
 * Side Effects:    None
 *
 * Overview:        follows the right wall until the front sensor reads a certain value
 *
 * Note:            None
 *****************************************************************************/

void followRightWallF(int sensor, int tol){
	int frontSensor = readFrontSensor();
	int rightSensor = readRightSensor() ;
    int leftSensor = readLeftSensor();
	while(1)
    {
		rightSensor = readRightSensor();		
		if(rightSensor > tol+65)//65
		{ 
            turnLeft(10);
		    goForwardx(35);	
		}
		else if(rightSensor < tol)
		{ 
            turnRight(10); 
			goForwardx(35);
		}
		else
		{
			goForwardx(20); //20
		}
        	frontSensor = readFrontSensor();
            rightSensor= readRightSensor();
            leftSensor = readLeftSensor();
                               
  if(frontSensor > 400){
                          
				              break;
						}	   
}
return;	
}	  	        

void followLeftWallF(int sensor, int tol){
	int frontSensor = readFrontSensor();
	int rightSensor = readRightSensor() ;
    int leftSensor = readLeftSensor();
	while(1)
    {
		leftSensor = readLeftSensor();		
		if(leftSensor > tol+65)//65
		{ 
            turnRight(10);
		    goForwardx(35);	
		}
		else if(leftSensor < tol)
		{ 
            turnLeft(10); 
			goForwardx(35);
		}
		else
		{
			goForwardx(20); //20
		}
        	frontSensor = readFrontSensor();
            rightSensor= readRightSensor();
            leftSensor = readLeftSensor();
		
     

        

                               
  if(frontSensor>400){
                          
				              break;
						}	   
}
return;	
}           

void followRightWallR(int sensor, int tol){	  
    int frontSensor = readFrontSensor();
	int rightSensor = readRightSensor() ;
    int leftSensor = readLeftSensor();
	while(1)
    {
		rightSensor = readRightSensor();		
		if(rightSensor > tol+100)//65
		{ 
            turnLeft(30);
		    goForwardx(20);	
		}
		else if(rightSensor < tol)
		{ 
            turnRight(30); 
			goForwardx(20);
		}
		else
		{
			goForwardx(20); //20
		}
        	frontSensor = readFrontSensor();
            rightSensor= readRightSensor();
            leftSensor = readLeftSensor();
		
     

        if (rightSensor < 200)
        {
           goForwardx(250);
           break;
        }                                
	   
} 
return;	
}



