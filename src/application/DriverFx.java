package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class DriverFx extends Application {
	
	
	// main fx method
	@Override
	public void start(Stage primaryStage) {
		

        FileChooser fileChooser = new FileChooser();
        
        
        
        
        
        
        GridPane gp=new GridPane();
        
        
        DropShadow shadow = new DropShadow();
        
        
        
        ////////////////////////////sec 1 ///////////////////////////////
        //-------------------------------------------------------------//
        //-------------------------------------------------------------//
        //-------------------------------------------------------------//
        HBox hbox= new HBox();
        
		/////////////////////// button back ///////////////////////////////
		Button b0 = new Button("Back");
		b0.setPrefSize(100, 43);
		
		b0.setStyle("-fx-background-color: WHITESMOKE; -fx-background-radius: 10; -fx-Border-color: DARKGRAY	;"
				+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: DIMGREY");
		
		
		///////////////////////////////////////////////////////////////
//		b0.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-Border-color: DARKBLUE;"
//			+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: CRIMSON");
		///////////////////////////////////////////////////////////////
		
		
		//////////////////////// Label /////////////////////////////////////
		Label l0=new Label();
		l0.setPrefSize(450, 50);
		l0.setStyle("-fx-background-color: white;-fx-Border-color: LIMEGREEN;-fx-Border-width:5;"
				+ "-fx-font-size:15;-fx-font-weight:bold;-fx-text-fill: LIMEGREEN");
		
        //////////////////////// button load ///////////////////////////////
        Button b1 = new Button("Load");
        b1.setPrefSize(100, 43);
        b1.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-Border-color: 	DARKRED;"
    			+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: 	DARKRED");
        
        b1.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		            b1.setEffect(shadow);
		            b1.setStyle("-fx-background-color: DARKRED; -fx-background-radius: 10; -fx-Border-color: DARKRED;"
		        			+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: 	white");
		          }
		        });
		b1.addEventHandler(MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		            b1.setEffect(null);
		            b1.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-Border-color: 	DARKRED;"
		        			+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: 	DARKRED");
		          }
		        });
		
		 
        

        ///////////////////////////////////////////////////////////////////
        
        
        
        
        
        hbox.getChildren().addAll(b0,l0,b1);
      
        hbox.setSpacing(20);
        
		////////////////////////////sec 2 ///////////////////////////////
		Text t_CheckInvalidFile=new Text();

		//////////////////////////// sec 3 ///////////////////////////////
        VBox vbox1 = new VBox();
        
        Text t1=new Text("Equations");
        t1.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
        
        TextArea ta1=new TextArea();
        ta1.setStyle("-fx-background-color: white;-fx-Border-color: Black;-fx-Border-width:4;-fx-font-size:20;-fx-font-weight:bold;");
        ta1.setPrefSize(650, 260);
        ta1.setEditable(false);
        
        // empty equation
        Text t_EmptyEquationError=new Text();
        
        vbox1.getChildren().addAll(t1,ta1,t_EmptyEquationError);
        
        ////////////////////////////sec 4 ///////////////////////////////
        VBox vbox2 = new VBox();
        
        Text t2=new Text("Files");
        t2.setStyle("-fx-font-size:25;-fx-font-weight:bold;");
        
        TextArea ta2=new TextArea();
        ta2.setStyle("-fx-background-color: white;-fx-Border-color: DARKORCHID;-fx-Border-width:4;-fx-font-size:20;-fx-font-weight:bold;");
        ta2.setPrefSize(650, 140);
        ta2.setEditable(false);
        
        Text t_EmptyFileError=new Text();
        
        vbox2.getChildren().addAll(t2,ta2,t_EmptyFileError);
        
        ////////////////////////////////////////////////////////////////
        
        // the hard work
        
        CursorStack<String> allDataStack = new CursorStack<>(1000);
        
        CursorStack<String> pathStack = new CursorStack<>(1000);
        
        CursorStack<String> equationStack = new CursorStack<>(1000); // stack for equation
        
        CursorStack<String> fileStack = new CursorStack<>(1000); // stack for file
        b1.setOnAction(e0->{
        	
        	try {

        		 // to select a file.
        		 File selectedFile = fileChooser.showOpenDialog(primaryStage);
        		 
        		 
        		 // to show a path of a file.
                 String path= selectedFile.getAbsolutePath();
                 pathStack.push(path);
             	 l0.setText(" "+path);
                 
             	 
             	// get data thats inside the file.
             	selectedFile = new File(path);
             	Scanner in=new Scanner(selectedFile);
             	
             	String s="";
             	String all_s="";
             	
             	
             	String equation="";
             	String all_e="";
             	
             	
             	String file="";
             	String all_f="";
             	
				//////////////////////////////////
             	 while(in.hasNextLine()) {
             		s= in.nextLine();
             		
             		
             		// equation
             		equation=s.trim();
             		            		
					if ((equation.length() >= 18)) {
						
						String firste=equation.substring(0,10);
	             		String finale=equation.substring(equation.length()-11,equation.length());
	             
						if ((firste.equals("<equation>")) && (finale.equals("</equation>"))) {
							String eq=equation.substring(10, equation.length()-11);
							
						if(checkValidEquation(eq)!=true) {
							all_e=all_e+( eq.trim()+" => [invalid equation]"+"\n");
						}
						else if(checkBalance(eq)!=true) {
							all_e=all_e+( eq.trim()+" => [unbalanced]"+"\n");
						}
						else {
							String postfix=convert_infix_to_postfix(eq); // convert to postfix
							int calcPostfix= calculatePostFix(postfix); // calculate postfix
						   
							all_e=all_e+( eq.trim()+" => "+postfix+" => "+calcPostfix+"\n");	
						}
							
						}
					}
           		
					///////////////************************************************////////////////
					
	             	// file
					file=s.trim();
					
					if(file.length()>=11) {
						
						String firstf=file.substring(0, 6);
						String finalf=file.substring(file.length()-7,file.length());
						
		             	if((firstf.equals("<file>")) && (finalf.equals("</file>"))) {
		             		String f=file.substring(file.length()-17, file.length()-7);		             		
		             		all_f=all_f+( f+"\n");
		             	}
					}
             	
             		
             		
					///////////////************************************************////////////////
             		
             		// all data
             		all_s=all_s+s+"\n";
             		
             		 
             	 }
             
             	//rest textarea
             	ta1.setText(" ");
             	ta2.setText(" ");
             	t_CheckInvalidFile.setText(" ");
             	t_EmptyEquationError.setText(" ");
             	t_EmptyFileError.setText(" ");
             	
             	
             	// to check if the file valid or not, if valid --> check if there is data or not
             	 allDataStack.push(all_s);
             	 if(checkValidFile(allDataStack.peek())==true) {
             		
             		// equation 
             		equationStack.push(all_e);
             		ta1.setText(equationStack.peek());
             		
             		// file
             		fileStack.push(all_f);
             		ta2.setText(fileStack.peek());
             		
             		
             			if(all_e=="") {
                		 t_EmptyEquationError.setFill(Color.RED);
                   		 t_EmptyEquationError.setStyle("-fx-font-weight:bold; -fx-text-fill:Red");
                   		 t_EmptyEquationError.setText(" * Empty data: there is no equation to load !!!");
                		}
                		if(all_f=="") {
                			 t_EmptyFileError.setFill(Color.RED);
                   		 t_EmptyFileError.setStyle("-fx-font-weight:bold; -fx-text-fill:Red");
                   		 t_EmptyFileError.setText(" * Empty data: there is no file to load !!!");
                		}
                		if(!all_e.equals("") && !all_f.equals("")) {
                		 t_CheckInvalidFile.setFill(Color.MEDIUMSPRINGGREEN);
                   		 t_CheckInvalidFile.setStyle("-fx-font-weight:bold; -fx-text-fill:MEDIUMSPRINGGREEN");
                   		 t_CheckInvalidFile.setText(" All Data Loaded Successfully : )");
                		}
             		}
             		
             		
             	 
             	 
             	 // if file invalid
             	 else {
             		 t_CheckInvalidFile.setFill(Color.RED);
             		 t_CheckInvalidFile.setStyle("-fx-font-weight:bold; -fx-text-fill:Red");
             		 t_CheckInvalidFile.setText(" * invalid file !!!");
             	 }
             	 
             	 
             	 
             	if(!allDataStack.isEmpty()) {
                	b0.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-Border-color: DARKBLUE;"
                			+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: DARKRED");
                    
                	
                    b0.addEventHandler(MouseEvent.MOUSE_ENTERED,
            		        new EventHandler<MouseEvent>() {
            		          @Override
            		          public void handle(MouseEvent e) {
            		            b0.setEffect(shadow);
            		            b0.setStyle("-fx-background-color: DARKBLUE; -fx-background-radius: 10; -fx-Border-color: DARKBLUE;"
            		        			+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: 	white");
            		          }
            		        });
            		b0.addEventHandler(MouseEvent.MOUSE_EXITED,
            		        new EventHandler<MouseEvent>() {
            		          @Override
            		          public void handle(MouseEvent e) {
            		            b0.setEffect(null);
            		            b0.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-Border-color: 	DARKBLUE;"
            		        			+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: 	DARKRED");
            		          }
            		        });
                }
                
             	in.close();
        	}
        	catch(Exception  e) {
        		//System.out.println("error");
        	}
        	
           
        });
        
        
        ////////////////////////////////////////////////////////////////
        // back button
        
        
        
        b0.setOnAction(e1->{
        	
        	try {
        	t_EmptyEquationError.setText("");
        	t_EmptyFileError.setText("");
        	t_CheckInvalidFile.setText("");
        	l0.setText("");
        	
        	
        	allDataStack.pop();
        	
        	equationStack.pop();
        	ta1.setText(equationStack.peek());
        	
        	fileStack.pop();
        	ta2.setText(fileStack.peek());
        	
        	pathStack.pop();
        	
        	if(!allDataStack.isEmpty()) {
        	l0.setText(" "+pathStack.peek());
        	
        	if(checkValidFile(allDataStack.peek())==true) {
        	if(!equationStack.isEmpty() && !fileStack.isEmpty()) {
     			if(equationStack.peek()=="") {
        		 t_EmptyEquationError.setFill(Color.RED);
           		 t_EmptyEquationError.setStyle("-fx-font-weight:bold; -fx-text-fill:Red");
           		 t_EmptyEquationError.setText(" * Empty data: there is no equation to load !!!");
        		}
        		if(fileStack.peek()=="") {
        		 t_EmptyFileError.setFill(Color.RED);
           		 t_EmptyFileError.setStyle("-fx-font-weight:bold; -fx-text-fill:Red");
           		 t_EmptyFileError.setText(" * Empty data: there is no file to load !!!");
        		}
        		if(!equationStack.peek().equals("") && !fileStack.peek().equals("")) {
        		 t_CheckInvalidFile.setFill(Color.MEDIUMSPRINGGREEN);
           		 t_CheckInvalidFile.setStyle("-fx-font-weight:bold; -fx-text-fill:MEDIUMSPRINGGREEN");
           		 t_CheckInvalidFile.setText(" All Data Loaded Successfully : )");
        		}
     		}
        }
        	else {
        		t_CheckInvalidFile.setFill(Color.RED);
        	    t_CheckInvalidFile.setStyle("-fx-font-weight:bold; -fx-text-fill:Red");
        		t_CheckInvalidFile.setText(" * invalid file !!!");
        	}
        	}
        	else {
        		l0.setText("");
                	b0.setStyle("-fx-background-color: WHITESMOKE; -fx-background-radius: 10; -fx-Border-color: DARKGRAY	;"
            				+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: DIMGREY");
                	b0.addEventHandler(MouseEvent.MOUSE_ENTERED,
            		        new EventHandler<MouseEvent>() {
            		          @Override
            		          public void handle(MouseEvent e) {
            		            b0.setEffect(null);
            		            b0.setStyle("-fx-background-color: WHITESMOKE; -fx-background-radius: 10; -fx-Border-color: DARKGRAY	;"
                        				+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: DIMGREY");
            		          }
            		        });
            		b0.addEventHandler(MouseEvent.MOUSE_EXITED,
            		        new EventHandler<MouseEvent>() {
            		          @Override
            		          public void handle(MouseEvent e) {
            		            b0.setEffect(null);
            		            b0.setStyle("-fx-background-color: WHITESMOKE; -fx-background-radius: 10; -fx-Border-color: DARKGRAY	;"
                        				+ "-fx-Border-radius: 10;-fx-font-size:20;-fx-Border-width:4;-fx-font-weight:bold; -fx-text-fill: DIMGREY");
            		          }
            		        });
                
        	}
        	}
        	catch(Exception e2) {
        		
        	}
        });
        
        
        

        ////////////////////////////////////////////////////////////////
        gp.setVgap(15);
        gp.setHgap(25);
        gp.setStyle("-fx-background-color: white;-fx-Border-color: DARKORANGE;-fx-Border-width:4;");
        gp.add(hbox, 1, 1);
        gp.add(t_CheckInvalidFile, 1, 3);
        gp.add(vbox1, 1, 4);
        gp.add(vbox2, 1, 5);
        Scene scene0 = new Scene(gp, 750, 660);
        
        
        primaryStage.setTitle("Equation File Browser Interface");
        primaryStage.setScene(scene0);
        primaryStage.show();
	}
	
	 
	// checker method 
	public static boolean checkValidFile(String s) {
		CursorStack<String> stack = new CursorStack<>(1000);
		boolean res=true;
		
		///////////////////
		if(s.length()>0) {
		for(int i=0;i<s.length();i++) {
			
			int firstIndex = s.indexOf('<', i);
	        if (firstIndex == -1) {
	            break;
	        }

	        int finalIndex = s.indexOf('>', firstIndex + 1);
	        if (finalIndex == -1) {
	            res = false;
	        }

	        String tag = s.substring(firstIndex + 1, finalIndex);
	        if (tag.startsWith("/")) {
	            if (stack.isEmpty()) {
	                res = false;
	            }
	            String startTag = stack.pop();
	            if (!tag.substring(1).equals(startTag)) {
	                res = false;
	            }
	        } else {
	            stack.push(tag);
	        }
	        i = finalIndex;
		 }
		}
		else {
			res=false;
		}
		///////////////
		
		return res;
	}

	public static boolean checkBalance(String s) {
		CursorStack<String> balancedStack = new CursorStack<>(1000);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c + "") {
			case "{":
			case "[":
			case "(":
			case "<":
			
				balancedStack.push(c + "");
				break;
			case "}":
			case "]":
			case ")":
			case ">":

				if (balancedStack.isEmpty())
					return false;

				char o = balancedStack.pop().charAt(0);

				if (!((c == '}' && o == '{') || (c == ']' && o == '[') || (c == ')' && o == '(')
						|| (c == '>' && o == '<')))
					return false;
			}
		}
		return (balancedStack.isEmpty()) ? true : false;
	}
	
	public static boolean checkValidEquation(String equation) {
	    CursorStack<Character> stack = new CursorStack<>(1000);
	    boolean res = true;
	    equation = equation.replaceAll("\\s", ""); // to remove all spaces, not trim (ex: of trim: " 1 2 " --> "1 2").
	    
	    //System.out.println("########## Checker Of Valid Equation ##########\n");
	    for(int i=0 ;i<equation.length() ;i++) {
	    	
	    	char c = equation.charAt(i);
	    	//////////////////////////////////////////////////////////////////////////////////////////
	    	//1) if in the first of equation or in the end of it there is operator --> false.
	    	// ex: +12 or 12-
	        if ((i == 0 || i == (equation.length()-1) ) && (c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^')) {
	        	if(i==0) {
	        		System.out.println("Invalid Equation: "+equation+"\n"
	        	                      +"Error: in the first of equation there is "+c);
	        	}
	        	else {
	        		System.out.println("Invalid Equation:"+equation+"\n"
	        						  +"Error: At the end of equation there is "+c);
	        	}
	        	System.out.println("--------------------------------------------------------------------");
	        	////////////////////
	        	
	            res = false;
	            break;
	        }
	        
		    //////////////////////////////////////////////////////////////////////////////////////////
	        //2) if in the first of equation or in the end of it there is incorrect parentheses --> false.
	        // ex: )1+2 or 1+2(
	        else if( (i==0 && c==')') || (i==(equation.length()-1) && c=='(')) {
	        	if(i==0) {
	        		System.out.println("Invalid Equation: "+equation+"\n"
	        	                      +"Error: in the first of equation there is incorrect parentheses '"+c+"'");
	        	}
	        	else {
	        		System.out.println("Invalid Equation:"+equation+"\n"
	        						  +"Error: At the end of equation there is incorrect parentheses '"+c+"'");
	        	}
	        	System.out.println("--------------------------------------------------------------------");
				////////////////////
	        	res = false;
	            break;
	        }
	        
	      //////////////////////////////////////////////////////////////////////////////////////////
	      //3) if there is an multiple operator respectively --> false.
          // ex: 2++2
	      else if((c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^') && !Character.isDigit(equation.charAt(i + 1))&&
	        		 equation.charAt(i + 1)!='(' && equation.charAt(i + 1)!=')' ) {
	        	
	        	System.out.println("Invalid Equation: "+equation+"\n"
	                      +"Error: there is multiple operator respectively ("+c+" and "+equation.charAt(i + 1)+")");
	        	System.out.println("--------------------------------------------------------------------");
				////////////////////
		        res = false;
		        break; 
	        }
	        
		   //////////////////////////////////////////////////////////////////////////////////////////
	       //4) if there is an parentheses'(' before the operator --> false.
	       // ex: (+3+4
	       else if( (c=='(') && ( (equation.charAt(i + 1)=='+')||(equation.charAt(i + 1)=='-')||(equation.charAt(i + 1)=='*')||
	        		                 (equation.charAt(i + 1)=='/')||(equation.charAt(i + 1)=='%')||(equation.charAt(i + 1)=='^') )){
	        	   System.out.println("Invalid Equation: "+equation+"\n"
        				             +"Error: there is parentheses '"+c+"' "+" before the operator("+equation.charAt(i + 1)+")");
		    	   System.out.println("--------------------------------------------------------------------");
					////////////////////
			        res = false;
			        break; 	
	        }
	        
		   //////////////////////////////////////////////////////////////////////////////////////////
	       //5) if there is an parentheses'(' after the operand --> false.
		   // ex: 1(2+3
	        else if( (i>1) && (c=='(') && (Character.isDigit(equation.charAt(i - 1)) ) ) {
	        	
	        		System.out.println("Invalid Equation: "+equation+"\n"
				                      +"Error: there is parentheses '"+c+"' "+" after the operand("+equation.charAt(i + 1)+")");
	        	
	        	 System.out.println("--------------------------------------------------------------------");
					////////////////////
			        res = false;
			        break; 
	        }
		   //////////////////////////////////////////////////////////////////////////////////////////
	       //6) if there is an parentheses')' after the operator --> false.
		   // ex: 1+2+) //
	        else if(  (c==')') && ( (equation.charAt(i - 1)=='+')||(equation.charAt(i - 1)=='-')||(equation.charAt(i - 1)=='*')||
	                 (equation.charAt(i - 1)=='/')||(equation.charAt(i - 1)=='%')||(equation.charAt(i - 1)=='^') )){
	        			System.out.println("Invalid Equation: "+equation+"\n"
	        							  +"Error: there is parentheses '"+c+"' "+" after the operator("+equation.charAt(i - 1)+")");
	        			System.out.println("--------------------------------------------------------------------");
	        			////////////////////
	        			res = false;
	        			break; 	
	        }
		   //////////////////////////////////////////////////////////////////////////////////////////
	       //7) if there is an parentheses')' before the operand --> false.
		   // ex: 1+2)6
	        else if((i<equation.length()-1) && (c==')') && (Character.isDigit(equation.charAt(i + 1)) ) ) {
	        		System.out.println("Invalid Equation: "+equation+"\n"
				                      +"Error: there is parentheses '"+c+"' "+" before the operand("+equation.charAt(i + 1)+")");
	        	
	        	 System.out.println("--------------------------------------------------------------------");
					////////////////////
			        res = false;
			        break; 
	        }
		   //////////////////////////////////////////////////////////////////////////////////////////
	       //8) if it's just a number !!!!!!!!!!!!!!!!!!!!!!!!
	        else if(!(c == '+' && c == '-' && c == '*' && c == '/' && c == '%' && c == '^')) {
	
	        	int no_operator=0; // if there is no operator --> increase no_operator 1.
	        	no_operator++;
	        	
	        	 if(no_operator==equation.length()-1) { // if no_operator equal to the length-1 --> there is no operator.
		        	System.out.println("Invalid Equation: "+equation+"\n"
		                      +"Error: it's not equation");
		        	System.out.println("--------------------------------------------------------------------");
					////////////////////
		        	res = false;
		        	break;
	        }
	        }
	        
	        
	      //////////////////////////////////////////////////////////////////////////////////////////
	        else {
	        	stack.push(c);
	        }

	    }
	    // if it's valid equation
		if (res == true) {
			//System.out.println("");
			System.out.println("Valid Equation: "+equation);
			System.out.println("--------------------------------------------------------------------");
		}
	    
	    return res;
	}
	
	
	
	
	// get and calculate PostFix
	public static String convert_infix_to_postfix(String infix) {
	    CursorStack<String> stack = new CursorStack<>(1000);
	    String postfix = "";
	    infix=infix.replaceAll(" ", "");
	    for (int i = 0; i < infix.length(); i++) {
	        char c = infix.charAt(i);
	        if (Character.isDigit(c) || Character.isLetter(c)) {
	            postfix += c;
	        } else if (c == '(') {
	            stack.push(c + "");
	        } else if (c == ')') {
	            while (!stack.isEmpty() && !stack.peek().equals("(")) {
	                postfix += " " + stack.pop();
	            }
	            if (!stack.isEmpty() && stack.peek().equals("(")) {
	                stack.pop();
	            }
	        } else {
	            while (!stack.isEmpty() && Precedence(c) <= Precedence(stack.peek().charAt(0))) {
	                postfix += " " + stack.pop();
	            }
	            postfix += " ";
	            stack.push(c + "");
	        }
	    }
	    
	    while (!stack.isEmpty()) {
	        postfix += " " + stack.pop();
	    }
	    return postfix.trim();
	}

	private static int Precedence(char operator) {
	    switch (operator) {
	        case '+':
	        case '-':
	            return 1;
	        case '*':
	        case '/':
	        case '%':
	            return 2;
	        case '^':
	            return 3;
	        default:
	            return 0;
	    }
	}

	public static int calculatePostFix(String s) {
		CursorStack<Double> stack = new CursorStack<>(1000);
		
		// to get the two operand
		double x=0;
		double y=0;
		
		String c[]=s.split(" ");
		///////////////////
		for(int i=0;i<c.length;i++) {
			
		///////////////////////////////////////////////////////////////
		/* if the char is operator --> pop two element(get two element)
		   from stack and make the operator on them */
			 
			if((c[i].equals("+") || c[i].equals("-") || c[i].equals("*") || c[i].equals("/") || c[i].equals("%") || c[i].equals("^")))  {
				
				  y = stack.pop(); // r u forget it's LIFO (last in first out)
	              x = stack.pop();
	              
	              char c1 = c[i].charAt(0);
	              
					switch (c1) {
						case '+': {
							stack.push(x+y);
							break;
						}
						case '-':{
							stack.push(x-y);
							break;
						}
						case '*':{
							stack.push(x*y);
							break;
						}
						case '/':{
							if (y == 0) {
		                        System.out.println("Error: Cannot divide by zero");   
		                    }
							else {
								stack.push(x/y);
							}
							break;
						}
						case '%':{
							System.out.println(x+"%"+y);
							stack.push(x%y);
							break;
						}
						case '^':{
							System.out.println(x+"^"+y);
							stack.push(Math.pow(y, x));
							break;
						}
						default:{
							System.out.println("there is no operator");
						}
					}
			 }
			 ///////////
			// if it's operand
			 else if(Character.isDigit(c[i].charAt(0))) {
				 stack.push((double)Integer.parseInt(c[i])); 
			 }
		}
		
		double res=stack.pop();
		
		return (int)res;
	}
	
	
	//////////////////////////////////////////////////////
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
