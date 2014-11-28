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

package br.com.uol.pagseguro.example.application;

import java.util.List;

import br.com.uol.pagseguro.domain.Authorization;
import br.com.uol.pagseguro.domain.Permission;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.service.authorization.AuthorizationSearchService;

public class SearchAuthorizationsByDate {

    public static void main(String[] args) {

        List<Authorization> authorizations = null; 

        try {

        	authorizations = AuthorizationSearchService.searchByDate(PagSeguroConfig.getApplicationCredentials(), null, null, 0, 0);

        } catch (PagSeguroServiceException e) {
            System.err.println(e.getMessage());
        }
        
        if (authorizations != null) {
        	for (Authorization authorization : authorizations) {
            	if (authorization != null) {
                    System.out.println("code: " + authorization.getCode());
                    System.out.println("reference: " + authorization.getReference());
                    List<Permission> permissions = authorization.getPermissions();
                    for (Permission permission : permissions) {
        				System.out.println("Permission " + permission.getPermission() + " - Status: " + permission.getStatus());
        			}
                }
    		}
		} else {
			System.out.println("You don't have any authorizations");
		}
    }

    private SearchAuthorizationsByDate() {
    }
}