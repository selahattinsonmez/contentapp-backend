package com.example.contentappbackend.Models;

import org.springframework.stereotype.Component;

@Component
public class isDeletedDTO {
    private boolean isDeleted;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
