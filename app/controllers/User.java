package controllers;

import java.util.List;

import model.ProductModel;
import model.UserModel;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.user.*;

public class User extends Controller
{
	@Transactional
	public static Result showUser(String email)
	{
		return ok(showUser.render(getUser(email)));
	}
	
	@Transactional
	public static Result showAllUsers()
	{
		return ok(showAllUsers.render(getAllUsers()));
	}
	
	@Transactional
	public static UserModel getUser(String email)
	{
		return JPA.em().find(UserModel.class, email);
	}
	
	@Transactional
	public static List<UserModel> getAllUsers()
	{
		return JPA.em().createQuery("SELECT a FROM UserModel a", UserModel.class).getResultList();
	}
	
}