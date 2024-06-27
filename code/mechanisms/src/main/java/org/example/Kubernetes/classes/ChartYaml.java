package org.example.Kubernetes.classes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.Kubernetes.interfaces.Yaml;

import java.util.List;
import java.util.Map;

public class ChartYaml implements Yaml {
    private String apiVersion = "v2";
    private String name;
    private String description;
    private String version;
    private String appVersion;
    private List<String> keywords;
    private Map<String, String> sources;
    private List<String> maintainers;
    private String home; // optional
    private String icon; // optional
    private List<String> dependencies; // optional
    private String type; // optional
    private Map<String, String> annotations;

    public ChartYaml() {}

    public ChartYaml(String name, String description, String version, String appVersion, List<String> keywords, Map<String, String> sources, List<String> maintainers) {
        this.name = name;
        this.description = description;
        this.version = version;
        this.appVersion = appVersion;
        this.keywords = keywords;
        this.sources = sources;
        this.maintainers = maintainers;
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

    public String getApiVersion() {
        return apiVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Map<String, String> getSources() {
        return sources;
    }

    public void setSources(Map<String, String> sources) {
        this.sources = sources;
    }

    public List<String> getMaintainers() {
        return maintainers;
    }

    public void setMaintainers(List<String> maintainers) {
        this.maintainers = maintainers;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return "ChartYaml{" +
                "apiVersion='" + apiVersion + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", keywords=" + keywords +
                ", sources=" + sources +
                ", maintainers=" + maintainers +
                ", home='" + home + '\'' +
                ", icon='" + icon + '\'' +
                ", dependencies=" + dependencies +
                ", type='" + type + '\'' +
                ", annotations=" + annotations +
                '}';
    }
}
