/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vandita.pkg;

import javax.servlet.http.HttpServlet;

/**
 *
 * @author vandita
 */
public class Payment extends HttpServlet{
    
    String useremail, transid, date;

    public Payment(String useremail, String transid, String date) {
        this.useremail = useremail;
        this.transid = transid;
        this.date = date;
    }
    
    

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
