package org.example;

import org.example.Pod.classes.PodmanCmd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Let's deploy an application in a Pod using PodmanCmd
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the pod: ");
        String podName = scanner.nextLine();
        System.out.print("Enter the name of the registry path to pull the image from: ");
        String registryPath = scanner.nextLine();
        PodmanCmd podmanCmd = new PodmanCmd(podName,registryPath);
        System.out.print("Enter the ports to expose the container on host_port:container_port: ");
        String ports = scanner.nextLine();
        podmanCmd.deployInPod(ports);

        // Now, let's do the same with PodmanHttp
        /*
        System.out.print("Enter the name of the pod: ");
        podName = scanner.next();
        PodmanHttp podmanHttp = new PodmanHttp(podName, registryPath);
        System.out.print("Enter the port to expose the container on: ");
        port = scanner.nextInt();
        podmanHttp.deployInPod(port);
        */
        scanner.close();
    }
}