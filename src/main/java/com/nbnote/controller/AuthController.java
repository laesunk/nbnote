package com.nbnote.controller;

import com.nbnote.auth.Token;
import com.nbnote.auth.TokenService;
import com.nbnote.model.Auth;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by K on 2017. 6. 18..
 */

@Path("/auth")
public class AuthController  {
    private static final TokenService tokenSvc = new TokenService();

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Auth newToken(@PathParam("param") String id) throws Exception {
        Token token = tokenSvc.createToken(id);
        Auth auth = null;
        try {
             auth = new Auth(token.getUserId(), token.getToken());
        }catch (Exception e){
            e.printStackTrace();
        }
        return auth;
    }

    @DELETE
    public Response logout(String token) throws Exception {
        tokenSvc.deleteToken(token);

        return Response.ok().build();
    }

    public static boolean checkToken(String id, String token) throws Exception {
        String tokenById = tokenSvc.getToken(id).getToken();
        if (tokenById.equals(token)){
            return true;
        }
        return false;

    }
}
