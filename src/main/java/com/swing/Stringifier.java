package com.swing;

/** 
 * Defines a class that converts objects to string representations. 
 * 
 * @author 
 * @version 
 */
public interface Stringifier {
    
    /**
     * Returns a string representation of the object. Should be able to handle
     * both receiving <code>null</code> and a String instance instead of the expected
     * instance type.
     * 
     * @param obj
     * @return
     */
    public String stringify(Object obj);

}
