package com.app.accounts.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "accounts")
@Getter@Setter@ToString
public class AccountServiceConfig {

    public String msg;
    public String buildVersion;
    public Map<String,String> mailDetails;
    public List<String> activeBranches;
}
