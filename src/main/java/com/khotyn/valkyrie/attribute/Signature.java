/**
 * Project: Valkyrie
 * 
 * File Created at Nov 22, 2011
 * $Id$
 * 
 * This is some code written by khotyn, and you are free to distribute those code for any use.
 * Welcome to my website: http://khotyn.com
 * Free we will be!
 */
package com.khotyn.valkyrie.attribute;

/**
 * Attribute Signature
 * 
 * @author khotyn
 * 
 */
public class Signature extends Attribute {
    protected String name   = SIGNATURE;
    protected int    length = 2;
    private int      signatureIndex;

    public int getSignatureIndex() {
        return signatureIndex;
    }

    public void setSignatureIndex(int signatureIndex) {
        this.signatureIndex = signatureIndex;
    }

}
