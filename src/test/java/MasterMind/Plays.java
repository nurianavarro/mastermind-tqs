package MasterMind;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class Plays {
    int LENGTH = 4;
    int turn = 9;
    
    @Test
    public void testPlay1() throws FileNotFoundException, IOException {
    	//Play 1: the user wins at first
    	System.out.println("PLAY 1: ");
    	View view1 = new View(LENGTH);
        Model model1 = new Model(LENGTH, turn);
        Controller controller1 = new Controller(view1, model1);        
        
        String file1;
        String read_combination1;
        String[] combination1;
        file1 = "/Users/nurianavarrojuliana/git/mastermind-tqs/src/test/java/MasterMind/Plays_AutomatedTest_1.txt";
        FileReader f1 = new FileReader(file1);
        BufferedReader b1 = new BufferedReader(f1);
        
        int numLines1 = 0;
        ArrayList<Integer> randomPattern1 = new ArrayList<Integer>();
        ArrayList<Integer> guessedPattern1 = new ArrayList<Integer>();
        
        while((read_combination1 = b1.readLine())!=null) {
        	combination1 = read_combination1.split("\\s+");
        	int[] values1 = new int[combination1.length];
        	for (int i=0; i<values1.length; i++) {
        		values1[i] = Integer.parseInt(combination1[i]);
    			
    			if (numLines1==0) {
    				randomPattern1.add(values1[i]);
            	} else {
            		guessedPattern1.add(values1[i]);
            		
            	}
        	}
        	if (numLines1 == 0)
        		model1.setRandomPattern(randomPattern1);
        	else {
        		model1.setGuessedPattern(guessedPattern1);
        		System.out.println("GUESSED PATTERN: " + model1.getGuessedPattern());
        		System.out.println("RANDOM PATTERN: " + model1.getRandomPattern());
        		assertTrue(model1.isFilled());
                model1.checkResult();
                assertFalse(controller1.isPlaying());
        	}
        	
            numLines1++;
        }
        b1.close();
    }
    
    @Test
    public void testPlay2() throws FileNotFoundException, IOException {
    	//Play 2: the user introduces illegal combination and later wins
        System.out.println("PLAY 2: ");      
        View view2 = new View(LENGTH);
        Model model2 = new Model(LENGTH, turn);
        Controller controller2 = new Controller(view2, model2);
        
        String file2;
        String read_combination2;
        String[] combination2;
        file2 = "../Plays_AutomatedTest_2.txt";
        FileReader f2 = new FileReader(file2);
        BufferedReader b2 = new BufferedReader(f2);
        
        int numLines2 = 0;
        ArrayList<Integer> randomPattern2 = new ArrayList<Integer>();
        ArrayList<Integer> guessedPattern2 = new ArrayList<Integer>();
        
        while((read_combination2 = b2.readLine())!=null) {
        	combination2 = read_combination2.split("\\s+");
        	int[] values2 = new int[combination2.length];
        	for (int i=0; i<values2.length; i++) {
        		values2[i] = Integer.parseInt(combination2[i]);
    			
    			if (numLines2==0) {
    				randomPattern2.add(values2[i]);
            	} else {
            		guessedPattern2.add(values2[i]);
            		
            	}
        	}
        	if (numLines2 == 0)
        		model2.setRandomPattern(randomPattern2);
        	else if (numLines2 == 1) {
        		model2.setGuessedPattern(guessedPattern2);
        		System.out.println("GUESSED PATTERN: " + model2.getGuessedPattern());
        		assertFalse(model2.isFilled());
                model2.checkResult();
                assertTrue(controller2.isPlaying());
                model2.resetCountWhite();
                
        	}
        	else {
        		model2.setGuessedPattern(guessedPattern2);
        		System.out.println("GUESSED PATTERN: " + model2.getGuessedPattern());
        		System.out.println("RANDOM PATTERN: " + model2.getRandomPattern());
        		assertTrue(model2.isFilled());
                model2.checkResult();
                assertFalse(controller2.isPlaying());
        	}
        	
            numLines2++;
        }
        b2.close();
    }
    
    @Test
    public void testPlay3() throws FileNotFoundException, IOException {
    	//Play 3: the user introduces a wrong number and later wins
        
    	System.out.println("PLAY 3: ");      
    	View view3 = new View(LENGTH);
        Model model3 = new Model(LENGTH, turn);
        Controller controller3 = new Controller(view3, model3);
        
        String file3;
        String read_combination3;
        String[] combination3;
        file3 = "/Users/nurianavarrojuliana/git/mastermind-tqs/src/test/java/MasterMind/Plays_AutomatedTest_3.txt";
        FileReader f3 = new FileReader(file3);
        BufferedReader b3 = new BufferedReader(f3);
        
        int numLines3 = 0;
        ArrayList<Integer> randomPattern3 = new ArrayList<Integer>();
        ArrayList<Integer> guessedPattern3 = new ArrayList<Integer>();
        
        while((read_combination3 = b3.readLine())!=null) {
        	combination3 = read_combination3.split("\\s+");
        	int[] values3 = new int[combination3.length];
        	for (int i=0; i<values3.length; i++) {
        		values3[i] = Integer.parseInt(combination3[i]);
    			
    			if (numLines3==0) {
    				randomPattern3.add(values3[i]);
            	} else {
            		guessedPattern3.add(values3[i]);
            		
            	}
        	}
        	if (numLines3 == 0)
        		model3.setRandomPattern(randomPattern3);
        	else if (numLines3 == 1) {
        		model3.setGuessedPattern(guessedPattern3);
        		System.out.println("GUESSED PATTERN: " + model3.getGuessedPattern());
        		assertTrue(model3.isFilled());
                model3.checkResult();
                assertTrue(controller3.isPlaying());
                model3.resetCountWhite();
        	}
        	else {
        		model3.setGuessedPattern(guessedPattern3);
        		System.out.println("GUESSED PATTERN: " + model3.getGuessedPattern());
        		System.out.println("RANDOM PATTERN: " + model3.getRandomPattern());
        		assertTrue(model3.isFilled());
                model3.checkResult();
                assertFalse(controller3.isPlaying());
        	}
        	
            numLines3++;
        }
        b3.close();
    	
    }
        
    @Test
    public void testPlay4() throws FileNotFoundException, IOException { //No es pot fer amb fitxer pq la funció loop pilla un Scanner, i no se com es fa sino
    	//Play 4: the user writes "quit"
    	
    	System.out.println("PLAY 4: ");      
    	View view4 = new View(LENGTH);
        Model model4 = new Model(LENGTH, turn);
        MockController controller4 = new MockController(view4, model4);
        
        String file4;
        String read_combination4;
        String[] combination4;
        file4 = "/Users/nurianavarrojuliana/git/mastermind-tqs/src/test/java/MasterMind/Plays_AutomatedTest_4.txt";
        FileReader f4 = new FileReader(file4);
        BufferedReader b4 = new BufferedReader(f4);
        
        int numLines4 = 0;
        ArrayList<Integer> randomPattern4 = new ArrayList<Integer>();
        
        while((read_combination4 = b4.readLine())!=null) {
            if (numLines4==0) {
            	combination4 = read_combination4.split("\\s+");
            	int[] values4 = new int[combination4.length];
            	for (int i=0; i<values4.length; i++) {
            		values4[i] = Integer.parseInt(combination4[i]);
        			randomPattern4.add(values4[i]);
            	}
            	model4.setRandomPattern(randomPattern4);
                numLines4++;
        	}
        	else if (numLines4==1) {
        		Scanner input_quit = new Scanner(read_combination4);
        		System.out.println("INPUT: " + read_combination4);
                assertFalse(controller4.loop(input_quit));
        	}
        }
        b4.close();
    }
    
    @Test
    public void testPlay5() throws FileNotFoundException, IOException {
    	//Play 5: the user writes "reset"
    	System.out.println("PLAY 5: ");      
    	View view5 = new View(LENGTH);
        Model model5 = new Model(LENGTH, turn);
        MockController controller5 = new MockController(view5, model5);
        
        String file5;
        String read_combination5;
        String[] combination5;
        file5 = "/Users/nurianavarrojuliana/git/mastermind-tqs/src/test/java/MasterMind/Plays_AutomatedTest_5.txt";
        FileReader f5 = new FileReader(file5);
        BufferedReader b5 = new BufferedReader(f5);
        
        int numLines5 = 0;
        ArrayList<Integer> randomPattern5 = new ArrayList<Integer>();
        
        while((read_combination5 = b5.readLine())!=null) {
        	if (numLines5==0) {
            	combination5 = read_combination5.split("\\s+");
            	int[] values5 = new int[combination5.length];
            	for (int i=0; i<values5.length; i++) {
            		values5[i] = Integer.parseInt(combination5[i]);
        			randomPattern5.add(values5[i]);
            	}
            	model5.setRandomPattern(randomPattern5);
                numLines5++;
        	}
        	else if (numLines5==1) {
        		Scanner input_reset = new Scanner(read_combination5);
        		System.out.println("INPUT: " + read_combination5);
                assertTrue(controller5.loop(input_reset));
        	}
        }
        b5.close();
    }
    
    @Test
    public void testPlay6() throws FileNotFoundException, IOException {
    	//Play 6: player looses
    	System.out.println("PLAY 6: ");
    	View view6 = new View(LENGTH);
        Model model6 = new Model(LENGTH, turn);
        Controller controller6 = new Controller(view6, model6);       
        
        String file6;
        String read_combination6;
        String[] combination6;
        file6 = "/Users/nurianavarrojuliana/git/mastermind-tqs/src/test/java/MasterMind/Plays_AutomatedTest_6.txt";
        FileReader f6 = new FileReader(file6);
        BufferedReader b6 = new BufferedReader(f6);
        
        int numLines6 = 0;
        ArrayList<Integer> randomPattern6 = new ArrayList<Integer>();
        ArrayList<Integer> guessedPattern6 = new ArrayList<Integer>();
        
        while((read_combination6 = b6.readLine())!=null) {
        	combination6 = read_combination6.split("\\s+");
        	int[] values6 = new int[combination6.length];
        	for (int i=0; i<values6.length; i++) {
        		values6[i] = Integer.parseInt(combination6[i]);
    			
    			if (numLines6==0) {
    				randomPattern6.add(values6[i]);
            	} else {
            		guessedPattern6.add(values6[i]);
            		
            	}
        	}
        	if (numLines6 == 0)
        		model6.setRandomPattern(randomPattern6);
        	else if (numLines6 == 9) {
        		model6.setGuessedPattern(guessedPattern6);
        		System.out.println("GUESSED PATTERN: " + model6.getGuessedPattern());
        		System.out.println("THE CORRECT COMBINATION WAS: " + model6.getRandomPattern());
                assertTrue(model6.isFilled());
                model6.checkResult();
                assertFalse(controller6.isPlaying());
        	}
        	else {
        		model6.setGuessedPattern(guessedPattern6);
        		System.out.println("GUESSED PATTERN: " + model6.getGuessedPattern());
        		assertTrue(model6.isFilled());
                model6.checkResult();
                assertTrue(controller6.isPlaying());
                model6.resetCountWhite();
        	}
        	
            numLines6++;
        }
        b6.close();
    }
        
 }




