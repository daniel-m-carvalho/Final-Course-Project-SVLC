package org.example.Pod.classes;

import org.example.Pod.interfaces.PodmanRunner;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PodmanHttp implements PodmanRunner {
    String podName;
    String registryPath;

    public PodmanHttp(String podName, String registryPath) {
        this.podName = podName;
        this.registryPath = registryPath;
    }

    @Override
    public void deployInPod(String ports) {
        String [] portsArray = ports.split(":");
        // The endpoint to create a new Pod
        String createPodEndpoint = "http://localhost:8080/v1.40/libpod/pods/create";
        String createPodPayload = "{ \"name\": \"" + podName + "\", \"portMappings\": [ { \"containerPort\": " + portsArray[1] + ", \"hostPort\": " + portsArray[0] + " } ] }";
        // The endpoint to run a container in the Pod
        String runContainerEndpoint = "http://localhost:8080/v1.40/libpod/containers/create";
        String runContainerPayload = "{ \"pod\": \"" + podName + "\", \"image\": \"" + registryPath + "\", \"detach\": true }";

        // Execute the requests
        try {
            executeRequest(createPodEndpoint, createPodPayload, "Creating pod...");
            executeRequest(runContainerEndpoint, runContainerPayload, "Running container in pod...");
            System.out.println("The application has been deployed in the pod '" + podName + "' successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeRequest(String endpoint, String payload, String message) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(endpoint))
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 201) {
            throw new Exception("Request failed with status code " + response.statusCode());
        }

        System.out.println(message);
    }
}
