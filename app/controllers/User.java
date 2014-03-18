package controllers;

import model.UserModel;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.user.*;

public class User extends Controller
{
	// public static Result showUser(String email)
	// {
	// List<UserModel> users = new ArrayList<UserModel>();
	// users.add(new UserModel.Builder("Persson@Persson.se", "bullshit",
	// "persson", "persson",
	// "strandvägen 2", "stockholm", "14463").build());
	// users.add(new UserModel.Builder("leif@1337.se", "Test", "Leifodor",
	// "1337son",
	// "Bergvägen 4", "stockholm", "14463").build());
	// users.add(new UserModel.Builder("cmon@letsgo.com", "password", "Comon",
	// "Letsgo",
	// "TORSGATAN 2", "stockholm",
	// "14463").telephone("0703487264").dob("1980-02-12")
	// .build());
	// for (UserModel user : users)
	// {
	// if (user.getEmail().equals(email))
	// {
	// return ok(showUser.render(user));
	// }
	// }
	// return notFound(email);
	// }
	
	public static Result showUser(String email)
	{
		return ok(showUser.render(getUser(email)));
	}
	
	public static UserModel getUser(String email)
	{
		return Ebean.find(UserModel.class, email);
	}
	
}
