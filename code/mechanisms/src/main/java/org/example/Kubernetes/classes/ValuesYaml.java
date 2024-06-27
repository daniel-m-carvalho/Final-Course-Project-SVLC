package org.example.Kubernetes.classes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.Kubernetes.interfaces.Yaml;

import java.util.HashMap;
import java.util.Map;

public class ValuesYaml implements Yaml {
    private Map<String, Object> values;

    public ValuesYaml() {
        this.values = new HashMap<>();
    }

    public void setProperty(String key, Object value) {
        this.values.put(key, value);
    }

    public Object getProperty(String key) {
        return this.values.get(key);
    }

    @Override
    public String toYaml() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "ValuesYaml{" +
                "values=" + values +
                '}';
    }
}
