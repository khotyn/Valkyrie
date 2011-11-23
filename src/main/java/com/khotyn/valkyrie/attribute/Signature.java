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

import com.khotyn.valkyrie.constant.ConstantUTF8;

/**
 * Attribute Signature
 * 
 * @author khotyn
 */
public class Signature extends Attribute {

    public static ConstantUTF8 name   = SIGNATURE;
    protected int              length = 2;
    private int                signatureIndex;

    public int getSignatureIndex() {
        return signatureIndex;
    }

    public void setSignatureIndex(int signatureIndex) {
        this.signatureIndex = signatureIndex;
    }

}
