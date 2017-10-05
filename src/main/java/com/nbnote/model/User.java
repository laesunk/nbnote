package com.nbnote.model;

import com.nbnote.response.JsonSerializable;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by K on 2017. 6. 29..
 */
public class User implements JsonSerializable {
  private String id;
  private String service;
  private String passwd;
  private String name;
  private String age;
  private String profile;
  private String email;
  private String role;
  private Date registerDate;
  private String token;

  public User() {}

  public User(String id, String service, String passwd, String name, String age, String profile, String email, Date registerDate) {
    this.id = id;
    this.service = service;
    this.passwd = passwd;
    this.name = name;
    this.age = age;
    this.profile = profile;
    this.email = email;
    this.registerDate = registerDate;
  }

  public User(String id, String email, String name, String passwd){
    this.id = id;
    this.email = email;
    this.passwd = passwd;
    this.name = name;

  }
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public JSONObject toJson() throws JSONException {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put( "id", this.id );
    jsonObject.put( "name", this.name );
    jsonObject.put( "age", this.age );
    jsonObject.put( "token", this.token );
    jsonObject.put( "profile", this.profile );
    jsonObject.put( "email", this.email );
    jsonObject.put( "role", this.role );
    jsonObject.put( "role", this.role );
    return jsonObject;
  }
}
