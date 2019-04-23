package pdl;

import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import pdl.ast.KripkeFrame;
import pdl.translator.PdlResult;
import pdl.translator.PdlUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main
{
    private static final String defaultName = "output.smt2";

    public static void main(String[] args)
    {
        Options options = new Options();
        CommandLineParser commandLineParser = new DefaultParser();

        options.addOption(Option.builder("i").longOpt("input").desc("input file").hasArg().build());
        options.addOption(Option.builder("o").longOpt("output").desc("output file").hasArg().build());

        try
        {
            CommandLine command = commandLineParser.parse(options, args);

            String output = defaultName;
            PdlResult result;
            if (command.hasOption("i"))
            {
                String inputFile = command.getOptionValue("i").trim();
                String pdl = new String(Files.readAllBytes(Paths.get(inputFile)), StandardCharsets.UTF_8);
                result = PdlUtils.runCVC4(pdl);
                output = inputFile;
            }
            else
            {
                StringBuilder stringBuilder = new StringBuilder();
                Scanner scanner = new Scanner(System.in);

                while (scanner.hasNextLine())
                {
                    stringBuilder.append(scanner.nextLine()).append("\n");
                }

                result = PdlUtils.runCVC4(stringBuilder.toString());
            }

            if (command.hasOption("o"))
            {
                output = command.getOptionValue("o").trim();
            }
            String name = FilenameUtils.removeExtension(output);
            FileUtils.writeStringToFile(new File(name + ".smt2"),
                    result.smtProgram, StandardCharsets.UTF_8);
            result.writeToDotFile(name + ".dot", true);
            if(result.satResult.equals("sat"))
            {
                KripkeFrame frame = result.getResultFrame();
                FileUtils.writeStringToFile(new File(name + ".kripke"),
                        frame.toString(), StandardCharsets.UTF_8);
            }
        } catch (ParseException exception)
        {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar pdl.jar ", options);
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
