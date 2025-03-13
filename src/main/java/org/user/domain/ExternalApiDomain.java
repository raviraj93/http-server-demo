package org.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExternalApiDomain {
    private int externalUserId;
    private int taskId;
    private String taskTitle;
    private boolean isCompleted;
}
