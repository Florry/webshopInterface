package controllers;

import play.mvc.*;

import views.html.*;

public class Application extends Controller
{
	public static Result home()
	{
		return ok(index.render("Welcome", null));
	}
}
