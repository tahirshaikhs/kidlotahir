package com.tahir.tahirkidlo;

public class tahirmodel {

    String namestr,emailstr,dobstr;

    public tahirmodel(String namestr,String emailstr,String dobstr) {
        this.namestr = namestr;
        this.emailstr = emailstr;
        this.dobstr = dobstr;

    }

    public String getNamestr() {
        return namestr;
    }

    public void setNamestr(String namestr) {
        this.namestr = namestr;
    }

    public String getEmailstr() {
        return emailstr;
    }

    public void setEmailstr(String emailstr) {
        this.emailstr = emailstr;
    }

    public String getDobstr() {
        return dobstr;
    }

    public void setDobstr(String dobstr) {
        this.dobstr = dobstr;
    }
}
