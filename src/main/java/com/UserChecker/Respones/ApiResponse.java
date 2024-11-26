package com.UserChecker.Respones;

import java.util.List;

import com.UserChecker.Entity.User;
import com.UserChecker.Entity.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ApiResponse {
	
	@JsonProperty("results")
    private List<UserDto> results;

    public List<UserDto> getResults() {
        return results;
    }

    public void setResults(List<UserDto> results) {
        this.results = results;
    }
}