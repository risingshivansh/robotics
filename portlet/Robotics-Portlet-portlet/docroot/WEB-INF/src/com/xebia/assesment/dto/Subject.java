package com.xebia.assesment.dto;

/**
 * 
 * @author Shivansh Sharma
 *
 * Represent the contract of the subject 
 */
public interface Subject
{
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public String notifyObservers(Observer ob, String msg, boolean lb, boolean ow);
}
