package com.github.viniciusintech;

import static com.github.viniciusintech.GitUpdater.updateProject;

public class Main {
    public static void main(String[] args) {
        String projectPath = "/caminho/para/seu/projeto";
        updateProject(projectPath);
    }
}