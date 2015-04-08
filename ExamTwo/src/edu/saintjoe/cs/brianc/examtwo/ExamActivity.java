
package edu.saintjoe.cs.brianc.examtwo;


import com.google.devtools.simple.runtime.components.Component;
import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.Form;

import com.google.devtools.simple.runtime.components.android.Button;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.HorizontalArrangement;
import com.google.devtools.simple.runtime.components.android.TextBox;
import com.google.devtools.simple.runtime.components.android.AccelerometerSensor;

import com.google.devtools.simple.runtime.events.EventDispatcher;

public class ExamActivity extends Form implements HandlesEventDispatching {

	private HorizontalArrangement line1, line2, line3; // calls for horizontal arangement component
	private Button incButton; // allows button component
	private Label resultLabel; // allows a label
	private Label promptLabel; // allows a label
	private TextBox inputBox; // allows a textbox
	
	int temp;
	

 void $define() { // "main"
 	
     this.BackgroundColor(COLOR_WHITE); //background set to color
     
     line1 = new HorizontalArrangement(this); // places HA on line 1
     line2 = new HorizontalArrangement(this); // places HA on line 2
     line3 = new HorizontalArrangement(this); // places HA on line 3
     

     
     promptLabel = new Label(line1, "Enter a number:"); // places label on line 1 "enter a number"
     inputBox = new TextBox(line1);// places a textbox on line 1
     inputBox.NumbersOnly(true); // sets textbox ^ to numbers only
   
     incButton = new Button(line2,"Double It:"); // places button on line 2 "double it"
     
     resultLabel = new Label(line3,""); // places result label on line 3
     
     
 
     EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click"); // tells the app what logic/events to look for
    
 } 
 @Override
 public boolean dispatchEvent(Component component, String id, String eventName,
         Object[] args) {
 	
	    if (component.equals(incButton) && eventName.equals("Click")){ // if statement logic when button clicked
	    	temp = Integer.parseInt(inputBox.Text()); // takes text from input box multiplys by 2
	    	temp *= 2;
	    	resultLabel.Text(String.valueOf(temp)); // takes result of mutiplication and displays it in result label
	        return true;
	     } 
	    
	    
	    
    return true;
	} 
} 
