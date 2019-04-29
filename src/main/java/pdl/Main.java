package pdl;

import edu.uiowa.smt.TranslatorUtils;
import org.apache.commons.cli.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import pdl.ast.KripkeFrame;
import pdl.printers.PdlPrinter;
import pdl.translator.PdlResult;
import pdl.translator.PdlToSmtTranslator;
import pdl.translator.PdlUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main
{
    private static final String defaultName = "output.smt2";

    public static void main(String[] args)
    {
        Options options = new Options();
        CommandLineParser commandLineParser = new DefaultParser();

        options.addOption(Option.builder("i").longOpt("input").desc("input file").hasArg().build());
        options.addOption(Option.builder("o").longOpt("output").desc("output file").hasArg().build());
        options.addOption(Option.builder("t").longOpt("time").desc("Time limit in milliseconds. Default 30000").hasArg().build());

        try
        {
            CommandLine command = commandLineParser.parse(options, args);

            int timeLimit = 30000; // 30 seconds
            if(command.hasOption("t"))
            {
                String time = command.getOptionValue("t").trim();
                timeLimit = Integer.parseInt(time);
            }
            String output = defaultName;
            PdlResult result;
            if (command.hasOption("i"))
            {
                String inputFile = command.getOptionValue("i").trim();
                String pdl = new String(Files.readAllBytes(Paths.get(inputFile)), StandardCharsets.UTF_8);
                result = PdlUtils.runCVC4(pdl, timeLimit);
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
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(frame.toString());
                PdlPrinter printer = new PdlPrinter();
                printer.visit(result.pdlProgram.getFormula());
                stringBuilder.append(printer.print() + "\n");
                stringBuilder.append("Satisfying states: ");
                List<String> satisfyingStates = result.satisfyingStates
                        .stream()
                        .map(s -> TranslatorUtils.getFriendlyAtom(s, KripkeFrame.atomReplacement))
                        .collect(Collectors.toList());
                stringBuilder.append(satisfyingStates + "\n");
                FileUtils.writeStringToFile(new File(name + ".kripke"),
                        stringBuilder.toString(), StandardCharsets.UTF_16);
            }
            else
            {
                FileUtils.writeStringToFile(new File(name + ".kripke"),
                        result.satResult, StandardCharsets.UTF_16);
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
