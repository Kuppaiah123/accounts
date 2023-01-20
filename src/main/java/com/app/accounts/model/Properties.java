package com.app.accounts.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
@Setter@Getter
public class Properties {
    public String msg;
    public String buildVersion;
    public Map<String,String> mailDetails;
    public List<String> activeBranches;
    public Properties(String msg, String buildVersion, Map<String, String> mailDetails, List<String> activeBranches) {
        this.msg = msg;
        this.buildVersion = buildVersion;
        this.mailDetails = mailDetails;
        this.activeBranches = activeBranches;
    }


}
