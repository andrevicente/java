/*
 ************************************************************************
 Copyright [2011] [PagSeguro Internet Ltda.]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ************************************************************************
 */

package br.com.uol.pagseguro.domain;

import java.util.HashMap;
import java.util.Map;

import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;

/**
 * Represents an PagSeguro application identification
 */
public class ApplicationCredentials extends Credentials {

    private static final int HASH_SIZE = 3;

    /**
     * PagSeguro production application ID
     */
    private String productionAppId;

    /**
     * PagSeguro production application key
     */
    private String productionAppKey;

    /**
     * PagSeguro sandbox application ID
     */
    private String sandboxAppId;
    
    /**
     * PagSeguro sandbox application key
     */
    private String sandboxAppKey;
    
    /**
     * PagSeguro authorization code
     */
    private String authorizationCode;

    /**
     * Initializes a newly created instance of this type with the specified arguments
     * 
     * @param productionAppId
     *            the production pagseguro application ID. Max length 60 characters.
     * @param productionAppKey
     *            the production pagseguro application key. A sequence of 32 characters
     */
    public AccountCredentials(String productionAppId, String productionAppKey) throws PagSeguroServiceException {

        if (productionAppId == null || "".equals(productionAppId.trim())
        		|| productionAppKey == null || "".equals(productionAppKey.trim())) {
            throw new PagSeguroServiceException("Application Credentials not set.");
        }

        this.productionAppId = productionAppId.trim();
        this.productionAppKey = productionAppKey.trim();
    }
    
    /**
     * Initializes a newly created instance of this type with the specified arguments
     * 
     * @param productionAppId
     *            the production pagseguro application ID. Max length 60 characters.
     * @param productionAppKey
     *            the production pagseguro application Key. A sequence of 32 characters
     * @param authorizationCode
     *            the pagseguro authorization Code. A sequence of 32 characters
     */
    public AccountCredentials(String productionAppId, String productionAppKey, String authorizationCode) throws PagSeguroServiceException {

        if (productionAppId == null || "".equals(productionAppId.trim())
        		|| productionAppKey == null || "".equals(productionAppKey.trim())
        		|| authorizationCode == null || "".equals(authorizationCode.trim())) {
            throw new PagSeguroServiceException("Application Credentials not set.");
        }

        this.productionAppId = productionAppId.trim();
        this.productionAppKey = productionAppKey.trim();
        this.authorizationCode = authorizationCode.trim();
    }
    
    /**
     * Initializes a newly created instance of this type with the specified arguments
     * 
     * @param productionAppId
     *            the production pagseguro application ID. Max length 60 characters.
     * @param productionAppKey
     *            the production pagseguro application Key. A sequence of 32 characters
     * @param sandboxAppId
     *            the sandbox pagseguro application ID. Max length 60 characters.
     * @param sandboxAppKey
     *            the sandbox pagseguro application Key. A sequence of 32 characters
     */
    public AccountCredentials(String productionAppId, String productionAppKey, String sandboxAppId, String sandboxAppKey)
    		throws PagSeguroServiceException {

    	if (productionAppId == null || "".equals(productionAppId.trim())
        		|| productionAppKey == null || "".equals(productionAppKey.trim())
        		|| sandboxAppId == null || "".equals(sandboxAppId.trim())
        		|| sandboxAppKey == null || "".equals(sandboxAppKey.trim())) {
            throw new PagSeguroServiceException("Application Credentials not set correctly.");
        }

        this.productionAppId = productionAppId.trim();
        this.productionAppKey = productionAppKey.trim();
        this.sandboxAppId = sandboxAppId.trim();
        this.sandboxAppKey = sandboxAppKey.trim();
    }

