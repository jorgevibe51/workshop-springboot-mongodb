/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *
 * @author Jorge
 */
public class URL {
    public static String decodeParam(String text) throws UnsupportedEncodingException{
        return URLDecoder.decode(text, "UTF-8");
    }
    
}
