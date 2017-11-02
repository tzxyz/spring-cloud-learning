# Config Server

接口实现
`org.springframework.cloud.config.server.resource.ResourceController`

用于下载
```java
@RequestMapping(value = "/{name}/{profile}/{label}/**", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
public synchronized byte[] binary(@PathVariable String name,
        @PathVariable String profile, @PathVariable String label,
        HttpServletRequest request) throws IOException {
    String path = getFilePath(request, name, profile, label);
    return binary(name, profile, label, path);
}
```

配置(本地文件)
`org.springframework.cloud.config.server.environment.MultipleJGitEnvironmentRepository`

# Config Client
`ConfigServicePropertySourceLocator` 该类实现下载配置文件