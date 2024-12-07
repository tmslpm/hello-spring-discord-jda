package org.example.bll.service;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TemplateService {
  private final ResourceLoader resourceLoader;
  private final Mustache.Compiler templateCompiler;
  private final Map<String, Template> templateCache = new ConcurrentHashMap<>();

  public Template get(String templateName) {
    return templateCache.computeIfAbsent(templateName, this::loadAndCompileTemplate);
  }

  private Template loadAndCompileTemplate(String templateName) {
    final String location = "classpath:assets/templates/" + templateName;
    final Resource resource = resourceLoader.getResource(location);

    if (!resource.exists()) {
      throw new RuntimeException("Template not found at location: " + location);
    }

    try (BufferedReader reader = this.createBufferedReader(resource)) {
      return templateCompiler.compile(reader
        .lines()
        .collect(Collectors.joining(System.lineSeparator())));
    } catch (IOException e) {
      throw new RuntimeException("Failed to read template content from: " + location, e);
    }
  }

  @Contract("_ -> new")
  private @NotNull BufferedReader createBufferedReader(@NotNull Resource resource) throws IOException {
    return new BufferedReader(new InputStreamReader(
      resource.getInputStream(),
      StandardCharsets.UTF_8
    ));
  }

}