package com.xzit.garden.bean.dto;

import com.xzit.garden.bean.entity.MaintenanceplanResApply;
import com.xzit.garden.bean.entity.ResApply;

public class MaintenanceResApplyDto extends MaintenanceplanResApply {
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
