package com.github.viniciusintech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitUpdater {
    public static void updateProject(String projectPath) {
        try {
            // Navegar até a pasta do projeto
            ProcessBuilder builder = new ProcessBuilder();
            builder.directory(new java.io.File(projectPath));

            // Comando git pull
            builder.command("git", "pull");

            // Iniciar o processo
            Process process = builder.start();

            // Ler a saída do comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar o processo terminar
            int exitCode = process.waitFor();
            System.out.println("\nComando finalizado com código: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
