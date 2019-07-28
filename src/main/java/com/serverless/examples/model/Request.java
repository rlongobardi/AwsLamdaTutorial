package com.serverless.examples.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
public class Request {

    private String firstName;

    private String lastName;
}
