package com.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Message(
		@JsonProperty String message
		) {
	
}
