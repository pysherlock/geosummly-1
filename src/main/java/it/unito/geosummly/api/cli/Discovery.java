package it.unito.geosummly.api.cli;

import java.io.IOException;

import it.unito.geosummly.DiscoveryOperator;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class Discovery {
	
	private String inFile=null;
	private String outDir=null;
	private int comb=5;
	private int randNum=-1;
	
	public void run (String[] args) throws IOException {
		Options options= initOptions(); //define list of options
		CommandLineParser parser=new PosixParser(); //create the command line parser
		HelpFormatter formatter = new HelpFormatter();
		Boolean mandatory=false; //check the presence of mandatory options
		String helpUsage="geosummly discovery -input <path/to/file.csv> -output <path/to/dir> [options]";
		String helpFooter="\n------------------------------------------------------------------"
				+ "\nThe options input, output are mandatory."
				+ "\nInput file has to be a .csv either of singles or grid-shaped venues."
				+ "\nThe output consists of a file of standard deviation values for the single categories, "
				+ "a file of deltad values for single and combination of categories."
				+ "\n------------------------------------------------------------------"
				+ "\nExamples:"
				+ "\ngeosummly discovery -input path/to/file.csv -output path/to/dir -combination 3";
		
		try {
			CommandLine line = parser.parse(options, args);
			
			if(line.hasOption("input") && line.hasOption("output")) {
				inFile=line.getOptionValue("input");
				//file extension has to be csv
				if(!inFile.endsWith("csv")) {
					formatter.printHelp(helpUsage, "\ncommands list:", options, helpFooter);
					System.exit(-1);
				}
				outDir=line.getOptionValue("output");
				mandatory=true;
			}
			
			if(line.hasOption("combination")) {
				comb=Integer.parseInt(line.getOptionValue("combination"));
				if(comb<0) {
					formatter.printHelp(helpUsage, "\ncommands list:", options, helpFooter);
					System.exit(-1);
				}		
			}
			
			if(line.hasOption("rnum")) {
				randNum=Integer.parseInt(line.getOptionValue("rnum"));
				if(randNum<=0) {
					formatter.printHelp(helpUsage, "\ncommands list:", options, helpFooter);
					System.exit(-1);
				}		
			}
			
			if (line.hasOption("help") || !mandatory) {
                formatter.printHelp(helpUsage,"\ncommands list:", options, helpFooter);
                System.exit(-1);
            }
			
			DiscoveryOperator d=new DiscoveryOperator();
			d.execute(inFile, outDir, comb, randNum);
			
		}
		catch(ParseException | NumberFormatException e) {
			System.out.println("Unexpected exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	 
	 
	@SuppressWarnings("static-access")
	private Options initOptions() {
			 
		 Options options = new Options(); //define list of options
		 
		//option input
		 options.addOption(OptionBuilder.withLongOpt("input").withDescription("set the input file")
						.hasArg().withArgName("path/to/file").create("I"));
		 
		 //option output
		 options.addOption(OptionBuilder.withLongOpt("output").withDescription("set the output directory")
					.hasArg().withArgName("path/to/dir").create("O"));
		 
		 //option combination
		 options.addOption(OptionBuilder.withLongOpt("combination").withDescription("set the number of categories combinations for minpts estimation. Default 5")
					.hasArg().withArgName("arg").create("c"));
		 
		//option rnum
		 options.addOption(OptionBuilder.withLongOpt("rnum").withDescription("set the number of cells, taken randomly, chosen for the discovery operation.")
					.hasArg().withArgName("arg").create("r"));
		 
		//more options
		options.addOption("H", "help", false, "print the command list");
		
		return options;
	}
}
