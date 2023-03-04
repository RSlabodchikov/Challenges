package com.slabodchikov.challenges.adventofcode.y2022.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Roman Slabodchikov on 15.12.2022
 */
public class Part1 {

    private static final Long MAX_SIZE = 100000L;
    private static final Long TOTAL_SPACE = 70000000L;
    private static final Long REQUIRED_FREE_SPACE = 30000000L;

    private static final String COMMAND_PROMPT = "$";
    private static final String CHANGE_DIRECTORY = "cd";

    private static final String DIRECTORY = "dir";

    private static final String NAVIGATE_PREVIOUS_DIR = "..";
    private static final String NAVIGATE_ROOT_DIR = "/";

    public static void main(String[] args) throws FileNotFoundException {
        File inputData = new File("C:\\Users\\Roman\\Documents\\adventofcode\\day7\\input.txt");
        Scanner scanner = new Scanner(inputData);

        Directory rootDirectory = buildFilesystemTree(scanner);
        System.out.println(calculateSumOfDirectoriesLessThanLimit(rootDirectory));
        System.out.println(findSmallestDirectorySizeMoreThanThreshold(rootDirectory));
    }

    private static Directory buildFilesystemTree(Scanner scanner) {
        Directory rootDirectory = new Directory("/", null);
        Directory currentActiveDirectory = rootDirectory;

        String currentLine;
        String[] arguments;
        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            arguments = currentLine.split(" ");
            if (arguments.length > 0) {
                if (arguments[0].equals(COMMAND_PROMPT)) {
                    if (arguments[1].equals(CHANGE_DIRECTORY)) {
                        if (arguments[2].equals(NAVIGATE_PREVIOUS_DIR)) {
                            currentActiveDirectory = currentActiveDirectory.getParentDirectory();
                        } else if (arguments[2].equals(NAVIGATE_ROOT_DIR)) {
                            currentActiveDirectory = rootDirectory;
                        } else {
                            currentActiveDirectory = new Directory(arguments[2], currentActiveDirectory);
                        }
                    }
                } else {
                    if (!arguments[0].equals(DIRECTORY)) {
                        currentActiveDirectory.addFile(Long.parseLong(arguments[0]));
                    }
                }
            }
        }

        return rootDirectory;
    }

    private static Long findSmallestDirectorySizeMoreThanThreshold(Directory rootDirectory) {
        long currentSpace = TOTAL_SPACE - rootDirectory.getSize();
        long threshold = REQUIRED_FREE_SPACE - currentSpace;
        return findDirectoriesSizesMoreThanThreshold(rootDirectory, threshold)
            .stream().min(Long::compareTo).orElse(rootDirectory.getSize());
    }

    private static List<Long> findDirectoriesSizesMoreThanThreshold(Directory directory, long threshold) {
        List<Long> directoriesSizes = new ArrayList<>();
        if (directory.getSize() >= threshold) {
            directoriesSizes.add(directory.getSize());
        }
        if (directory.getSubDirectories().size() > 0) {
            directoriesSizes.addAll(directory.getSubDirectories().stream()
                .map(dir -> findDirectoriesSizesMoreThanThreshold(dir, threshold))
                .flatMap(List::stream).toList());
        }

        return directoriesSizes;
    }

    private static long calculateSumOfDirectoriesLessThanLimit(Directory directory) {
        long size = 0L;
        if (directory.getSize() < MAX_SIZE) {
            size += directory.getSize();
        }
        if (directory.getSubDirectories().size() > 0) {
            size += directory.getSubDirectories().stream().mapToLong(Part1::calculateSumOfDirectoriesLessThanLimit).sum();
        }

        return size;
    }
}
