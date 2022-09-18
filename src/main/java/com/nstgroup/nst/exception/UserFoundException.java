package com.nstgroup.nst.exception;

public class UserFoundException extends Exception{

    public UserFoundException(){
        super ("User with this Username is already there !! try with another");
    }

    public UserFoundException(String msg){super(msg);}
}
