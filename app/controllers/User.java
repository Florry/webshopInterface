package controllers;

import com.avaje.ebean.Ebean;

import model.UserModel;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.user.*;

public class User extends Controller
{
	
	public static Result showUser(String email)
	{
		return ok(showUser.render(getUser(email)));
	}
	
	public static UserModel getUser(String email)
	{
		return Ebean.find(UserModel.class, email);
	}
	
}
