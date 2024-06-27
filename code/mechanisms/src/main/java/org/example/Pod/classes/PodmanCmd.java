package org.example.Pod.classes;

import org.example.Pod.interfaces.PodmanRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PodmanCmd implements PodmanRunner {

    static String podName;
    String registryPath;

    public PodmanCmd(String podName, String registryPath) {
        PodmanCmd.podName = podName;
        this.registryPath = registryPath;
    }

    @Override
    public void deployInPod(String ports) {
        // The command to create a new Pod
        String[] createPodCommand = {"podman", "pod", "create", "--name", podName, "-p", ports };

        // The command to run a container in the Pod
        String[] runContainerCommand = {"podman", "run", "--pod", podName, "-d", this.registryPath};

        // Execute the commands
        try {
            executeCommand(createPodCommand, "Creating pod...");
            executeCommand(runContainerCommand, "Running container in pod...");
            System.out.println("The application has been deployed in the pod '"+ podName + "' successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void executeCommand(String[] command, String message) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();

        // Print the output of the command
        BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while (outputReader.readLine() != null) {
            System.out.println(message);
        }

        // Print the error of the command
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String errorLine;
        while ((errorLine = errorReader.readLine()) != null) {
            System.out.println("Error: " + errorLine);
        }

        // Wait for the command to finish
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new Exception("Command failed with exit code " + exitCode);
        }
    }
}