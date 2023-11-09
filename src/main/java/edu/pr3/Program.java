package edu.pr3;

import edu.pr3.logs.LogInfo;
import edu.pr3.parsers.LogParser;
import edu.pr3.writers.AdocWriter;
import edu.pr3.writers.LogResultWriter;
import edu.pr3.writers.MdWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

@SuppressWarnings("all")
public class Program {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Program() {
    }

    public static void main(String[] args) throws IOException {
        var arguments = parseArgs(args);
        var dateFromArg = arguments.get("from");
        var dateToArg = arguments.get("to");
        var dateFrom = dateFromArg == null ? null : dateFromArg.toString();
        var dateTo = dateToArg == null ? null : dateToArg.toString();
        LogResultWriter resultWriter = arguments.get("format").equals("markdown") ? new MdWriter() : new AdocWriter();
        Path outPath = null;
        try {
            outPath = Path.of(arguments.get("out").toString());
        } catch (Exception e) {
            System.out.println("Wrong out path");
            System.exit(1);
        }

        BufferedReader reader;
        var logs = new ArrayList<LogInfo>();
        var parser = new LogParser();
        try {
            reader = new BufferedReader(new FileReader(arguments.get("path").toString()));
            String line = reader.readLine();

            while (line != null) {
                var log = parser.parse(line);
                if (!isDatesSuit(log, dateFrom, dateTo)) {
                    continue;
                }
                logs.add(log);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        resultWriter.writeResultsToFile(logs.toArray(new LogInfo[0]), outPath);
    }

    private static Namespace parseArgs(String[] args) {
        var argParser = ArgumentParsers.newFor("program").build();
        argParser.addArgument("--path")
                .type(String.class)
                .required(true);
        argParser
                .addArgument("--from");
        argParser
                .addArgument("--to");
        argParser
                .addArgument("--format")
                .choices("markdown", "adoc")
                .setDefault("markdown");
        argParser.addArgument("--out")
                .type(String.class)
                .required(true);

        Namespace ns = null;
        try {
            ns = argParser.parseArgs(args);
        } catch (ArgumentParserException e) {
            argParser.handleError(e);
            System.exit(1);
        }
        return ns;
    }

    private static LocalDateTime parseDate(String value) {
        return LocalDateTime.parse(value, FORMATTER);
    }

    private static boolean isDatesSuit(LogInfo info, String from, String to) {
        LocalDate dateFrom = null;
        LocalDate dateTo = null;
        if (from != null) {
            try {
                dateFrom = LocalDate.parse(from, FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        if (to != null) {
            try {
                dateTo = LocalDate.parse(to, FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        return (dateFrom == null || info.dateTime.toLocalDate().isAfter(dateFrom))
                && (dateTo == null || info.dateTime.toLocalDate().isBefore(dateTo));
    }
}