    /**
     * Initializes a newly created instance of this type with the specified arguments
     * 
     * @param productionAppId
     *            the production pagseguro application ID. Max length 60 characters.
     * @param productionAppKey
     *            the production pagseguro application Key. A sequence of 32 characters
     * @param sandboxAppId
     *            the sandbox pagseguro application ID. Max length 60 characters.
     * @param sandboxAppKey
     *            the sandbox pagseguro application Key. A sequence of 32 characters
     * @param authorizationCode
     *            the pagseguro authorization Code. A sequence of 32 characters
     */
    public AccountCredentials(String productionAppId, String productionAppKey, String sandboxAppId, String sandboxAppKey, String authorizationCode)
    		throws PagSeguroServiceException {

    	if (productionAppId == null || "".equals(productionAppId.trim())
        		|| productionAppKey == null || "".equals(productionAppKey.trim())
        		|| sandboxAppId == null || "".equals(sandboxAppId.trim())
        		|| sandboxAppKey == null || "".equals(sandboxAppKey.trim())
        		|| authorizationCode == null || "".equals(authorizationCode.trim())) {
            throw new PagSeguroServiceException("Application Credentials not set correctly.");
        }

        this.productionAppId = productionAppId.trim();
        this.productionAppKey = productionAppKey.trim();
        this.sandboxAppId = sandboxAppId.trim();
        this.sandboxAppKey = sandboxAppKey.trim();
        this.authorizationCode = authorizationCode.trim();
    }
    
    /**
     * @return the application ID
     */
    public String getAppId() {
    	if (PagSeguroConfig.isSandboxEnvironment())
            return this.sandboxAppId;
        return this.productionAppId;
    }

    /**
     * @param productionAppId
     *            the production application ID account to set. Max length 60 characters.
     */
    public void setProductionAppId(String productionAppId) {
        this.productionAppId = productionAppId;
    }
    
    /**
     * @param sandboxAppId
     *            the sandbox application ID account to set. Max length 60 characters.
     */
    public void setSandboxAppId(String sandboxAppId) {
        this.sandboxAppId = sandboxAppId;
    }
    
    /**
     * @return the application key
     */
    public String getAppKey() {
    	if (PagSeguroConfig.isSandboxEnvironment())
            return this.sandboxAppKey;
        return this.productionAppKey;
    }

    /**
     * @param productionAppkey
     *            the production application key account to set. Max length 32 characters.
     */
    public void setProductionAppKey(String productionAppKey) {
        this.productionAppKey = productionAppKey;
    }
    
    /**
     * @param sandboxAppkey
     *            the sandbox application key account to set. Max length 32 characters.
     */
    public void setSandboxAppKey(String sandboxAppKey) {
        this.sandboxAppKey = sandboxAppKey;
    }

    /**
     * @return the authorization code
     */
    public String getAuthorizationCode() {
        return this.authorizationCode;
    }

    /**
     * @param authorizationCode
     *            the authorization Code. Max length 30 characters.
     */
    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    /**
     * @return array a map of name value pairs that compose this set of application credentials
     * @throws PagSeguroServiceException
     */
    @Override
    public Map<Object, Object> getAttributes() throws PagSeguroServiceException {

        Map<Object, Object> attributeMap = new HashMap<Object, Object>(HASH_SIZE);
        
        if (PagSeguroConfig.isSandboxEnvironment()) {
            if (this.sandboxAppId == null || "".equals(this.sandboxAppId) 
            		||this.sandboxAppKey == null || "".equals(this.sandboxAppKey)) {
                throw new PagSeguroServiceException("Sandbox credentials not set.");
            }
            attributeMap.put("appId", this.sandboxAppId);
            attributeMap.put("appKey", this.sandboxAppKey);
        } else {
        	attributeMap.put("appId", this.productionAppId);
            attributeMap.put("appKey", this.productionAppKey);
        }
        
        if (this.authorizationCode != null || !"".equals(this.authorizationCode)) {
        	attributeMap.put("authorizationCode", this.authorizationCode);
        }
        
        

        return attributeMap;

    }

    /**
     * @return a string that represents the current object
     */
    @Override
    public String toString() {
        return this.productionAppId + " (production app Id) - " + this.productionAppkey + " (production app key) - "
        		+ this.sandboxAppId + " (sandbox app Id) - " + this.sandboxAppKey + " (sandbox app key) - "
        		+ this.authorizationCode + " (authorization Code)";
    }
}
