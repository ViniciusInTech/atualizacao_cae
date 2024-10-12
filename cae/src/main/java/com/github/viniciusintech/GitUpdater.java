package com.github.viniciusintech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitUpdater {
    public static void updateProject(String projectPath) {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.directory(new java.io.File(projectPath));

            builder.command("git", "fetch", "--all");
            Process process = builder.start();
            printProcessOutput(process);
            process.waitFor();

            builder.command("git", "reset", "--hard", "origin/main");
            process = builder.start();
            printProcessOutput(process);
            process.waitFor();

            System.out.println("\nAtualização do repositório concluída com sucesso.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printProcessOutput(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
