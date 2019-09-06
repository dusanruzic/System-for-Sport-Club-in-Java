/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Milena
 */
public class Request implements Serializable{
    private int Operation;
    private Object data;

    public Request(int Operation, Object data) {
        this.Operation = Operation;
        this.data = data;
    }

    public Request() {
    }

    public int getOperation() {
        return Operation;
    }

    public void setOperation(int Operation) {
        this.Operation = Operation;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    
}
