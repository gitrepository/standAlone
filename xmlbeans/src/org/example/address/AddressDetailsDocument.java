/*
 * An XML document type.
 * Localname: AddressDetails
 * Namespace: http://www.example.org/address
 * Java type: org.example.address.AddressDetailsDocument
 *
 * Automatically generated - do not modify.
 */
package org.example.address;


/**
 * A document containing one AddressDetails(@http://www.example.org/address) element.
 *
 * This is a complex type.
 */
public interface AddressDetailsDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddressDetailsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s624D672556F3AB8362436848E141E393").resolveHandle("addressdetails7ef5doctype");
    
    /**
     * Gets the "AddressDetails" element
     */
    org.example.address.AddressDetailsDocument.AddressDetails getAddressDetails();
    
    /**
     * Sets the "AddressDetails" element
     */
    void setAddressDetails(org.example.address.AddressDetailsDocument.AddressDetails addressDetails);
    
    /**
     * Appends and returns a new empty "AddressDetails" element
     */
    org.example.address.AddressDetailsDocument.AddressDetails addNewAddressDetails();
    
    /**
     * An XML AddressDetails(@http://www.example.org/address).
     *
     * This is a complex type.
     */
    public interface AddressDetails extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddressDetails.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s624D672556F3AB8362436848E141E393").resolveHandle("addressdetails815felemtype");
        
        /**
         * Gets the "Name" element
         */
        java.lang.String getName();
        
        /**
         * Gets (as xml) the "Name" element
         */
        org.apache.xmlbeans.XmlString xgetName();
        
        /**
         * Sets the "Name" element
         */
        void setName(java.lang.String name);
        
        /**
         * Sets (as xml) the "Name" element
         */
        void xsetName(org.apache.xmlbeans.XmlString name);
        
        /**
         * Gets the "Address1" element
         */
        java.lang.String getAddress1();
        
        /**
         * Gets (as xml) the "Address1" element
         */
        org.apache.xmlbeans.XmlString xgetAddress1();
        
        /**
         * Sets the "Address1" element
         */
        void setAddress1(java.lang.String address1);
        
        /**
         * Sets (as xml) the "Address1" element
         */
        void xsetAddress1(org.apache.xmlbeans.XmlString address1);
        
        /**
         * Gets the "Address2" element
         */
        java.lang.String getAddress2();
        
        /**
         * Gets (as xml) the "Address2" element
         */
        org.apache.xmlbeans.XmlString xgetAddress2();
        
        /**
         * Sets the "Address2" element
         */
        void setAddress2(java.lang.String address2);
        
        /**
         * Sets (as xml) the "Address2" element
         */
        void xsetAddress2(org.apache.xmlbeans.XmlString address2);
        
        /**
         * Gets the "ZIP" element
         */
        java.lang.String getZIP();
        
        /**
         * Gets (as xml) the "ZIP" element
         */
        org.apache.xmlbeans.XmlString xgetZIP();
        
        /**
         * Sets the "ZIP" element
         */
        void setZIP(java.lang.String zip);
        
        /**
         * Sets (as xml) the "ZIP" element
         */
        void xsetZIP(org.apache.xmlbeans.XmlString zip);
        
        /**
         * Gets the "Email" element
         */
        java.lang.String getEmail();
        
        /**
         * Gets (as xml) the "Email" element
         */
        org.apache.xmlbeans.XmlString xgetEmail();
        
        /**
         * Sets the "Email" element
         */
        void setEmail(java.lang.String email);
        
        /**
         * Sets (as xml) the "Email" element
         */
        void xsetEmail(org.apache.xmlbeans.XmlString email);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.example.address.AddressDetailsDocument.AddressDetails newInstance() {
              return (org.example.address.AddressDetailsDocument.AddressDetails) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.example.address.AddressDetailsDocument.AddressDetails newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.example.address.AddressDetailsDocument.AddressDetails) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.example.address.AddressDetailsDocument newInstance() {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.example.address.AddressDetailsDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.example.address.AddressDetailsDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.example.address.AddressDetailsDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.example.address.AddressDetailsDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.example.address.AddressDetailsDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.example.address.AddressDetailsDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.example.address.AddressDetailsDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.example.address.AddressDetailsDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.example.address.AddressDetailsDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.example.address.AddressDetailsDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.example.address.AddressDetailsDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.example.address.AddressDetailsDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.example.address.AddressDetailsDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.example.address.AddressDetailsDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.example.address.AddressDetailsDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.example.address.AddressDetailsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.example.address.AddressDetailsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.example.address.AddressDetailsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
