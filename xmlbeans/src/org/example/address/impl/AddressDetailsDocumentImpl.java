/*
 * An XML document type.
 * Localname: AddressDetails
 * Namespace: http://www.example.org/address
 * Java type: org.example.address.AddressDetailsDocument
 *
 * Automatically generated - do not modify.
 */
package org.example.address.impl;
/**
 * A document containing one AddressDetails(@http://www.example.org/address) element.
 *
 * This is a complex type.
 */
public class AddressDetailsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.example.address.AddressDetailsDocument
{
    
    public AddressDetailsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDRESSDETAILS$0 = 
        new javax.xml.namespace.QName("http://www.example.org/address", "AddressDetails");
    
    
    /**
     * Gets the "AddressDetails" element
     */
    public org.example.address.AddressDetailsDocument.AddressDetails getAddressDetails()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.example.address.AddressDetailsDocument.AddressDetails target = null;
            target = (org.example.address.AddressDetailsDocument.AddressDetails)get_store().find_element_user(ADDRESSDETAILS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AddressDetails" element
     */
    public void setAddressDetails(org.example.address.AddressDetailsDocument.AddressDetails addressDetails)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.example.address.AddressDetailsDocument.AddressDetails target = null;
            target = (org.example.address.AddressDetailsDocument.AddressDetails)get_store().find_element_user(ADDRESSDETAILS$0, 0);
            if (target == null)
            {
                target = (org.example.address.AddressDetailsDocument.AddressDetails)get_store().add_element_user(ADDRESSDETAILS$0);
            }
            target.set(addressDetails);
        }
    }
    
    /**
     * Appends and returns a new empty "AddressDetails" element
     */
    public org.example.address.AddressDetailsDocument.AddressDetails addNewAddressDetails()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.example.address.AddressDetailsDocument.AddressDetails target = null;
            target = (org.example.address.AddressDetailsDocument.AddressDetails)get_store().add_element_user(ADDRESSDETAILS$0);
            return target;
        }
    }
    /**
     * An XML AddressDetails(@http://www.example.org/address).
     *
     * This is a complex type.
     */
    public static class AddressDetailsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.example.address.AddressDetailsDocument.AddressDetails
    {
        
        public AddressDetailsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAME$0 = 
            new javax.xml.namespace.QName("http://www.example.org/address", "Name");
        private static final javax.xml.namespace.QName ADDRESS1$2 = 
            new javax.xml.namespace.QName("http://www.example.org/address", "Address1");
        private static final javax.xml.namespace.QName ADDRESS2$4 = 
            new javax.xml.namespace.QName("http://www.example.org/address", "Address2");
        private static final javax.xml.namespace.QName ZIP$6 = 
            new javax.xml.namespace.QName("http://www.example.org/address", "ZIP");
        private static final javax.xml.namespace.QName EMAIL$8 = 
            new javax.xml.namespace.QName("http://www.example.org/address", "Email");
        
        
        /**
         * Gets the "Name" element
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Name" element
         */
        public org.apache.xmlbeans.XmlString xgetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Name" element
         */
        public void setName(java.lang.String name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NAME$0);
                }
                target.setStringValue(name);
            }
        }
        
        /**
         * Sets (as xml) the "Name" element
         */
        public void xsetName(org.apache.xmlbeans.XmlString name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NAME$0);
                }
                target.set(name);
            }
        }
        
        /**
         * Gets the "Address1" element
         */
        public java.lang.String getAddress1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESS1$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Address1" element
         */
        public org.apache.xmlbeans.XmlString xgetAddress1()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESS1$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Address1" element
         */
        public void setAddress1(java.lang.String address1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESS1$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADDRESS1$2);
                }
                target.setStringValue(address1);
            }
        }
        
        /**
         * Sets (as xml) the "Address1" element
         */
        public void xsetAddress1(org.apache.xmlbeans.XmlString address1)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESS1$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ADDRESS1$2);
                }
                target.set(address1);
            }
        }
        
        /**
         * Gets the "Address2" element
         */
        public java.lang.String getAddress2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESS2$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Address2" element
         */
        public org.apache.xmlbeans.XmlString xgetAddress2()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESS2$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Address2" element
         */
        public void setAddress2(java.lang.String address2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ADDRESS2$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ADDRESS2$4);
                }
                target.setStringValue(address2);
            }
        }
        
        /**
         * Sets (as xml) the "Address2" element
         */
        public void xsetAddress2(org.apache.xmlbeans.XmlString address2)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ADDRESS2$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ADDRESS2$4);
                }
                target.set(address2);
            }
        }
        
        /**
         * Gets the "ZIP" element
         */
        public java.lang.String getZIP()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZIP$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ZIP" element
         */
        public org.apache.xmlbeans.XmlString xgetZIP()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ZIP$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "ZIP" element
         */
        public void setZIP(java.lang.String zip)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZIP$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ZIP$6);
                }
                target.setStringValue(zip);
            }
        }
        
        /**
         * Sets (as xml) the "ZIP" element
         */
        public void xsetZIP(org.apache.xmlbeans.XmlString zip)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ZIP$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ZIP$6);
                }
                target.set(zip);
            }
        }
        
        /**
         * Gets the "Email" element
         */
        public java.lang.String getEmail()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EMAIL$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "Email" element
         */
        public org.apache.xmlbeans.XmlString xgetEmail()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EMAIL$8, 0);
                return target;
            }
        }
        
        /**
         * Sets the "Email" element
         */
        public void setEmail(java.lang.String email)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(EMAIL$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(EMAIL$8);
                }
                target.setStringValue(email);
            }
        }
        
        /**
         * Sets (as xml) the "Email" element
         */
        public void xsetEmail(org.apache.xmlbeans.XmlString email)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(EMAIL$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(EMAIL$8);
                }
                target.set(email);
            }
        }
    }
}
