package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.MaintenanceRes;

public class MaintenanceResDto extends MaintenanceRes {
    private String resourcedescription;
    private String resourcename;

    public String getResourcedescription() {
        return resourcedescription;
    }

    public void setResourcedescription(String resourcedescription) {
        this.resourcedescription = resourcedescription;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }
}
