package org.example.Kubernetes.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Templates {

    private String convertMapToYaml(Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String createDeploymentTemplate() {
        Map<String, Object> deployment = new HashMap<>();
        // fill in the structure of the deployment...
        return convertMapToYaml(deployment);
    }

    public String createServiceTemplate() {
        Map<String, Object> service = new HashMap<>();
        // fill in the structure of the service...
        return convertMapToYaml(service);
    }

    public String createConfigMapTemplate() {
        Map<String, Object> configMap = new HashMap<>();
        // fill in the structure of the ConfigMap...
        return convertMapToYaml(configMap);
    }

    public String createSecretTemplate() {
        Map<String, Object> secret = new HashMap<>();
        // fill in the structure of the Secret...
        return convertMapToYaml(secret);
    }

    public String createPersistentVolumeClaimTemplate() {
        Map<String, Object> pvc = new HashMap<>();
        // fill in the structure of the PersistentVolumeClaim...
        return convertMapToYaml(pvc);
    }

    public String createIngressTemplate() {
        Map<String, Object> ingress = new HashMap<>();
        // fill in the structure of the Ingress...
        return convertMapToYaml(ingress);
    }
}