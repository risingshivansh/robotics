package com.xebia.assesment.dto;

/**
 * 
 * @author Shivansh Sharma
 * Represent the contract behaviors for Observer
 *
 */
public interface Observer
{
    public String getMessages(String availability);

    public Double getDistanceInput();

    public Double getWeightInput();
}
