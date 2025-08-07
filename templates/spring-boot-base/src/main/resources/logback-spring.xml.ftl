<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <!-- Console appender configuration -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <!-- Log pattern can be customized as needed -->
            <pattern>%d{yyyy-MM-dd HH:mm:ss} %-5level [%thread] %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- Set the default root log level for the project -->
    <root level="INFO">
        <appender-ref ref="STDOUT" />
    </root>

    <!-- Example: set a more verbose log level for your project packages -->
    <logger name="{{packageName}}" level="DEBUG"/>

    <!-- Example: reduce logging noise for Spring libraries -->
    <logger name="org.springframework" level="WARN"/>
    <logger name="org.hibernate" level="WARN"/>

</configuration>
