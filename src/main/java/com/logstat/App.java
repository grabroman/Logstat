
package com.logstat;

import com.logstat.model.Command;
import com.logstat.service.Controller;
import com.logstat.service.parser.ArgParser;
import com.logstat.service.parser.exceptions.NoInputFileException;


public class App {


    public static void main(String[] args) {
	try {
	    ArgParser x = new ArgParser();
	    Controller controller = new Controller();
	    Command comm = x.parseStart(args);
	    controller.execute(comm);
	} catch (NoInputFileException e) {
	    System.out.println("Please, set a input file.");
	   
	} catch (Exception e) {
	    System.out.println("Something went wrong. \nError: \n" + e.getMessage());   
	}
    }
}
